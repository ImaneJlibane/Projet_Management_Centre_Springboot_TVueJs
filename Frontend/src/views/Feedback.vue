<template>
  <div class="feedback-form">
    <img src="@/assets/lg.png">
    <h2>Feedback Form</h2>
    <div class="form-row">
      <div class="form-group">
        <label>Formation</label>
        <select v-model="selectedFormation">
          <option v-for="formation in formations" :key="formation.id" :value="formation.titre">{{ formation.titre }}</option>
        </select>
      </div>
      <div class="form-group">
        <label>Formateur</label>
        <select v-model="selectedFormateur">
          <option v-for="formateur in formateurs" :key="formateur.id" :value="formateur.nom + ' ' + formateur.prenom">{{ formateur.nom + ' ' + formateur.prenom }}</option>
        </select>
      </div>
    </div>
    <div class="form-row">
      <div class="form-group" v-for="(aspect, index) in aspects" :key="index">
        <label>{{ aspect.label }}</label>
        <div class="star-rating">
          <i v-for="n in 5" :key="n" class="fas fa-star" :class="{ 'active': n <= aspect.rating }" @click="setRating(aspect, n)"></i>
        </div>
      </div>
    </div>
    <button class="btn btn-primary" @click="submitFeedback">Submit Feedback</button>
  </div>
</template>


<script>
import axios from 'axios';

export default {
  data() {
    return {
      selectedFormation: '',
      selectedFormateur: '',
      formations: [],
      formateurs: [],
      aspects: [
        { label: 'Pedagogical Quality', rating: 0 },
        { label: 'Rhythm', rating: 0 },
        { label: 'Course Support', rating: 0 },
        { label: 'Subject Mastery', rating: 0 }
      ]
    };
  },
  mounted() {
    // Fetch formations
    axios.get('http://localhost:8080/formation/all')
      .then(response => {
        this.formations = response.data;
      })
      .catch(error => {
        console.error('Error fetching formations:', error);
      });

    // Fetch formateurs
    axios.get('http://localhost:8080/formateur/all')
      .then(response => {
        this.formateurs = response.data;
      })
      .catch(error => {
        console.error('Error fetching formateurs:', error);
      });
  },
  methods: {
    setRating(aspect, rating) {
      aspect.rating = rating;
    },
    submitFeedback() {
      const feedbackData = {
        pedagogicalQualityRating: this.aspects[0].rating,
        rhythmRating: this.aspects[1].rating,
        courseSupportRating: this.aspects[2].rating,
        subjectMasteryRating: this.aspects[3].rating,
        formateur: this.selectedFormateur,
        formation: this.selectedFormation
      };

      axios.post('http://localhost:8080/api/feedback/register', feedbackData)
        .then(response => {
          console.log('Feedback submitted successfully:', response.data);
           alert('feedback saved successfully!');
          this.resetRatings();
        })
        .catch(error => {
          console.error('Error submitting feedback:', error);
          alert('Error submitting feedback! Please try again');
        });
    },
    resetRatings() {
      this.aspects.forEach(aspect => {
        aspect.rating = 0;
      });
    }
  } ,
  watch: {
   watch: {
    selectedFormation(newValue) {
      
      if (newValue) {
        this.formations = this.formations.filter(formation => formation.titre !== newValue);
      }
    },
    selectedFormateur(newValue) {
      
      if (newValue) {
        this.formateurs = this.formateurs.filter(formateur => (formateur.nom + ' ' + formateur.prenom) !== newValue);
      }
    }
  }
  }
};

</script>
<style scoped>
.feedback-form {
  max-width: 800px;
  margin: auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  margin-top: 140px;
}

.form-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.form-group {
  margin-bottom: 20px;
  flex: 1;
}

.star-rating {
  font-size: 24px;
}

.star-rating .fas.fa-star {
  color: #5519D2;
  cursor: pointer;
}

.star-rating .fas.fa-star.active {
  color: #ffb400;
}
.form-group{
  margin-top:9px;
}
</style>
