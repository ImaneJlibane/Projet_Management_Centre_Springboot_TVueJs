<template>
    <div class="wrapper">
         
         <div class="body-overlay"></div>  
      
  
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

          <li class="active">
            <a href="Groupe" class="">
                <i class="material-icons">grid_on</i>Affectation Groupe
            </a>
        </li>

          <li class="">
            <a href="Feedback_F" class="">
                <i class="material-icons">grid_on</i>Formation FeedBack
            </a>
        </li>

          <li class="">
              <a href="PlannificationEntreprise_F" class=""><i class="material-icons">date_range</i>Plannification</a>
          </li>
  
  
          <li class="">
              <a href="Login" class=""><i class="material-icons">logout</i>Logout </a>
          </li>
      </ul>
  </div>
  
  
       
       
       
       
          <div id="content">
       
             
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
               
           
               <div class="main-content">
             <div class="row">
              <div class="col-md-12">
               <div class="table-wrapper">
                 
                <div>
   
   
   <input type="text" v-model="groupName" placeholder="Enter Group Name">
   <button @click="saveToGroup">Save to Group</button>
   <table>
     <thead>
       <tr>
         <th>ID</th>
         <th>Email</th>
         <th>Name</th>
         <th>City</th>
         <th>Phone Number</th>
         <th>Date of Birth</th>
         <th>Formation</th>
         <th>Select</th>
       </tr>
     </thead>
     <tbody>
       <tr v-for="student in students" :key="student.id">
         <td>{{ student.id }}</td>
         <td>{{ student.email }}</td>
         <td>{{ student.nom }} {{ student.prenom }}</td>
         <td>{{ student.ville }}</td>
         <td>{{ student.numeroTel }}</td>
         <td>{{ student.dateNaissance }}</td>
         <td>{{ student.formation }}</td>
         <td><input type="checkbox" v-model="selectedStudents" :value="student.id"></td>
       </tr>
     </tbody>
   </table>
 </div>
               
               
               

               
               
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

export default {
  data() {
    return {
      students: [],
      selectedStudents: [],
      groupName: '' // Added data property for group name
    };
  },

  mounted() {
    this.fetchStudentsOrderedByFormation();

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
  methods: {
    fetchStudentsOrderedByFormation() {
      axios.get('http://localhost:8080/api/etudiants/orderedByFormation')
        .then(response => {
          this.students = response.data;
        })
        .catch(error => {
          console.error('Error fetching students:', error);
        });
    },
    saveToGroup() {
      if (this.groupName === '') {
        alert('Please enter a group name.');
        return;
      }

      if (this.selectedStudents.length === 0) {
        alert('Please select at least one student.');
        return;
      }

      const data = {
        groupName: this.groupName,
        studentIds: this.selectedStudents
      };

      axios.post('http://localhost:8080/api/group/save', data)
        .then(response => {
          console.log('Group saved successfully:', response.data);
          alert('Group saved successfully!');
          // Clear selected students and group name after saving
          this.selectedStudents = [];
          this.groupName = '';
        })
        .catch(error => {
          console.error('Error saving group:', error);
        });
    }
  }
};


    </script>
     <style scoped>
     /* Add your CSS styling here */
     table {
      margin-top: 30px;
       width: 100%;
       border-collapse: collapse;
     }
     
     th, td {
      
       padding: 8px;
       text-align: left;
     }
     
     th {
       background-color: #5519D2;    
        color:white;
        font-weight: 100;
     }
     button{
       background-color:#FBAC14;
       border:none;
       color:white;
       border-radius:30px;
       margin-left:30px;
     }
     </style>