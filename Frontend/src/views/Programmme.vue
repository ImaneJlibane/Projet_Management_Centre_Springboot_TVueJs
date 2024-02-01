<template>
  <div class="formation-details-container">
    <h2>Formation Details</h2>
    <div v-if="formation" class="formation-details">
      <div class="formation-detail">
        <h3>{{ formation.titre }}</h3>
        <p><span class="detail-heading">Description:</span><br>{{ formation.description }}</p>
        <p><span class="detail-heading">Objectifs:</span><br>{{ formation.objectifs }}</p>
        <p><span class="detail-heading">Contenu:</span><br>{{ formation.motcle }}</p>
        <p><span class="detail-heading">Durée:</span><br>{{ formation.horaire }}</p>
        <!-- Add other details as needed -->
      </div>
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

<style scoped>
.formation-details-container {
  width: 50%; 
  margin: 0 auto; 
}

.formation-details {
  text-align: left; 
}

.formation-detail {
  width: 80%; 
  margin: 0 auto; 
}

.detail-heading {
  color: blue; 
}
</style>














