import { createRouter, createWebHistory, useRoute } from 'vue-router';
import RecipesView from '../views/RecipesView.vue';
import RecipeView from '../views/RecipeView.vue';
import PageNotFoundView from '../views/PageNotFoundView.vue';
import HomeView from '../views/HomeView.vue';
import VideoRecipesView from '../views/VideoRecipesView.vue';
import SignInView from '../views/SignInView.vue';
import RegisterView from '../views/RegisterView.vue';

const routes = [
  { path:'/', name:'Home', component:HomeView},
  { path:'/recipes', name:'Recipes', component:RecipesView},
  { path:'/recipe', name:'Recipe', component:RecipeView},
  { path:'/video', name:'Video', component: VideoRecipesView},
  { path:'/signin', name:'SignIn', component: SignInView},
  { path:'/register', name:'Register', component: RegisterView},
  


  { path: '/:pathMatch(.*)*', name: '404Error', component:PageNotFoundView }
]

const router = createRouter({
  history: createWebHistory(),
  routes
  
})

export default router;
