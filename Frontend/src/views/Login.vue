<template>
  <section class="form-02-main">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="_lk_de">
            <div class="form-03-main">
              <form @submit.prevent="loginUser"> 
              <div class="logo">
                <img src="@/assets/images/user.png" alt="User Logo">
              </div>
              <div class="form-group">
                <input type="username" v-model="username" name="username" class="form-control _ge_de_ol" placeholder="Enter username" required aria-required="true">
              </div>

              <div class="form-group">
                <input type="password" v-model="password" name="password" class="form-control _ge_de_ol" placeholder="Enter Password" required aria-required="true">
              </div>

              <div>Already a member? <a href="/Espaceformateur" class="signIn">Sign In</a></div>
              <div class="form-group">
                <div class="_btn_04">
                  <!-- Use a button instead of an anchor -->
                  <button type="submit">Login</button>
                </div>
              </div>
            </form>  
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<style scoped>
/* Import Bootstrap CSS from the "assets" folder */
@import '@/assets/css/bootstrap.min.css';

/* Import Font Awesome CSS from the "assets" folder */
@import '@/assets/css/font-awesome.min.css';

/* Import your custom styles from the "assets" folder */
@import '@/assets/css/style.css';

</style>

<script>
import axios from "axios";

export default {
  data() {
    return {
      username: "",
      password: "",
    };
  },
  methods: {
    loginUser() {
  console.log("Username:", this.username);
  console.log("Password:", this.password);

      // Example using Axios
      axios.post("http://localhost:8080/api/users/login", { username: this.username, password: this.password }, { withCredentials: true })
        .then(response => {
          // Assuming the backend returns a token and user roles
          const token = response.data.token;
          const roles = response.data.roles[0].roleName;

          // Store the token and roles in localStorage or Vuex store
          localStorage.setItem("token", token);
          localStorage.setItem("roles", JSON.stringify(roles));

          // Redirect based on roles
          this.redirectBasedOnRoles(roles);
        })
        .catch(error => {
          console.error("Login failed:", error);
          // Handle login failure
        });
    },
    redirectBasedOnRoles(roles) {
      // Define your role-based redirection logic
      console.log("roles:", roles);

      if (roles.includes("ROLE_ADMIN")) {
        this.$router.push("/AdminDashboard");
      } else if (roles.includes("ROLE_ASSISTANT")) {
        this.$router.push("/AssistantDashboard");
      } else if (roles.includes("ROLE_FORMATEUR")) {
        this.$router.push("/FormateurDashboard");
      } else {
        // Redirect to a default page for users with unknown roles
        this.$router.push("/DefaultDashboard");
      }
    },
  },
};
</script>
