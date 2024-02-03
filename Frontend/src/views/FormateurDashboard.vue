<template>
  <div class="wrapper">
       
       <div class="body-overlay"></div>	 
          
     
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
              <h4 class="page-title">Dashboard Formateur</h4>
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
                    <h2 class="ml-lg-2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Gérer  Entreprise</h2>
                 </div>
                 </div>
               </div>
               
               
               
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
    
    };
    </script>
  
  