<script>
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";
import { useRoute } from 'vue-router';
export default {
    data(){
      return {
        recipe: {},
        id: ''
      }
    },
    created() {
      const route = useRoute();
      this.id = route.params.id;
      this.fetchRecipe();
    },
    computed: {
      ...mapStores(useAuthStore)
    },
  methods: {
    fetchRecipe() {
      let url = "/api/recipes/" + this.id;
      
      fetch(url, {})
          .then(response => response.json())
          .then(data => {
            this.recipe = data;
          })
          .catch(error => console.log('error', error))
    }
  }
}
</script>

<template>

<section class="container">
    <article>
      <h1 class="fontbold">{{ recipe.title }}</h1>
      <img :src="`${recipe.imagePath}`">
      <h4 class="fontbold">Summary</h4>
      <p class="textfont">{{ recipe.summary }}</p>

      <h4 class="fontbold">Ingredients</h4>
      <ul>
        <li v-for="ingredient of recipe.ingredients">{{ ingredient.name }}</li>
      </ul>
      <h4 class="fontbold">Method</h4>

      <p class="textfont">{{ recipe.content }}</p>
      <div v-if="authStore.isAuthenticated">
        <a class="myButton" href="#">Edit Recipe</a>
      </div>

      <hr>
      <div>
        <h4 class="h4_comment">Comments</h4>
        <div>
          <h5>Comment date and by whom</h5>
          <p>Body - Comment text</p>
          <p></p>
        </div>
      </div>

      <div class="container_buttons">
        <a class="myButton_delete" href="#" v-if="authStore.isAuthenticated">Delete Comment</a>

        <!-- v-if="`${authStore.isAuthenticated} && ${this.recipe.user.id} == ${authStore.id}`" -->
        <a class="myButton_comment" href="#">Comment Recipe</a>
      </div>


      <hr>
      <div class="bottomlinks">
        <a href="#top">Back to top of page</a>
        <router-link :to="{ name: 'Recipes' }">Back to recipes</router-link>
      </div>
      <hr>
    </article>
  </section>


<!-- STATIC -->
  <!-- <section class="container">
    <article>
      <h1 class="fontbold">Biscuit Eggs</h1>
      <img src="../images/BiscuitEggs.png">
      <h4 class="fontbold">Summary</h4>
      <p class="textfont">The butterless biscuits for these Benedicts are perfect for kids to make because they are so
        simple. For little
        and big kids: Let them help with measuring, mixing and cutting out the biscuits and making the eggless
        hollandaise.</p>

      <h4 class="fontbold">Ingredients</h4>
      <ul>
        <li>smooth flour</li>
        <li>chive</li>
        <li>baking powder</li>
        <li>sugar</li>
        <li>kosher salt</li>
        <li>goat cheese</li>
        <li>heavy cream</li>
        <li>mayonnaise</li>
        <li>lemon</li>
        <li>paprika</li>
        <li>black pepper</li>
        <li>bacon</li>
        <li>eggs</li>
      </ul>
      <h4 class="fontbold">Method</h4>

      <ul>
        <p>Biscuits:</p>
        <li>120g all-purpose flour</li>
        <li>3 tablespoons chopped fresh chives, plus more for garnish</li>
        <li>1 tablespoon baking powder</li>
        <li>1 tablespoon sugar</li>
        <li>1 1/2 teaspoons kosher salt, plus more for sprinkling</li>
        <li>170g fresh goat cheese, crumbled</li>
        <li>240ml heavy cream, plus more for brushing</li>
        <p>Quick Hollandaise:</p>
        <li>115g mayonnaise</li>
        <li>1 tablespoon fresh lemon juice</li>
        <li>1/8 teaspoon paprika</li>
        <li>Kosher salt and freshly ground black pepper</li>
        <li>8 slices Canadian bacon</li>
        <li>8 large eggs</li>
      </ul>
      <p class="textfont">
        For the biscuits: Position an oven rack in the center of the oven, and preheat to 220 degrees C. Line a baking
        sheet with parchment.
        Whisk together the flour, chives, baking powder, sugar and salt in a large bowl. Add the goat cheese, and toss,
        using your hands to break it up into pea-sized pieces. Add the cream, and mix with a wooden spoon until
        combined. Let the dough stand for 5 minutes.
        Roll the dough out into a round that is slightly less than 1/2 inch thick. Cut out 8 biscuits with a 2 1/2-inch
        round cookie cutter, and arrange them about 2 inches apart on the prepared baking sheet. Brush them with more
        cream, and sprinkle with a little salt. Bake the biscuits until just golden, 16 to 18 minutes. Transfer them to
        a wire rack, and let cool. When the biscuits are cool enough to handle, split them in half. Put 2 bottom halves
        on each of 4 plates.
        For the quick hollandaise: Whisk the mayonnaise, lemon juice, paprika and 1 tablespoon water in a small bowl,
        and season with salt and pepper; set aside.
        Heat a large nonstick skillet over medium-high heat. Cook the bacon in batches until browned, 3 to 4 minutes per
        side. Place 1 slice of bacon on each biscuit bottom, folding if needed.
        Bring a wide pot with about 2 inches of water to a very gentle simmer. Break the eggs into the water, spacing
        them apart. Cover the pot, and turn off the heat. After 2 to 3 minutes the whites should be set and the yolks
        still soft. Remove the eggs with a slotted spoon, and place on top of the Canadian bacon slices. Drizzle with
        hollandaise, sprinkle with chives and sandwich each with a biscuit top
      </p>
      <div>
        <a class="myButton" th:href="#">Edit Recipe</a>
      </div>

      <hr>
      <div>
        <h4 class="h4_comment">Comments</h4>
        <div>
          <h5>Comment date and by whom</h5>
          <p>Body - Comment text</p>
        </div>
      </div>

      <div class="container_buttons">
        <a class="myButton_delete" th:href="#">Delete Comment</a>

        <a class="myButton_comment" th:href="#">Comment Recipe</a>
      </div>


      <hr>
      <div class="bottomlinks">
        <a href="#top">Back to top of page</a>
        <router-link :to="{ name: 'Recipes' }">Back to recipes</router-link>
      </div>
      <hr>
    </article>
  </section> -->

