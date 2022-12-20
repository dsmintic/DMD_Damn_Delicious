<script>
import HeaderMain from './components/HeaderMain.vue';
import FooterComponent from './components/FooterComponent.vue';
import RecipesView from './views/RecipeView.vue';
import VideoRecipes from './views/VideoRecipesView.vue';


export default{
    data(){
        return{

            }
        
    },
    methods:{

            },
    components: {
    HeaderMain,
    FooterComponent,
    RecipesView,
    VideoRecipes
   
}
}

</script>

<template>

  <header>
    <!-- logo, main navigation, sec/aux navigation, search -->
    <HeaderMain></HeaderMain>
  </header>

  <main>
    <router-view></router-view>
  </main>
 
  <footer>
    <FooterComponent></FooterComponent>
  </footer>

</template>

<style>

</style>
