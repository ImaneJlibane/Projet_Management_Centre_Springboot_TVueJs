<template>
  <div class="wrapper">
       
       <div class="body-overlay"></div>	 
   

<div id="sidebar">
    <div class="sidebar-header">
        <h3><img src="@/assets/StyleDashboard/img/logo.png" class="img-fluid" style="margin-bottom: 9px;"/><span style="color: black;">C</span>oding<span style="color: black;">G</span>uide</h3>
    </div>
    <ul class="list-unstyled component m-0 text-start">


        <li class="active">
            <a href="AssistantDashboard" class="">
                <i class="material-icons">border_color</i>Gérer Entreprise
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
              <h4 class="page-title">Dashboard Assistant</h4>
           </div>
           
           
         </div>
        </div>
        
           
               <div class="main-content">
             <div class="row">
              <div class="col-md-12">
               <div class="table-wrapper">
                 
               <div class="table-title">
                 <div class="row">
                   <div class="col-sm-6 p-0 flex justify-content-lg-start justify-content-center">
                    <h2 class="ml-lg-2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Gérer  Entreprise</h2>
                 </div>
                 <div class="col-sm-6 p-0 flex justify-content-lg-end justify-content-center">
                   <a href="#" @click="addEmployee"  class="btn btn-success" data-toggle="modal">
                   <i class="material-icons">&#xE147;</i>
                   <span style="color: white;">Ajouter Entreprise</span>
                   </a>
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
          <th>Nom</th>
          <th>Email</th>
          <th>NumeroTél</th>
          <th>Adresse</th>
          <th>Url</th>
          <th>Actions</th>
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
          <td>{{ employee.nom }}</td>
          <td>{{ employee.numeroTel }}</td>
          <td>{{ employee.email }}</td>
          <td>{{ employee.adresse }}</td>
          <td>{{ employee.url }}</td>
            <td>
              <!-- Vue event handling for edit and delete actions -->
              <a href="#" @click="editEmployee(index)" class="edit">
                <i class="material-icons" data-toggle="tooltip" title="Edit" style="color:#FFC107;">&#xE254;</i>
              </a>
              <a href="#" @click="deleteEmployee(employee.id)" class="delete" style="color:#F44336;">
                <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
              </a>
            </td>
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
                      
      <div class="modal fade" tabindex="-1" id="addEmployeeModal" role="dialog">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Ajouter Entreprise</h5>
          <button type="button" class="close" @click="cancelAddEmployee" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <div class="form-group">
          <label>Nom</label>
        <input type="text" class="form-control" required v-model="employeeData.nom">
      </div>
      <div class="form-group">
          <label>Email</label>
        <input type="email" class="form-control" required v-model="employeeData.email">
      </div>
      <div class="form-group">
          <label>Numéro Téléphone</label>
        <input type="text" class="form-control" required v-model="employeeData.numeroTel">
      </div>
      <div class="form-group">
          <label>Adresse</label>
        <input type="text" class="form-control" required v-model="employeeData.adresse">
      </div>
      <div class="form-group">
          <label>Url</label>
        <input type="text" class="form-control" required v-model="employeeData.url">
      </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" @click="cancelAddEmployee" data-dismiss="modal">Cancel</button>
          <button type="button" class="btn btn-success"   @click="MethodaddEmployee" >Save</button>
        </div>
      </div>
    </div>
  </div>
  
            
      <div class="modal fade" tabindex="-1" id="editEmployeeModal" role="dialog">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
          <h5 class="modal-title">Modifier Entreprise</h5>
          <button type="button" class="close" @click="cancelEditedEmployee" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <div class="form-group">
          <label>Nom</label>
        <input type="text" class="form-control" required v-model="editEmployeeData.nom">
      </div>
      <div class="form-group">
          <label>Email</label>
        <input type="email" class="form-control" required v-model="editEmployeeData.email">
      </div>
      <div class="form-group">
          <label>Numéro Téléphone</label>
        <input type="text" class="form-control" required v-model="editEmployeeData.numeroTel">
      </div>
      <div class="form-group">
          <label>Adresse</label>
        <input type="text" class="form-control" required v-model="editEmployeeData.adresse">
      </div>
      <div class="form-group">
          <label>Url</label>
        <input type="text" class="form-control" required v-model="editEmployeeData.url">
      </div>
        </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" @click="cancelEditedEmployee" data-dismiss="modal">Cancel</button>
              <button type="button" class="btn btn-success"   @click="MethodeditEmployee" >Save</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  
             
      <div class="modal fade" tabindex="-1" id="deleteEmployeeModal" role="dialog">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Supprimer Entreprise</h5>
          <button type="button" class="close"  @click="cancelDeletedEmployee" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <p>Are you sure you want to delete this Records</p>
      <p class="text-warning"><small>this action Cannot be Undone,</small></p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" @click="cancelDeletedEmployee" data-dismiss="modal">Cancel</button>
          <button type="button" class="btn btn-success"   @click="MethoddeleteEmployee(idDeleteEmployee)" >Save</button>
        </div>
      </div>
    </div>
  
    
               
            
            
           
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
        idDeleteEmployee:'',
        employees: [],
        employeeData: {
          nom: '',
          email: '',
          numeroTel: '',
          adresse: '',
          url: '',

        },
        editEmployeeData: {
          nom: '',
          email: '',
          numeroTel: '',
          adresse: '',
          url: '',
        },
        editedEmployeeIndex: null,
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
      fetch(`http://localhost:8080/entreprise/all`)
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


    MethodaddEmployee() {
      fetch('http://localhost:8080/entreprise/save', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.employeeData)
            })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                this.getEmployees();
            })
            .catch(error => {
                console.error('Error adding entreprise:', error);
            });
        $('#addEmployeeModal').modal('hide');
      },

      MethoddeleteEmployee(id) {
          fetch(`http://localhost:8080/entreprise/delete/${id}`, {
              method: 'DELETE'
          })
              .then(data => {
                  console.log(data);
                  // After deleting, fetch and update the entreprise list
                  window.location.reload();
                  this.getEmployees();
                  $('#deleteEmployeeModal').modal('hide');

              })
              .catch(error => {
                  console.error('Error deleting entreprise:', error);
              });
},
 

    MethodeditEmployee() {
      fetch(`http://localhost:8080/entreprise/modif/${this.editEmployeeData.id}`, {
  method: 'PUT',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify(this.editEmployeeData) // Send this.entreprise, not this.patient
})
.then(response => {
  if (!response.ok) {
    throw new Error('Update failed'); // Handle non-200 status codes
  }
  return response.json();
})
.then(data => {
  console.log(data);
  this.getEmployees();

})
.catch(error => {
  console.error('Error updating entreprise:', error);
  // Handle the error appropriately, e.g., display an error message to the user
});
        // Show the edit modal
        $('#editEmployeeModal').modal('hide');
      },



    addEmployee() {
        $('#addEmployeeModal').modal('show');
      },
    deleteEmployee(id) {
        this.idDeleteEmployee=id;
        $('#deleteEmployeeModal').modal('show');
      },
    editEmployee(index) {
        this.editedEmployeeIndex = index;
        this.editEmployeeData = { ...this.employees[index] };
  
        // Show the edit modal
        $('#editEmployeeModal').modal('show');
      },
    cancelEditedEmployee() {
      // Close the edit modal
      $('#editEmployeeModal').modal('hide');
    },
    cancelAddEmployee() {
      // Close the edit modal
      $('#addEmployeeModal').modal('hide');
    },
    cancelDeletedEmployee() {
      // Close the edit modal
      $('#deleteEmployeeModal').modal('hide');
    },
    },
  };
  </script>
  