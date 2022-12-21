<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";
import ErrorMessage from "@/components/ErrorMessage.vue";

export default defineComponent({
  name: "RecipeForm",
  components: { ErrorMessage },
  data() {
    return {
      recipe: {
        title: '',
        summary: '',
        content: '',
        ingredients: [],
        imagePath: ''
      },
      error: null,
      isLoggedIn: false,
      ingredients: [],
      checkedIngredients: [],
      image: undefined
    }
  },
  created() {
    this.fetchIngredients();
  },
  computed: {
    ...mapStores(useAuthStore),
    valid() {

        const titleCheck = this.recipe.title.length > 0;
        const summaryCheck = this.recipe.summary.length > 0;
        const contentCheck = this.recipe.content.length > 0;
        const ingredientsCheck = this.checkedIngredients.length > 0;
        const imageCheck = this.image != undefined;
        console.log(titleCheck && summaryCheck && contentCheck && ingredientsCheck && imageCheck);
      return titleCheck && summaryCheck && contentCheck && ingredientsCheck && imageCheck;
    },
  },
  methods: {
    async addRecipe() {

        const url = `/api/recipes/${this.authStore.id}`;

        for (let ingredient of this.checkedIngredients) {
            this.recipe.ingredients.push({"id": ingredient});
        }

        this.error = null;

        ///////////image stuff

        let formData = new FormData();

        formData.append( 'image', this.image );

        await fetch( '/api/recipes/upload', {
            method: 'POST',
            headers: {
                //'Content-Type': 'multipart/form-data'
            },
            body: formData
        })
        .then( response => {
            if (!response.ok){
                        return Promise.reject("Page does not exist");
                    } else {
                        return response.text();
                    }
        })
        .then(answer => {
                    this.recipe.imagePath = answer;
                })
        .catch(error => console.log("An error has appered: " + error));
        
        console.log(this.recipe.imagePath);

        //////////image end
        
        fetch(url, {
            method: 'POST',
            headers: {
                "Content-Type" : "application/json"
            },
            body: JSON.stringify({
                title: this.recipe.title.trim(),
                summary: this.recipe.summary,
                content: this.recipe.content,
                ingredients: this.recipe.ingredients,
                imagePath: this.recipe.imagePath
            })
        })
        .then(response => {
            if (!response.ok){
                return Promise.reject("Page does not exist");
            } else {
                return response.json();
            }
        })
        .then(answer => {
            console.log(answer);
            this.$router.push({ name: 'Recipes' })
        })
        .catch(error => console.log("An error has appered: " + error));
    },
    fetchIngredients() {
      fetch('/api/ingredients', {})
          .then(response => response.json())
          .then(data => {
            console.log('data', data)
            this.ingredients = data;
          })
          .catch(error => console.log('error', error))
    },

    handleFileUpload( e ){
        this.image = e.target.files[0];
    }
  }
});
</script>

<template>

    <section class="container">
        <article>
            <h1 class="fontbold">Add your recipe</h1>
            <form id="formRecipe" @submit.prevent="addRecipe">
                <!-- <select class="inset" name="typeOfDish" id="typeOfDish">
                    <option value="">-- Please select type of dish --</option>
                    <option value="Breakfast">Breakfast</option>
                    <option value="Lunch">Lunch</option>
                    <option value="Dinner">Dinner</option>
                    <option value="Dessert">Dessert</option>
                </select> -->

                <!-- <select class="inset">
                    <option value="">-- Please select ingredient --</option>
                    <option v-for="ingredient of ingredients" :value="ingredient.id">{{ ingredient.name }}</option>
                </select> -->

                <!-- <div>Checked ingredients: {{ checkedIngredients }}</div> -->
                <p>Check recipe ingredients:</p>
                <div style="display: inline;">
                <label class="ingredientLabel" v-for="ingredient of ingredients" :for="ingredient.name">{{ ingredient.name }} <input type="checkbox" :value="ingredient.id" v-model="checkedIngredients" :id="ingredient.name"></label>
                </div>

                <p><label for="title">Title:</label> <input type="text" id="title"
                        placeholder="Please enter the name of the recipe" v-model="recipe.title"></p>

                <!-- <p><label for="summary">Summary:</label> <input type="text" id="summary"
                        placeholder="Please enter a summary of the recipe" rows="10" v-model="summary"></p> -->

                <p><label for="title">Summary:</label>
                    <textarea class="textarea" placeholder="Please enter a summary of the recipe" rows="10" v-model="recipe.summary"></textarea>
                </p>

                <!-- Dennis - Ingredients adding + - -->

                <p><label for="title">Method:</label>
                    <textarea class="textarea" placeholder="Please enter the cooking method" rows="20" v-model="recipe.content"></textarea>
                </p>

                <input type="file" @change="handleFileUpload( $event )"/>

                <div class="container_buttons">
                    <p><input class="myButton" type="submit" value="Add recipe" :disabled="!valid"></p>
                </div>
            </form>
            <ErrorMessage v-if="error?.message" :error="error"/>
        </article>
    </section>

</template>

<style scoped>
.container {
    overflow: hidden;
    display: flex;
    justify-content: center;

}

.container article {
    margin-left: 10px;
    margin-right: 10px;
    margin-bottom: 20px;
    background-color: #FFF6ED;
    width: 1000px;
    /* flex-basis: 100%; */
}

.container article h1 {
    font-size: medium;
    background-color: #FFF6ED;
}

.container article p {
    font-size: medium;
}


:focus-visible {
    outline-color: #FFBF86;
    outline-offset: 3px;
    border-color: #FFDAB9;
    border-style: solid;
}

#formRecipe input[type=text],
#formRecipe textarea {
    width: 50%;
    background-color: white;
    height: 25px;
    border-bottom: 1px solid black;
    box-shadow: inset 2px 2px 2px grey, 0 -1px 1px white;
}

#formRecipe textarea {
    height: 200px;
    resize: none;
    border: 3px solid transparent;
    /* box-shadow: inset 0 1px 2px rgba(0, 0, 0, 4); */
    box-shadow: inset 2px 2px 2px grey, 0 -1px 1px white;
    background-color: white;
    width: 80%;
}


.error {
    background-color: #FDB9FF;
}

#formRecipe label {
    display: inline-block;
    width: 100px;
    text-align: right;

}

.inset {
    /* border: 3px solid transparent;
   box-shadow: inset 0 1px 2px rgba(0,0,0,4); */
    /* border-bottom: 1px solid black; */
    box-shadow: inset 2px 2px 2px grey, 0 -1px 1px white;
    width: 220px;
    height: 30px;
    text-align: center;
    background-color: white;
    margin-left: 100px;
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

.container_buttons {
    overflow: hidden;
    display: flex;
    justify-content: space-between;
    padding-bottom: 10px;
    margin-bottom: 0;
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
    border: none;
}

.myButton:hover {
    background-color: #FFDAB9;
    color: white;
}

.myButton:active {
    position: relative;
    top: 2px;
}

.ingredientLabel {
    margin-left: 5px;
}
</style>