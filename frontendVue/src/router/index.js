import { createRouter, createWebHistory, useRoute } from 'vue-router';
import RecipesView from '../views/RecipesView.vue';
import RecipeView from '../views/RecipeView.vue';
import PageNotFoundView from '../views/PageNotFoundView.vue';
import HomeView from '../views/HomeView.vue';
import VideoRecipesView from '../views/VideoRecipesView.vue';
import SignInView from '../views/SignInView.vue';
import RegisterView from '../views/RegisterView.vue';
import AddRecipeView from '../views/AddRecipeView.vue';
import ChefsView from '../views/ChefsView.vue'
import ChefMarijaView from '../views/ChefMarijaView.vue'
import ChefDennisView from '../views/ChefDennisView.vue'
import ChefDamirView from '../views/ChefDamirView.vue'

const routes = [
  { path:'/', name:'Home', component:HomeView},
  { path:'/recipes', name:'Recipes', component:RecipesView},
  { path:'/recipe/:id', name:'Recipe', component:RecipeView},
  { path:'/video', name:'Video', component: VideoRecipesView},
  { path:'/signin', name:'SignIn', component: SignInView},
  { path:'/register', name:'Register', component: RegisterView},
  { path:'/addrecipe', name:'AddRecipe', component: AddRecipeView},
  { path:'/chefs', name:'Chefs', component: ChefsView},
  { path:'/chefMarija', name:'Marija', component: ChefMarijaView},
  { path:'/chefDennis', name:'Dennis', component: ChefDennisView},
  { path:'/chefDamir', name:'Damir', component: ChefDamirView},
  


  { path: '/:pathMatch(.*)*', name: '404Error', component:PageNotFoundView }
]

const router = createRouter({
  history: createWebHistory(),
  routes
  
})

export default router;
