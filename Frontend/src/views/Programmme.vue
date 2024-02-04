<template>
  <div>
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #F5F5F5;">
      <div class="container-fluid">
        <img src="@/assets/Logo2.png" alt="Logo">
        <div class="d-flex">
          <router-link to="/" class="navbar-link me-3">Home</router-link>
          <router-link to="/Courses" class="navbar-link me-3">Courses</router-link>
          <router-link to="/Espaceformateur" class="navbar-link me-3">Formateur</router-link>
          <router-link to="/Etudiant" class="navbar-link me-3">Etudiant</router-link>
        </div>
        <router-link to="/Login" class="btn login-btn">Login</router-link>
      </div>
    </nav>

    <div class="formation-details-container">
      <div v-if="formation" class="formation-details">
        <div class="formation-detail">
          <p><span class="detail-heading">Description:</span><br>{{ formation.description }}</p>
          <p><span class="detail-heading">Objectifs:</span><br>{{ formation.objectifs }}</p>
          <p><span class="detail-heading">Contenu:</span><br>{{ formation.motcle }}</p>
          <p><span class="detail-heading">Durée:</span><br>{{ formation.horaire }}</p>
        </div>
        <img src="@/assets/Group 2.png" alt="Image"  class="right-image">
      </div>
      <div v-else>
        <p>Loading...</p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      formation: null
    };
  },
 
  mounted() {
    this.fetchFormationDetails();
  },
  methods: {
    fetchFormationDetails() {
      const formationId = this.$route.params.formationId;
      console.log('Formation ID:', formationId);
      // Adjust your API endpoint as needed
      axios.get(`http://localhost:8081/formation/all/${formationId}`)
        .then(response => {
          this.formation = response.data;
        })
        .catch(error => {
          console.error('Error fetching formation details:', error);
        });
    }
  }
}
</script>

<style scoped>
/* Add your scoped styles here */
.formation-details-container {
  width: 50%;
  margin-right: 400px;
  margin-top: 30px;
}

.formation-details {
  text-align: left;
}

.formation-detail {
  width: 80%;
  margin: 0 auto;
}

.detail-heading {
  color: #5519D2;
  font-size: 31px;
}

.right-image {
margin-top:-2000px;
  margin-left:800px;
width:500px;
height:500px;
}
p{
font-family:"Gill Sans", sans-serif;
font-size:19px;
}
</style>
