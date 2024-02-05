<template>
  <div id="home" class="container">
    <div class="row">
      <!-- Left side with centered image -->
      <div class="col-md-6 d-flex align-items-center justify-content-center">
        <img src="@/assets/img.png" alt="Logo" class="img-fluid1">
      </div>

      <!-- Right side with centered text -->
      <div class="col-md-6 d-flex align-items-center justify-content-center">
        <div class="text-container ">
          <p id="h1"  >
            Rejoignez-nous pour faire <span  >un excellent 
         
          voyage</span> dans les langages de programmation</p>
          <p id="P1">Notre plateforme permet aux étudiants de s'inscrire facilement à une variété 
          de programmes de formation spécialisés.</p>
          <button @click="showDetails" class="btn btn-primary">Learn More</button>
          <p v-show="showDetailsText" class="small-text">
          Nous fournissons des ressources et des conseils pour vous aider à apprendre les langages de programmation et à exceller dans votre parcours de codage.
             Que vous soyez débutant ou développeur expérimenté, nous avons quelque chose pour tout le monde. Explorez nos cours et commencez à apprendre dès aujourd'hui !
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      showDetailsText: false,
    };
  },
  methods: {
    showDetails() {
      this.showDetailsText = !this.showDetailsText;
    },
  },
};
</script>

<style scoped>
#home {
  padding: 50px;
}

.text-container {
 max-width: 600px; 
  text-align: left;
  margin-right:300%;
  margin-top:-74%;
 
}

.small-text {
  font-size: 16px;
  margin-top: 9px;
  color:black;
}
#h1{
 
  width: 600px;
  font-size: 2.5rem;
  font-weight: 700;
  text-align: left;
  line-height: 1.2;



}
.btn-primary:hover {
  background-color: #5519D2;
}
.btn-primary{
   margin-top: 12px;
  height:50px;
  width:180px;
    background-color:#FBAC14 ;
 
   border-radius:25px;
font-size:19px;
  border: none;

}
span{
  color:#5519D2;
}
#P1{
 
 
  font-size: 16px;
 font-weight:9px;
 margin-top:10px;
color:black;

}

</style>


