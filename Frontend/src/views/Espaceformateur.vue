<template>
  <div class="container">
    <div class="row justify-content-center">
      <!-- Left side with registration form -->
      <div class="col-md-6">
        <div class="logo-container text-center">
          <img src="@/assets/lg.png" alt="Logo" class="logo" />
        </div>

        <h2 class="mb-4">Formateur Registration</h2>
        <form @submit.prevent="saveData" class="styled-form">
          <!-- Left Column Inputs -->
          <div class="row">
            <div class="col-md-6">
              <div class="input-group mb-3">
                <span class="input-group-text" id="firstName-icon">
                  <i class="bi bi-person"></i>
                </span>
                <input type="text" v-model="Formateur.prenom" class="form-control" placeholder="Enter your first name" aria-describedby="firstName-icon" required />
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text" id="speciality-icon">
                  <i class="bi bi-bookmark"></i>
                </span>
                <input type="text" v-model="Formateur.specialite" class="form-control" placeholder="Speciality" aria-describedby="speciality-icon" required />
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text" id="city-icon">
                  <i class="bi bi-geo-alt"></i>
                </span>
                <input type="text" v-model="Formateur.ville" class="form-control" placeholder="Enter your city" aria-describedby="city-icon" required />
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text" id="email-icon">
                  <i class="bi bi-envelope-fill"></i>
                </span>
                <input type="email" v-model="Formateur.email" class="form-control" placeholder="Enter your email address" aria-describedby="email-icon" required />
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text" id="username-icon">
                  <i class="bi bi-person"></i>
                </span>
                <input type="text" v-model="Formateur.username" class="form-control" placeholder="Enter your username" aria-describedby="username-icon" required />
              </div>
            </div>
            <!-- Right Column Inputs -->
            <div class="col-md-6">
              <div class="input-group mb-3">
                <span class="input-group-text" id="name-icon">
                  <i class="bi bi-person-fill"></i>
                </span>
                <input type="text" v-model="Formateur.nom" class="form-control" placeholder="Enter your last name" aria-describedby="name-icon" required />
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text" id="education-icon">
                  <i class="bi bi-award"></i>
                </span>
                <input type="text" v-model="Formateur.niveauScolair" class="form-control" placeholder="Level of Education" aria-describedby="education-icon" required />
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text" id="dob-icon">
                  <i class="bi bi-calendar3"></i>
                </span>
                <input type="date" v-model="Formateur.dateNaissance" class="form-control" placeholder="Select your date of birth" aria-describedby="dob-icon" required />
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text" id="mobile-icon">
                  <i class="bi bi-phone"></i>
                </span>
                <input type="text" v-model="Formateur.numeroTel" class="form-control" placeholder="Enter your mobile number" aria-describedby="mobile-icon" required />
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text" id="password-icon">
                  <i class="bi bi-lock-fill"></i>
                </span>
                <input type="password" v-model="Formateur.password" class="form-control" placeholder="Enter your password" aria-describedby="password-icon" required />
              </div>
            </div>
          </div>
          <div class="form-group text-right">
            <button type="submit" class="btn btn-primary">Save</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<style scoped>
.container {
  
margin-top: 40px;
  margin-right:200px;
}

.logo {
  width: 50px; /* Adjust logo size as needed */
}

/* Adjust form styling if needed */
.styled-form {
  background-color:white;
  padding: 20px;
  border-radius: 8px;
  width:700px;

}

/* Adjust form margin if needed */
.styled-form .form-group {
  margin-top: 20px;
}
h2{
    margin-left:120px;
}
.btn-primary{
margin-right:80px;
}
img{
    margin-left:110px; 
}
</style>

<script>
import axios from 'axios';
import 'bootstrap-icons/font/bootstrap-icons.css';

export default {
  data() {
    return {
      Formateur: {
        id: '',
        username: '',
        password: '',
        email: '',
        nom: '',
        prenom: '',
        ville: '',
        numeroTel: '',
        dateNaissance: '',
        specialite: '',
        niveauScolair: '',
        remarques:'',
      },
    };
  },
  methods: {
    saveData() {
      axios.post('http://localhost:8080/formateur/add', this.Formateur)
        .then(response => {
          console.log('Formateur saved successfully:', response.data);
          alert('Formateur saved successfully!');
        })
        .catch(error => {
          console.error('Error saving formateur:', error);
          alert('Error saving formateur. Please try again.');
        });
    },
  },
};
</script>