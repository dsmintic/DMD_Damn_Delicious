<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";

export default defineComponent({
  name: "RecipesAll",
  data() {
    return {
      recipes: [],
      ratings: []
    }
  },
  created() {
    this.fetchRecipes();
    this.fetchRatings();
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
    fetchRatings() {
      fetch('/api/ratings', {})
          .then(response => response.json())
          .then(data => {
            this.ratings = data;
          })
          .catch(error => console.log('error', error))
    },
    getRating(id) {

        let sum = 0;
        let count = 0;

        for (let rating in this.ratings) {
            if (rating.recipeId == id) {
                sum += rating.rating;
                count++;
            }
        }
        
        if (count == 0) {
            return 0;
        }

        return Math.ceil(sum/count);
    }
  },
  scrollToTop() {
      window.scrollTo(0,0);
    }
});
</script>

<template>
    <section class="container">
        <article v-for="recipe of recipes">
            <h1 class="fontbold"><router-link :to="`recipe/${recipe.id}`">{{ recipe.title }}</router-link></h1>
            <div class="ratingContainer">
                <font-awesome-icon class="star" icon="fa-solid fa-star" v-for="i in getRating(recipe.id)" />
            </div>
            <img v-bind:src="recipe.imagePath">
            <p class="textfont">{{ recipe.summary }}</p>
            <p class="created">Published by: {{ recipe.user.username }}</p>
            <p class="created">Published on: {{ recipe.creationDate }}</p>
        </article>
    </section>
</template>


<style scoped>
.container {
    overflow: hidden;
    display: flex;
    flex-wrap: wrap;
    justify-content: flex-start;
    align-items: flex-start;
}

.container a {
    margin: 0;
    padding: 0;
}

.container article {
    margin-left: 20px;
    margin-right: 10px;
    margin-bottom: 20px;
    flex-basis: 23%;
    background-color: #FFF6ED;
}

.container article h1 {
    text-align: center;
}

.container article img {
    width: 100%;
    display: block;
}

.container article p {
    font-size: medium;
    background-color: #FFF6ED;
    /* margin: 0px; */
}

.created {
    margin-right: 5px;
    margin-top: 0px;
    margin-bottom: 2px;
    margin-left: 0px;
    text-align: right;
    background-color: #FFF6ED;
}

.rating {
    margin: 0px;
    text-align: left;
    background-color: #FFDAB9!important;
}


.fontbold {
    background-color: peachpuff;
    padding: 20px;
    font-weight: 700;
    margin: 0;
}

.textfont {
    font-weight: 100;
    padding: 10px;
    margin: 0;
}

.hr {
    color: peachpuff;
}

.star {
    font-size: 20px;
    text-align: center;
    margin: 5px;
    color: #0C7EF3;
}

.ratingContainer {
    text-align: center;
}
</style>
