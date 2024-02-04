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
            <a href="AssistantDashboard" class="">
                <i class="material-icons">border_color</i>Gérer Entreprise
            </a>
        </li>

        <li class="active">
            <a href="Feedback_A" class="">
                <i class="material-icons">border_color</i>Formation Feedback
            </a>
        </li>

      <li class="">
          <a href="PlannificationEntreprise_A" class=""><i class="material-icons">date_range</i>Plannification</a>
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
             
          <div class="top-navbar">
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
                <div class="col-md-12">
                 <div class="table-wrapper">
                   
                 <div class="table-title">
                   <div class="row">
                     <div class="col-sm-6 p-0 flex justify-content-lg-start justify-content-center">
                      <h2 class="ml-lg-2">Formation FeedBack</h2>
                   </div>
                   </div>
                 </div>
                 
                 <table class="table table-striped table-hover">
          <thead>
            <tr>
              <th>
                <span class="custom-checkbox">
                  <input type="checkbox" id="selectAll">
                  <label for="selectAll"></label>
                </span>
              </th>
            <th>pedagogicalQualityRating</th>
            <th>rhythmRating</th>
            <th>courseSupportRating</th>
            <th>subjectMasteryRating</th>
            <th>formateur</th>
            <th>formation</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(employee, index) in employees" :key="employee.id">
              <td>
                <span class="custom-checkbox">
                  <input type="checkbox" :id="'checkbox' + (index + 1)" name="option[]" :value="index + 1">
                  <label :for="'checkbox' + (index + 1)"></label>
                </span>
              </td>
            <td>{{ employee.pedagogicalQualityRating }}</td>
            <td>{{ employee.rhythmRating }}</td>
            <td>{{ employee.courseSupportRating }}</td>
            <td>{{ employee.subjectMasteryRating }}</td>
            <td>{{ employee.formateur }}</td>
            <td>{{ employee.formation }}</td>
            </tr>
          </tbody>
        </table>
                 
                 <div class="clearfix">
                   <div class="hint-text">showing <b>1</b> out of <b>25</b></div>
                   <ul class="pagination">
                    <li class="page-item disabled"><a href="#">Previous</a></li>
                  <li class="page-item "><a href="#" class="page-link">1</a></li>
                  <li class="page-item "><a href="#" class="page-link">2</a></li>
                  <li class="page-item active"><a href="#" class="page-link">3</a></li>
                  <li class="page-item "><a href="#" class="page-link">4</a></li>
                  <li class="page-item "><a href="#" class="page-link">5</a></li>
                  <li class="page-item "><a href="#" class="page-link">Next</a></li>
                 </ul>
                 </div>
                 
                 
                 </div>
              </div>
              
            </div> </div>				 
                 
              
              
             
               </div>
            </div>
          
            <!------main-content-end----------->
      </template>
     
     <style scoped>
     /* Import Bootstrap CSS from the "assets" folder */
     @import '@/assets/StyleDashboard/css/bootstrap.min.css';
     
     @import '@/assets/StyleDashboard/css/custom.css';
  
    </style>
    
    <script>
  import axios from 'axios';  
    export default {
    
      data() {
        return {
          employees: [],
        };
  
  
      },
      mounted() {
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
      beforeMount() {
          this.getEmployees();
      },
  
      methods: {

      getEmployees() {
        fetch(`http://localhost:8080/api/feedback/all`)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then(data => {
                    // Set the entreprises data property with the fetched data
                    this.employees = data;
                })
                .catch(error => {
                    console.error('Error fetching or parsing data:', error);
                });
          },
  
  
     
  
  
  

      },
    };
    </script>
    