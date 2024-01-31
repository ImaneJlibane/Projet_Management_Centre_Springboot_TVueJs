<template>
  <div id="app">
    <nav  v-if="isNavbarPage" class="navbar navbar-expand-lg navbar-dark " style="background-color: #F5F5F5;">
      <div class="container-fluid">
       <img src="./assets/Logo2.png" alt="Logo">
        <!-- Left-aligned elements -->
        <div class="d-flex">
           
          <router-link to="/" class="navbar-link me-3">Home</router-link>
          <router-link to="/Courses" class="navbar-link me-3">Courses</router-link>
          <router-link to="/Espaceformateur" class="navbar-link me-3">Formateur</router-link>
          <router-link to="/Etudiant" class="navbar-link me-3">Etudiant</router-link>
          
          <!-- Add your logo here -->
         
        </div>

        <!-- Right-aligned login button -->
        <router-link to="/Login" class="btn login-btn">Login</router-link>
      </div>
    </nav>

    <!-- Your Vue.js content goes here -->
    <!-- For example, use Vue Router for navigation -->
    <router-view/>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
.navbar-link {
  color: #2c3e50;
  text-decoration: none;
  transition: background-color 0.3s;
  padding: 7px 17px; /* Adjust padding as needed */
}

.navbar-link:hover {
  background-color: #5519D2;
  color: #fff;
  border-radius: 1rem;
  padding: 8px 18px; /* Adjust padding for hover effect */
}
.navbar-link:focus {
  background-color: #5519D2;
  color: #fff;
  border-radius: 1rem;
  padding: 8px 18px; /* Adjust padding for hover effect */
}
.active-link {
  background-color: #5519D2;
  color: #fff;
  border-radius: 1rem;
  padding:8px 18px; /* Adjust padding for active link */
}

.login-btn {
  background-color:#FBAC14 ;
  color: #fff;
  border: none;
  margin-right:8px;
  width:80px;
  border-radius:25px;
}

.login-btn:hover {
  background-color: #5519D2;
}
.d-flex{
 margin-left:680px;
}
</style>
<script>
export default {
  computed: {
    isNavbarPage() {
      // Check if the current route is one of the navbar pages
      const navbarPages = ['/', '/Courses', '/Espaceformateur', '/Etudiant'];
      return navbarPages.includes(this.$route.path);
    }
  }
};
</script>