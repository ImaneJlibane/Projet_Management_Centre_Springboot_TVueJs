<template>
  <div>
    <h1>Formations</h1>
    <div class="filters">
      <div>
        <label for="categoryFilter">Filter by Category:</label>
        <select v-model="selectedCategory">
          <option value="">All</option>
          <option v-for="category in categories" :value="category.idCat">{{ category.nomCat }}</option>
        </select>
      </div>

      <div>
        <label for="dateFilter">Filter by Date:</label>
        <input type="date" v-model="selectedDate" />
      </div>

      <div>
        <label for="cityFilter">Filter by City:</label>
        <input type="text" v-model="selectedCity" />
      </div>
      
      <button @click="filterFormations">Search</button>
    </div>

    <div class="formation-container">
      <div v-if="formations.length === 0">Loading...</div>

      <div v-else class="formation-box" v-for="formation in filteredFormations" :key="formation.id">
        <img src="@/assets/lg.png" alt="Formation Image" class="formation-image" />
        <div class="formation-info">
          <h2>{{ formation.titre }}</h2>
          <p>{{ formation.dateDebut }}</p>
          <p>Price: {{ formation.bugdet }}</p>
          <p>Number of Hours: {{ formation.nbHeure }}</p>
         <button @click="inscrire(formation)">Inscrire</button>
          <button @click="redirectToProgramme(formation.id)">Details</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      formations: [],
      filteredFormations: [],
      categories: [],
      selectedCategory: '',
      selectedDate: '',
      selectedCity: ''
    };
  },
  created() {
    this.fetchFormations();
    this.fetchCategories();
  },
  methods: {
    fetchFormations() {
      axios.get('http://localhost:8080/formation/all')
        .then(response => {
          this.formations = response.data;
          this.filteredFormations = this.formations;
        })
        .catch(error => {
          console.error('Error fetching formations:', error);
        });
    },
    fetchCategories() {
      axios.get('http://localhost:8080/categorie/all')
        .then(response => {
          this.categories = response.data;
        })
        .catch(error => {
          console.error('Error fetching categories:', error);
        });
    },
    filterFormations() {
      this.filteredFormations = this.formations.filter(formation => {
        const categoryFilter = !this.selectedCategory || !formation.categorieFormation || formation.categorieFormation.idCat == this.selectedCategory;
        const cityFilter = !this.selectedCity || !formation.ville || formation.ville.toLowerCase().includes(this.selectedCity.toLowerCase());
        let dateFilter = true;

        if (this.selectedDate) {
          const selectedDate = new Date(this.selectedDate).toISOString().split('T')[0];
          const formationDate = new Date(formation.dateDebut).toISOString().split('T')[0];
          dateFilter = selectedDate === formationDate;
        }

        return categoryFilter && cityFilter && dateFilter;
      });
    },
    inscrire(formation) {
      this.$router.push({ name: 'Etudiant', query: { formationTitle: formation.titre } });
    },
  redirectToProgramme(formationId) {
    // Redirect to the Programme page with the formation ID as a parameter
    this.$router.push({ name: 'Programmme', params: { formationId: formationId } });
}
  }
};
</script>

<style>
.filters {
  display: flex;
  justify-content: space-evenly;
  margin-bottom: 20px; 
  margin-top: 30px;
}

.formation-container {
  display: flex;
  flex-wrap: wrap;
  margin-left: 40px;
}

.formation-image {
  width: 50%;
  height: 110px;
  object-fit: cover;
  margin-bottom: 10px;
}

h1 {
  margin-top: 20px;
}

.formation-info h2 {
  margin-top: 0;
}

.formation-info p {
  margin: 5px 0;
}

button {
  padding: 5px 10px;
  background-color: #5519D2;
  color: white;
  border: none;
  cursor: pointer;
  border-radius: 20px;
  margin-left: 70px;
  margin-top: -5px;
}

button:hover {
  background-color: #004080;
}

.formation-box {
  width: 300px;
  border: 1px solid #ccc;
  padding: 10px;
  margin-right: 20px;
  margin-bottom: 20px;
  border-radius: 20px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.formation-info button {
  padding: 5px 10px;
  background-color: #FBAC14;
  color: white;
  border: none;
  cursor: pointer;
  border-radius: 20px;
  margin-right: 60px;
}

.formation-info button:hover {
  background-color: #004080;
}
</style>