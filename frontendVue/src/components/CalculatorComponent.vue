<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";

export default defineComponent({
  name: "Calculator",
  data() {
    return {
      recipes: [],
      ingredients: [],
      checkedIngredients: []
    }
  },
  created() {
    this.fetchRecipes();
    this.fetchIngredients();
  },
  beforeMount(){

  },
  computed: {
    ...mapStores(useAuthStore)
  },
  methods: {
    fetchRecipes() {
      fetch('/api/recipes', {})
          .then(response => response.json())
          .then(data => {
            this.recipes = data;
          })
          .catch(error => console.log('error', error))
    },
    fetchIngredients() {
            fetch('/api/ingredients', {})
                .then(response => response.json())
                .then(data => {
                    //console.log('data', data)
                    this.ingredients = data;
                })
                .catch(error => console.log('error', error))
        },
    updateIngredients(){

        if (this.checkedIngredients.length == 0) {
            this.fetchRecipes();     
        } else {
            fetch('/api/recipes', {})
          .then(response => response.json())
          .then(data => {
            this.recipes = data;
            //logic
            
            for (let ingrId of this.checkedIngredients) {
                for (let i=0; i < this.recipes.length; i++) {
                    let ingredients = this.recipes[i].ingredients;
                    let ingrFound = false;
                    for (let ingredient of ingredients) {
                        if (ingrId == ingredient.id) {
                            ingrFound = true;
                            break;
                        }
                    }

                    if (!ingrFound) {
                        console.log("remove recipe id " + this.recipes[i].id);
                        this.recipes.splice(i, 1);
                        i--;
                    }
                    
                }
            }
            
          })
          .catch(error => console.log('error', error))
        }
    }
  }
});
</script>

<template>
    <h1>Dont know what to cook?</h1>
    <section class="container">
        
        <section class="ingredients">
            <fieldset @change="updateIngredients">
            <span class="ingredientLabel" v-for="ingredient of ingredients" :for="ingredient.name">{{
                            ingredient.name
                    }} <input class="checkboxtext" type="checkbox" :value="ingredient.id" v-model="checkedIngredients"
                            :id="ingredient.name"></span>
            </fieldset>
        </section>
        
        <section class="recipes">
            <article v-for="recipe of recipes">
            <h1 class="fontbold"><router-link :to="`recipe/${recipe.id}`">{{ recipe.title }}</router-link></h1>
            <img v-bind:src="recipe.imagePath">
            <p class="textfont">{{ recipe.content }}</p>
            <p class="created">Created by: {{ recipe.user.username }}</p>
            <p class="created">Created on: {{ recipe.creationDate }}</p>
        </article>
        </section>

    </section>

</template>

<style scoped>
    .container {
        display: block;
    }
    h1 {
        text-align: center;
    }
    .ingredients {
        display: flex;
        width: 100%;
        margin-bottom: 20px;
        flex-wrap: wrap;
    }

    .ingredientLabel {
        margin-left: 10px;
    }

    .recipes{
        overflow: hidden;
    display: flex;
    flex-wrap: wrap;
    justify-content: start;
    /* gap: 0px 20px; */
    
    align-items: flex-start;
    }

    .recipes article {
    margin-left: 10px;
    margin-right: 10px;
    margin-bottom: 20px;
    flex-basis: 23%;
    }
    .recipes article img {
        width: 100%;
        display: block;
    }

    .recipes h1 {
        margin: 0;
    }
</style>