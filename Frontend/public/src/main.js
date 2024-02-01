import { createApp } from 'vue';
import App from './App.vue';
import axios from 'axios';
import router from './router';
// Create a global Axios instance
const axiosInstance = axios.create({
  baseURL: 'http://localhost:8096', // Replace with your backend URL
   withCredentials: true,
 headers: {
    'Content-Type': 'application/json',
    // Add any additional headers if needed
  },
});


const app = createApp(App);
app.config.globalProperties.$axios = axiosInstance;


app.use(router).mount('#app');
