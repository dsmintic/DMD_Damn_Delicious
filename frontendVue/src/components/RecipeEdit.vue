<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";
import { useRoute } from 'vue-router';

export default defineComponent({
    name: "RecipeForm",
    data() {
        return {
            recipe: {
                title: '',
                summary: '',
                content: '',
                ingredients: [],
                imagePath: ''
            },
            id: '',
            ingredients: [],
            checkedIngredients: [],
            image: undefined
        }
    },
    created() {
        
    },
    async beforeMount() {
      const route = useRoute();
      this.id = route.params.id;
      //let res = await new Promise((resolve, reject) => this.fetchRecipe());
      this.fetchRecipe();
      this.fetchIngredients();
    },
    mounted() {
        this.updateCheckedIngredients();
    },
    computed: {
        ...mapStores(useAuthStore),
        valid() {

            const titleCheck = this.recipe.title.length > 0;
            const summaryCheck = this.recipe.summary.length > 0;
            const contentCheck = this.recipe.content.length > 0;
            const ingredientsCheck = this.checkedIngredients.length > 0;
            //const imageCheck = this.image != undefined;
            console.log(titleCheck && summaryCheck && contentCheck && ingredientsCheck);
            return titleCheck && summaryCheck && contentCheck && ingredientsCheck;
        },
    },
    methods: {
        async addRecipe() {

            const url = `/api/recipes/${this.id}`;

            this.recipe.ingredients = [];

            for (let ingredient of this.checkedIngredients) {
                this.recipe.ingredients.push({ "id": ingredient });
            }


            ///////////image stuff

            if (this.image == undefined) {
                this.recipe.imagePath = "empty";
            } else {
                let formData = new FormData();

                formData.append('image', this.image);

                await fetch('/api/recipes/upload', {
                    method: 'POST',
                    headers: {
                        //'Content-Type': 'multipart/form-data'
                    },
                    body: formData
                })
                    .then(response => {
                        if (!response.ok) {
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

            }

            

            //////////image end

            fetch(url, {
                method: 'PUT',
                headers: {
                    "Content-Type": "application/json"
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
                    if (!response.ok) {
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
                    //console.log('data', data)
                    this.ingredients = data;
                })
                .catch(error => console.log('error', error))
        },
        fetchRecipe() {
            let url = "/api/recipes/" + this.id;
            fetch(url, {})
                .then(response => response.json())
                .then(data => {
                    this.recipe = data;
                })
                .catch(error => console.log('error', error))
        },

        updateCheckedIngredients() {

            let url = "/api/ingredients/recipe/" + this.id;
            let tmpIngredients;

            fetch(url, {})
                .then(response => response.json())
                .then(data => {
                    tmpIngredients = data;
                    console.log(tmpIngredients);
                    for (let ingredient of tmpIngredients) {
                        this.checkedIngredients.push(ingredient.id);
                    }
                })
                .catch(error => console.log('error', error))

            console.log(this.recipe.imagePath);
            console.log(this.recipe);

        },

        handleFileUpload(e) {
            this.image = e.target.files[0];
        }
    }
});
</script>

<template>

    <section class="container">
        <article>
            <h1 class="fontbold">Edit your recipe</h1>
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
                    <span class="ingredientLabel" v-for="ingredient of ingredients" :for="ingredient.name">{{
                            ingredient.name
                    }} <input class="checkboxtext" type="checkbox" :value="ingredient.id" v-model="checkedIngredients"
                            :id="ingredient.name"></span>
                </div>

                <p><label for="title">Title:</label> <input type="text" id="title"
                        placeholder="Please enter the name of the recipe" v-model="recipe.title"></p>

                <!-- <p><label for="summary">Summary:</label> <input type="text" id="summary"
                        placeholder="Please enter a summary of the recipe" rows="10" v-model="summary"></p> -->

                <p><label for="title">Summary:</label>
                    <textarea class="summarytext" placeholder="Please enter a summary of the recipe" rows="10"
                        v-model="recipe.summary"></textarea>
                </p>

                <!-- Dennis - Ingredients adding + - -->

                <p><label for="title">Method:</label>
                    <textarea class="methodtext" placeholder="Please enter the cooking method" rows="50"
                        v-model="recipe.content"></textarea>
                </p>

                <div class="container_buttons">
                    <input class="myButton" type="file" @change="handleFileUpload($event)" />
                </div>

                <div class="container_buttons">
                    <p><input class="myButton" type="submit" value="Save recipe" :disabled="!valid"></p>
                </div>
            </form>
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
}

.container article h1 {
    /* font-size: medium; */
    font-weight: 700;
    background-color: #FFF6ED;
    color: #FF9F68;
    display: flex;
    justify-content: center;
}

.container article p {
    font-size: medium;
    font-weight: 400;
    margin-left: 20px;
}


:focus-visible {
    outline-color: #B9DEFF;
    outline-offset: 3px;
    border-color: #FFDAB9;
    border-style: solid;
}

#formRecipe input[type=text] {
    width: 50%;
    background-color: white;
    height: 25px;
    border: transparent;
    box-shadow: inset 2px 2px 2px grey, 0 -1px 1px white;
    
}

.summarytext {
    height: 50px;
    resize: none;
    border: 3px solid transparent;
    box-shadow: inset 2px 2px 2px grey, 0 -1px 1px white;
    background-color: white;
    width: 80%;
    vertical-align: top;
}

.methodtext {
    height: 200px;
    resize: none;
    border: 3px solid transparent;
    box-shadow: inset 2px 2px 2px grey, 0 -1px 1px white;
    background-color: white;
    width: 80%;
    vertical-align: top;
}

.error {
    background-color: #FDB9FF;
}

#formRecipe label {
    display: inline-block;
    width: 100px;
    text-align: right;
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
    justify-content: center;
    padding-bottom: 10px;
    margin-bottom: 0;
}

.myButton {
    box-shadow: 0px 10px 14px -7px #276873;
    margin-top: 5px;
    background-color: #B9DEFF;
    border-radius: 8px;
    cursor: pointer;
    color: black;
    font-size: 15px;
    font-weight: bold;
    padding: 10px 20px;
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
    margin-left: 10px;
    font-size: medium;
    /* display: inline; */
}

.checkboxtext
{
  /* Checkbox text */
  display: inline;
}
</style>