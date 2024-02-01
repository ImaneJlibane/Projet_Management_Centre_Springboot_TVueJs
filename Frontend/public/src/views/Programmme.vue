<template>
    <div>
      <h2>Formation Details</h2>
      <div v-if="formation">
        <h3>{{ formation.titre }}</h3>
        <p>Description: {{ formation.description }}</p>
        <!-- Display other details as needed -->
      </div>
      <div v-else>
        <p>Loading...</p>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
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
        axios.get(`http://localhost:8080/formation/all/${formationId}`)
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