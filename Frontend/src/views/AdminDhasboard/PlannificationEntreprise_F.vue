<template>
    <div class="wrapper">
         
         <div class="body-overlay"></div>	 
       <!-------sidebar--design------------>
  
  <div id="sidebar">
      <div class="sidebar-header">
        <h3><img src="@/assets/StyleDashboard/img/logo.png" class="img-fluid" style="margin-bottom: 9px;"/><span style="color: black;">C</span>oding<span style="color: black;">G</span>uide</h3>
      </div>
      <ul class="list-unstyled component m-0 text-start">
          <li class="">
              <a href="AdminDashboard" class="dashboard"><i class="material-icons">dashboard</i>Gérer Assistant </a>
          </li>
  
          <li class="">
              <a href="GererFormateur_F" class="">
                  <i class="material-icons">extension</i>Gérer Formateur
              </a>
          </li>
  
          <li class="">
              <a href="GererEntreprise_F" class="">
                  <i class="material-icons">border_color</i>Gérer Entreprise
              </a>
          </li>
  
          <li class="">
              <a href="GererFormation_F" class="">
                  <i class="material-icons">grid_on</i>Gérer Formation
              </a>
          </li>
  
          <li class="">
            <a href="Feedback_F" class="">
                <i class="material-icons">grid_on</i>Formation FeedBack
            </a>
          </li>

          <li class="active">
              <a href="PlannificationEntreprise_F" class=""><i class="material-icons">date_range</i>Plannification</a>
          </li>

  
          <li class="">
              <a href="Login" class=""><i class="material-icons">logout</i>Logout </a>
          </li>
      </ul>
  </div>
  
  <!-------sidebar--design- close----------->
  
       
       
          <!-------page-content start----------->
       
          <div id="content">
           
          <!------top-navbar-start-----------> 
             
          <div class="top-navbar" style="margin-top: -7px;">
             <div class="xd-topbar">
               <div class="row">
                 <div class="col-2 col-md-1 col-lg-1 order-2 order-md-1 align-self-center">
                  <div class="xp-menubar">
                    <span class="material-icons text-white">signal_cellular_alt</span>
                </div>
               </div>
               
               <div class="col-md-5 col-lg-3 order-3 order-md-2">
                   <div class="xp-searchbar">
                     <form>
                      <div class="input-group">
                      <input type="search" class="form-control"
                      placeholder="Search">
                      <div class="input-group-append">
                         <button class="btn" type="submit" id="button-addon2">Go
                       </button>
                      </div>
                    </div>
                   </form>
                 </div>
               </div>
               
               
               <div class="col-10 col-md-6 col-lg-8 order-1 order-md-3">
                   <div class="xp-profilebar text-right">
                    <nav class="navbar p-0">
                     <ul class="nav navbar-nav flex-row ml-auto">					   
                     <li class="nav-item">
                       <a class="" href="#" data-toggle="">
                      <img src="@/assets/StyleDashboard/img/user.jpg" style="width:40px; border-radius:50%;"/>
                      <span class="xp-user-live"></span>
                     </a>
                     </li>
                     
                     
                     </ul>
                  </nav>
                 </div>
               </div>
               
             </div>
             
             <div class="xp-breadcrumbbar text-center">
                <h4 class="page-title">Dashboard Admin</h4>
             </div>
             
             
           </div>
          </div>
          <!------top-navbar-end----------->     
                 <!------main-content-start-----------> 
             
                 <div class="main-content">
               <div class="row">
                <div class="wrap" style="margin-top: -30px;">
      <div class="left">
        <DayPilotNavigator id="nav" :config="navigatorConfig" />
      </div>
      <div class="content" >
        <DayPilotCalendar id="dp" :config="config" ref="calendar" />
      </div>
    </div>
              
            </div> </div>				
                       
                 
                 
                 
                 
                 
             
    
                 
                 
              
    
    
                 
              
              
             
               </div>
            </div>
          
      </template>
     
     <style scoped>
     /* Import Bootstrap CSS from the "assets" folder */
     @import '@/assets/StyleDashboard/css/bootstrap.min.css';
     
     @import '@/assets/StyleDashboard/css/custom.css';
  
    </style>
    
    <script>
      import axios from 'axios';  
    import {DayPilot, DayPilotCalendar, DayPilotNavigator} from '@daypilot/daypilot-lite-vue'
    export default {
        name: 'Calendar',
    data: function() {
      return {
        events: [],
        navigatorConfig: {
          showMonths: 1,
          skipMonths: 1,
          selectMode: "Week",
          startDate: "2022-03-01",
          selectionDay: "2022-02-28",
          onTimeRangeSelected: args => {
            this.config.startDate = args.day;
          }
        },
        config: {
          viewType: "Week",
          startDate: "2022-02-28",
          durationBarVisible: false,
          timeRangeSelectedHandling: "Enabled",
          onTimeRangeSelected: async (args) => {
    const formateurs = await DayPilot.Modal.form([
        { name: 'Formation', id: 'formation', prompt: 'Entrez la formation:', type: 'text' },
        { name: 'formateur', id: 'formateur', prompt: 'Entrez le formateur :', type: 'text' },
        { name: 'entreprise', id: 'entreprise', prompt: 'Entrez l\'entreprise :', type: 'text' },
        { name: 'groupe', id: 'groupe', prompt: 'Entrez le groupe :', type: 'text' }

    ]);

    if (formateurs.canceled) {
        return;
    }

    const dp = this.$refs.calendar.control;
    dp.clearSelection();

    const eventText = `${formateurs.result.formateur} - ${formateurs.result.formation} - ${formateurs.result.entreprise}`;
    const eventId = DayPilot.guid();

    // Prepare data to be sent to the backend
    const eventData = {
        id: eventId,
        date: args.start,
        dateFin: args.end,
        formateur: formateurs.result.formateur,
        formation: formateurs.result.formation,
        entreprise: formateurs.result.entreprise,
        groupe: formateurs.result.groupe,

    };

   // Send data to the backend using Axios with your instance
axios.post('http://localhost:8080/planifierFormation/planifier', eventData)
  .then(response => {
    // Handle the success response
    console.log('Formateur saved successfully:', response.data);
    // Optionally, you can show a success message to the user
  })
  .catch(error => {
    // Handle the error
    console.error('Error saving plannidier:', error);
    // Optionally, you can show an error message to the user
  });


    // Add the event to the calendar
    dp.events.add({
        start: args.start,
        end: args.end,
        id: eventId,
        text: formateurs.result.formation,

    });
},
   
          eventDeleteHandling: "Disabled",
          onEventMoved: () => {
            console.log("Event moved");
          },
          onEventResized: () => {
            console.log("Event resized");
          },
        },
      }
    },
    props: {
    },
    components: {
      DayPilotCalendar,
      DayPilotNavigator
    },
    computed: {
      // DayPilot.Calendar object - https://api.daypilot.org/daypilot-calendar-class/
      calendar() {
        return this.$refs.calendar.control;
      }
    },
    methods: {
      loadEvents() {
        // placeholder for an HTTP call
        const events = [
          {
            id: 1,
            start: "2022-02-28T10:00:00",
            end: "2022-02-28T11:00:00",
            text: "Event 1",
            backColor: "#6aa84f",
            borderColor: "#38761d",
          },
          {
            id: 2,
            start: "2022-02-28T13:00:00",
            end: "2022-02-28T16:00:00",
            text: "Event 2",
            backColor: "#f1c232",
            borderColor: "#bf9000",
          },
          {
            id: 3,
            start: "2022-03-01T13:30:00",
            end: "2022-03-01T16:30:00",
            text: "Event 3",
            backColor: "#cc4125",
            borderColor: "#990000",
          },
          {
            id: 4,
            start: "2022-03-01T10:30:00",
            end: "2022-03-01T12:30:00",
            text: "Event 4"
          },
        ];
        this.calendar.update({events});
      },
    },
      mounted() {
        this.loadEvents();
        $(".xp-menubar").on('click', function () {
          $("#sidebar").toggleClass('active');
          $("#content").toggleClass('active');
        });
    
        $('.xp-menubar, .body-overlay').on('click', function () {
          $("#sidebar, .body-overlay").toggleClass('show-nav');
        });
    
        // Ensure the modal is properly initialized when the component is mounted
        $(document).ready(function () {
          $('#editEmployeeModal').modal({
            backdrop: 'static',
            keyboard: false
          });
        });
      },
     
    };
    </script>
    <style>
    .wrap {
      display: flex;
    }
    
    .left {
      margin-right: 10px;
    }
    
    .content {
      flex-grow: 1;
    }
    
    
    .calendar_default_event_inner {
      background: #2e78d6;
      color: white;
      border-radius: 5px;
      opacity: 0.9;
    }
    </style>