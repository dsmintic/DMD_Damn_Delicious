<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";

export default defineComponent({
  name: "RecipesAll",
  data() {
    return {
      recipes: []
    }
  },
  created() {
    this.fetchRecipes();
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
    }
  }
});
</script>

<template>
    <section class="container">
        <article v-for="recipe of recipes">
          <h1 class="fontbold"><router-link :to="`recipe/${recipe.id}`">{{ recipe.title }}</router-link></h1>
          <img v-bind:src="recipe.imagePath">
          <p class="textfont">{{ recipe.content }}</p>
        </article>


        <article>
            <!-- <h1 class="fontbold"><router-link :to="{ name: 'Recipe' }">Biscuit Eggs</router-link></h1> -->
            <h1 class="fontbold"><router-link to="/recipe/1">Biscuit Eggs</router-link></h1>
            <p class="rating">Rating</p>
            <img src="../images/BiscuitEggs.png">
            <p class="textfont">The butterless biscuits for these Benedicts are perfect for kids to make because they
                are so simple. </p>
                <p class="created">Created by:</p>
                <p class="created">Created on:</p>
        </article>
        <article>
            <h1 class="fontbold">5 - Minute Yoghurt and Fruit</h1>
            <img src="../images/5-Minute Yoghurt and Fruit Parfaits.png">
            <p class="textfont">This mouth-watering recipe is ready in just 5 minutes and the ingredients detailed below
                can serve up to 1 person.</p>
        </article>
        <article>
            <h1 class="fontbold">Breakfast Nachos</h1>
            <img src="../images/Breakfast Nachos.png">
            <p class="textfont">This mouth-watering recipe is ready in just 10 minutes and the ingredients detailed
                below can serve up to 2 people.</p>
        </article>
        <article>
            <h1 class="fontbold">Smoked Salmon Salad-in-a-Jar</h1>
            <img src="../images/Smoked Salmon and Sugar Snap Pea Salad in a Jar.png">

            <p class="textfont">The jar makes this salad super portable and shows off its pretty layers.</p>
        </article>

        <article>
            <h1 class="fontbold">Bacon and Egg Brunch Salad</h1>
            <img src="../images/salad.png">

            <p class="textfont">A healthy but delicious beginning to your day.</p>
        </article>
        <article>
            <h1 class="fontbold">Avocado Toasts</h1>
            <img src="../images/Avocado Toasts.png">

            <p class="textfont">You'll never want to eat a plain BLT again. Fact.</p>
        </article>
        <article>
            <h1 class="fontbold">Tomato Soup</h1>
            <img src="../images/Tomato Soup.png">

            <p class="textfont">This mouth-watering recipe is ready in just 60 minutes </p>
        </article>
        <article>
            <h1 class="fontbold">Spicy Grilled Prawn Subs </h1>
            <img src="../images/Spicy Grilled Prawn Subs.png">

            <p class="textfont">This mouth-watering recipe is ready in just 45 minutes and the ingredients detailed
                below can serve up to 4 people.</p>
        </article>
  

   
        <article>
            <h1 class="fontbold">French omelette</h1>
            <img src="../images/French omelette.png">

            <p class="textfont">This mouth-watering recipe is ready in just 15 minutes and the ingredients detailed
                below can serve up to 1 person.</p>
        </article>
        <article>
            <h1 class="fontbold">Chicken Kabobs with Grilled Onions</h1>
            <img src="../images/Chicken Kabobs with Grilled Onions.png">

            <p class="textfont">These teriyaki chicken skewers are the perfect barbecue side dish.</p>
        </article>
        <article>
            <h1 class="fontbold">Spicy prawns and spaghetti</h1>
            <img src="../images/Asian Chicken and Quinoa Salad.png">

            <p class="textfont">Spicy prawns and spaghetti aglio olio</p>
        </article>

        <article>
            <h1 class="fontbold">Spicy Hoisin Glazed Aubergine</h1>
            <img src="../images/Spicy Hoisin Glazed Aubergine.png">

            <p class="textfont">Chilli flakes take Bobby Flay's grilled aubergine to another level.</p>
        </article>
    


        <article>
            <h1 class="fontbold">Lemon Pudding Cake </h1>
            <img src="../images//Lemon Pudding Cake with Fresh Mixed Berries.jpg">

            <p class="textfont">This mouth-watering recipe is ready in just 85 minutes and the ingredients detailed
                below can serve up to 4 people.</p>
        </article>
        <article>
            <h1 class="fontbold">Angel Food Cake</h1>
            <img src="../images/Angel Food Cake.jpg">

            <p class="textfont">This mouth-watering recipe is ready in just 55 minutes and the ingredients detailed
                below can serve up to 10 people.</p>
        </article>
        <article>
            <h1 class="fontbold">Carrot cake cupcakes</h1>
            <img src="../images/Carrot cake cupcakes.jpg">

            <p class="textfont">Sultanas and walnuts add a different texture to these cupcakes.</p>
        </article>
        <article>
            <h1 class="fontbold">Billie's Italian Cream Cake with Blueberries</h1>
            <img src="../images/Cream Cake with blueberries.jpg">

            <p class="textfont">This mouth-watering recipe is ready in just 70 minutes and the ingredients detailed
                below can serve up to 12 people.</p>
        </article>
  

        <article>
            <h1 class="fontbold">Griddled cake sundaes with raspberry topping</h1>
            <img src="../images/Griddled cake sundaes with raspberry topping.jpg">

            <p class="textfont">Turn leftover loaf cake into a satisfying sundae for a speedy dessert.</p>
        </article>
        <article>
            <h1 class="fontbold">Little Devils Food Cakes</h1>
            <img src="../images/Little Devils Food Cakes.jpg">

            <p class="textfont">This mouth-watering recipe is ready in just 60 minutes and the ingredients detailed
                below can serve up to 12 people.</p>
        </article>
        <article>
            <h1 class="fontbold">25-Minute Flank Steak with Onion Salad</h1>
            <img src="../images/25-Minute Flank Steak with Charred Vidalia Onion Salad.png">

            <p class="textfont">Cono Sur wine pairing: A steak dinner calls for a classic Malbec, with notes of sweet
                spices and oak.</p>
        </article>
        <article>
            <h1 class="fontbold">King Prawns and Clam Minestrone</h1>
            <img src="../images/King Prawns and Clam Minestrone.png">

            <p class="textfont">This mouth-watering recipe is ready in just 25 minutes and the ingredients detailed
                below can serve up to 4 people.</p>
        </article>

        <article>
            <h1 class="fontbold">Prosciutto Lamb Burgers</h1>
            <img src="../images/Prosciutto Lamb Burgers.png">

            <p class="textfont">Lamb is a fantastic alternative for burgers.</p>
        </article>
        <article>
            <h1 class="fontbold">Steak on Garlic Toast </h1>
            <img src="../images/Steak on Garlic Toast with Provolone and Parsley oil.png">

            <p class="textfont">DMD chefs creates a steak sandwich for champions.</p>
        </article>
        <article>
            <h1 class="fontbold">DMD Steak with Parsley Sauce</h1>
            <img src="../images/Argentinean Steak with Parsley Sauce.png">

            <p class="textfont">Season the flank steak with olive oil, salt, and pepper and grill/broil the steak for 2
                to 3 minutes per side for medium rare. </p>
        </article>
        <article>
            <h1 class="fontbold">Lightning lamb burger</h1>
            <img src="../images/Lightning lamb burger.png">

            <p class="textfont">Mixing lamb with pesto and cheese gives gorgeous flavour from the inside.</p>
        </article>
    </section>
</template>


<style scoped>
.container {
    overflow: hidden;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-evenly;
    align-items: flex-start;
}

.container a {
    margin: 0;
    padding: 0;
}

.container article {
    margin-left: 10px;
    margin-right: 10px;
    margin-bottom: 20px;
    flex-basis: 23%;
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
    margin: 0px;
    
}

.created {
    margin: 0px;
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
</style>
