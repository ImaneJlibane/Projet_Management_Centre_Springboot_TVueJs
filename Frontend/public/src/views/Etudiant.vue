<template>
  <div class="container">
    <div class="row">
      <!-- Left side with registration form -->
      <div class="col-md-6">
        <div class="logo-container text-center">
          <img src="@/assets/lg.png" alt="Logo" class="logo" />
        </div>

        <h2 class="mb-4">Inscription Étudiante</h2>
        <form @submit.prevent="saveData">

          <div class="input-group mb-3">
            <span class="input-group-text" id="name-icon">
              <i class="bi bi-person-fill"></i>
            </span>
            <input type="text" v-model="Etudiant.nom" class="form-control" placeholder="Entrez votre nom" aria-describedby="name-icon" />
          </div>
 <div class="input-group mb-3">
            <span class="input-group-text" id="firstName-icon">
              <i class="bi bi-person"></i>
            </span>
            <input type="text" v-model="Etudiant.prenom" class="form-control" placeholder="Entrez votre prénom" aria-describedby="firstName-icon" />
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text" id="email-icon">
              <i class="bi bi-envelope-fill"></i>
            </span>
            <input type="email" v-model="Etudiant.email" class="form-control" placeholder="Entrez votre adresse e-mail" aria-describedby="email-icon" />
          </div>

           <div class="input-group mb-3">
  <span class="input-group-text" id="formation-icon">
    <i class="bi bi-book"></i>
  </span>
  <input type="text" v-model="Etudiant.formation" class="form-control" placeholder="Formation" aria-describedby="formation-icon" />
</div>

          <div class="input-group mb-3">
            <span class="input-group-text" id="mobile-icon">
              <i class="bi bi-phone"></i>
            </span>
            <input type="text" v-model="Etudiant.numeroTel" class="form-control" placeholder="Entrez votre numéro de portable" aria-describedby="mobile-icon" />
          </div>

          <div class="input-group mb-3">
            <span class="input-group-text" id="city-icon">
              <i class="bi bi-geo-alt"></i>
            </span>
            <input type="text" v-model="Etudiant.ville" class="form-control" placeholder="Entrez votre ville" aria-describedby="city-icon" />
          </div>

          <div class="input-group mb-3">
            <span class="input-group-text" id="dob-icon">
             <i class="bi bi-calendar3"></i>
            </span>
            <input type="date" v-model="Etudiant.dateNaissance" class="form-control" placeholder="Sélectionnez votre date de naissance" aria-describedby="dob-icon" />
          </div>

          <div class="form-group text-right">
            <button type="submit" class="btn btn-primary">Enregistrer</button>
          </div>
        </form>
      </div>

      <!-- Right side with image -->
      <div class="col-md-6">
        <img src="@/assets/et.png" alt="Student Image" class="img-fluid" />
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import 'bootstrap-icons/font/bootstrap-icons.css';

export default {
  data() {
    return {
      Etudiant: {
        id: '',
        email: '',
        username: '',
        password: '',
        nom: '',
        prenom: '',
        ville: '',
        numeroTel: '',
        dateNaissance: '',
         formation: this.$route.query.formationTitle || ''
      },
    };
  },
  methods: {
    saveData() {
      axios.post('http://localhost:8080/api/etudiants/register', this.Etudiant)
        .then(response => {
          console.log('Student saved successfully:', response.data);
          alert('Student saved successfully!');
        })
        .catch(error => {
          console.error('Error saving student:', error);
          alert('Error saving student. Please try again.');
        });
    },
  },
};
</script>

<style scoped>
.logo {
  max-width: 50px;
  height: auto;
}

img {
  max-width: 100%;
  height: auto;
}

.input-group-text {
  width: 40px; /* Adjust the width as needed */
  text-align: center;
}

.img-fluid{
  margin-left:110px;
  margin-top:50px;}
  .row{
  margin-top:23px;
}

</style>