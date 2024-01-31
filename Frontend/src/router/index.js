import { createRouter, createWebHistory } from 'vue-router'
import AdminDashboard from "../views/AdminDhasboard/AdminDashboard.vue";
import AssistantDashboard from "../views/AssistantDashboard/AssistantDashboard.vue";
import FormateurDashboard from "../views/FormateurDashboard.vue";
import GererEntreprise_F from "../views/AdminDhasboard/GererEntreprise_F.vue";
import GererFormateur_F from "../views/AdminDhasboard/GererFormateur_F.vue";
import PlannificationEntreprise_F from "../views/AdminDhasboard/PlannificationEntreprise_F.vue";
import PlannificationEntreprise_A from "../views/AssistantDashboard/PlannificationEntreprise_A.vue";


const routes = [




  
  {
    path: '/Login',
    name: 'Login',
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
  },
  

  {
    path: "/AdminDashboard",
    name: "AdminDashboard",
    component: AdminDashboard,
  },
  
  {
    path: "/AssistantDashboard",
    name: "AssistantDashboard",
    component: AssistantDashboard,
  },
  

  {
    path: "/FormateurDashboard",
    name: "FormateurDashboard",
    component: FormateurDashboard,
  },


  {
    path: '/GererFormateur_F',
    name: "GererFormateur_F",
    component: GererFormateur_F,
  },

  {
    path: '/GererEntreprise_F',
    name: "GererEntreprise_F",
    component: GererEntreprise_F,
  },

  
  {
    path: '/PlannificationEntreprise_F',
    name: "PlannificationEntreprise_F",
    component: PlannificationEntreprise_F,
  },

  {
    path: '/PlannificationEntreprise_A',
    name: "PlannificationEntreprise_A",
    component: PlannificationEntreprise_A,
  },

  
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
