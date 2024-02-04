import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AdminDashboard from "../views/AdminDhasboard/AdminDashboard.vue";
import AssistantDashboard from "../views/AssistantDashboard/AssistantDashboard.vue";
import FormateurDashboard from "../views/FormateurDashboard.vue";
import Programmme from "../views/Programmme.vue";
import GererEntreprise_F from "../views/AdminDhasboard/GererEntreprise_F.vue";
import GererFormateur_F from "../views/AdminDhasboard/GererFormateur_F.vue";
import GererFormation_F from "../views/AdminDhasboard/GererFormation_F.vue";
import PlannificationEntreprise_F from "../views/AdminDhasboard/PlannificationEntreprise_F.vue";
import Feedback_F from "../views/AdminDhasboard/Feedback_F.vue";
import Feedback_A from "../views/AssistantDashboard/Feedback_A.vue";
import PlannificationEntreprise_A from "../views/AssistantDashboard/PlannificationEntreprise_A.vue";


const routes = [




  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/Courses',
    name: 'Courses',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Courses.vue')
  },

  {
    path: '/Login',
    name: 'Login',
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
  },
  {
    path: '/Etudiant',
    name: 'Etudiant',
    component: () => import(/* webpackChunkName: "about" */ '../views/Etudiant.vue')
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
    path: '/programmme/:formationId',
    name: "Programmme",
    component: Programmme,
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

  {
    path: '/GererFormation_F',
    name: "GererFormation_F",
    component: GererFormation_F,
  },

  {
    path: '/Feedback_F',
    name: "Feedback_F",
    component: Feedback_F,
  },

  {
    path: '/Feedback_A',
    name: "Feedback_A",
    component: Feedback_A,
  },
  {
    path: '/Espaceformateur',
    name: 'Espaceformateur',
    component: () => import(/* webpackChunkName: "about" */ '../views/Espaceformateur.vue')
  },
  {
    path: '/Feedback',
    name: 'Feedback',
    component: () => import(/* webpackChunkName: "about" */ '../views/Feedback.vue')
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
