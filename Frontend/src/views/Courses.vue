<template>
  <div>
     <div>
  

  </div>
    <div class="filters">
      <div>
        <label for="categoryFilter">Filter by Category:&nbsp;</label>
        <select v-model="selectedCategory">
          <option value="">All</option>
          <option v-for="category in categories" :value="category.idCat">{{ category.nomCat }}</option>
        </select>
      </div>

      <div>
        <label for="dateFilter">Filter by Date:&nbsp;</label>
        <input type="date" v-model="selectedDate" />
      </div>

      <div>
        <label for="cityFilter">Filter by City:&nbsp;</label>
        <select v-model="selectedCity">
          <option value="">All</option>
          <option v-for="city in uniqueCities" :value="city">{{ city }}</option>
        </select>
      </div>
      
      <button style="margin-top:-10px;" @click="filterFormations">Search</button>
    </div>

    <div class="formation-container">
      <div v-if="formations.length === 0">Loading...</div>

      <div v-else class="formation-box" v-for="formation in filteredFormations" :key="formation.id">
        <img src="@/assets/Group 3.png" alt="Formation Image" class="formation-image" />
        <div class="formation-info">
          <h2>{{ formation.titre }}</h2>
          <p>{{ formatDate(formation.dateDebut) }}</p>
          <p>Prix: {{ formation.bugdet }} DH</p>
          <p>Nbr d’heures: {{ formation.nbHeure }}</p>
          <div class="button-container">
            <button @click="inscrire(formation)">Inscrire</button>
            <button @click="redirectToProgramme(formation.id)">Details</button>
          </div>
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
      selectedCity: '',
      uniqueCities: [] // Holds unique cities extracted from formations
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
          this.extractUniqueCities(); // Extract unique cities after fetching formations
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
    extractUniqueCities() {
 
      const cities = new Set();
      this.formations.forEach(formation => {
        if (formation.ville) {
          cities.add(formation.ville);
        }
      });
      this.uniqueCities = Array.from(cities);
    },
    filterFormations() {
      this.filteredFormations = this.formations.filter(formation => {
        const categoryFilter = !this.selectedCategory || !formation.categorieFormation || formation.categorieFormation.idCat == this.selectedCategory;
        const cityFilter = !this.selectedCity || formation.ville === this.selectedCity;
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
      this.$router.push({ name: 'Programmme', params: { formationId: formationId } });
    },
    formatDate(dateString) {
      const date = new Date(dateString);
      return `${date.toLocaleDateString('en-US', { month: 'short', day: 'numeric', year: 'numeric' })}`;
    }
  }
};
</script>

<style>
.filters {
  display: flex;
  justify-content: space-evenly;
  margin-bottom: 20px; 
  margin-top: 50px;
}

.formation-container {
  display: flex;
  flex-wrap: wrap;
  margin-left: 45px;
  margin-top:40px;
}

.formation-image {
  width: 100%;
  height: 170px;
  margin-left: 7px;
  margin-top: 10px;
  object-fit: cover;
}

h1 {
  margin-top: 20px;
  color: #5519D2;
}

.formation-info {
  width: 100%;
  text-align: center;
}

.formation-info h2 {
  margin-top: 0;
}

.formation-info p {
  margin: 5px 0;
}

.button-container {
  display: flex;
  justify-content: center;
}

button {
  padding: 5px 10px;
  background-color: #5519D2;
  color: white;
  border: none;
  cursor: pointer;
  border-radius: 20px;
  margin: 5px;
}

button:hover {
  background-color:#FBAC14 ;
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

</style>