</template>

<style scoped>
.container {
  overflow: hidden;
  display: flex;
  justify-content: space-around;
  align-items: flex-start;
}

.container article {
  margin-left: 10px;
  margin-right: 10px;
  margin-bottom: 20px;
  flex-basis: 50%;
}

.container article img {
  width: 100%;
  display: block;
}

.container article p {

  font-size: medium;
  background-color: #FFF6ED;
}

.container article a {
  font-size: medium;
  font-weight: bold;
}

.container article ul {
  font-size: medium;
  background-color: #FFF6ED;
  padding: 5px;
  margin: 0px;
}

.container article li {
  margin-left: 20px;
}

.container_buttons {
  overflow: hidden;
  display: flex;
  justify-content: space-between;
  padding-bottom: 10px;
  margin-bottom: 0;
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

.peach-btn {
  background-color: #FFDAB9;
  border: none;
  color: black;
  padding: 13px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
}

.green-btn:hover {
  background-color: #555555;
}

.red-btn {
  background-color: #FFB9BB;
}

.blue-btn {
  background-color: #00B2CE;
}

.bottomlinks {
  display: flex;
  justify-content: space-between;
}

input,
select {
  width: 20%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

textarea {
  width: 100%;
  height: 150px;
  padding: 12px 20px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color: #f8f8f8;
  resize: none;
}

.myButton {
  box-shadow: 0px 10px 14px -7px #276873;
  margin-top: 5px;
  background-color: #B9DEFF;
  border-radius: 8px;
  display: inline-block;
  cursor: pointer;
  color: black;
  font-size: 20px;
  font-weight: bold;
  padding: 13px 25px;
  text-decoration: none;
}

.myButton:hover {
  background-color: #FFDAB9;
  color: white;
}

.myButton:active {
  position: relative;
  top: 2px;
}

.h4_comment {
  background-color: #FF9F68;
  padding: 20px;
  font-weight: 700;
  margin: 0;
}

.myButton_delete {
  box-shadow: 0px 10px 14px -7px #276873;
  margin-top: 5px;
  background-color: #FFB9BB;
  border-radius: 8px;
  display: inline-block;
  cursor: pointer;
  color: black;
  font-size: 20px;
  font-weight: bold;
  padding: 13px 25px;
  text-decoration: none;
}

.myButton_delete:hover {
  background-color: #FFDAB9;
  color: white;
}

.myButton_delete:active {
  position: relative;
  top: 2px;
}

.myButton_comment {
  box-shadow: 0px 10px 14px -7px #276873;
  margin-top: 5px;
  background-color: #B9DEFF;
  border-radius: 8px;
  display: inline-block;
  cursor: pointer;
  color: black;
  font-size: 20px;
  font-weight: bold;
  padding: 13px 25px;
  text-decoration: none;
}

.myButton_comment:hover {
  background-color: #FFDAB9;
  color: white;
}

.myButton_comment:active {
  position: relative;
  top: 2px;
}
</style>