<script>
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";
import { useRoute } from 'vue-router';

export default {
  data() {
    return {
      comment: {
        text: ''
      },
      recipe: {},
      id: '',
      comments: [],
      showEdit: []
    }
  },
  created() {
    // const route = useRoute();
    // this.id = route.params.id;
    // this.fetchRecipe();
  },
  async beforeMount() {
    const route = useRoute();
    this.id = route.params.id;
    //let res = await new Promise((resolve, reject) => this.fetchRecipe());
    this.fetchRecipe();
    this.fetchComments();
  },
  computed: {
    ...mapStores(useAuthStore),
    valid() {
      return this.comment.text.trim().length > 0;
    }
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
    },
    async fetchComments() {
      let url = "/api/comments/r/" + this.id;
      console.log(url);
      fetch(url, {})
        .then(response => response.json())
        .then(data => {
          this.comments = data;
        })
        .catch(error => console.log('error', error))
    },
    addComment() {
      console.log(this.comment.text);

      let url = "/api/comments/" + this.authStore.id + "/" + this.recipe.id;

      console.log(url);

      fetch(url, {
        method: 'POST',
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          text: this.comment.text
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
          this.fetchComments();
          this.comment.text = '';
          //this.$router.push({ name: 'Recipes' })
        })
        .catch(error => console.log("An error has appered: " + error));
    },
    async deleteComment(index) {
      let url = "/api/comments/" + this.comments[index].id;

      let response1 = await fetch(url, { method: 'DELETE' })
        .catch(error => console.log('error', error));


      // await fetch(url, {method: 'DELETE'})
      //     .then(response => {
      //       if (!response.ok) {
      //                   return Promise.reject("Page does not exist");
      //               } else {
      //                   //console.log("tralala");
      //                   return response.text();
      //               }
      //     })
      //     // .then(answer => {
      //     //   this.fetchComments();
      //     // })
      //     .catch(error => console.log('error', error))
      this.fetchComments();
    },
    async editComment(index) {

      let url = "/api/comments/" + this.comments[index].id;

      let response = await fetch(url, {
        method: 'PUT',
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          text: this.comments[index].text
        })
      }).catch(error => console.log('error', error));

      this.showEditChange(index);

    },
    showEditChange(index) {
      this.showEdit[index] = !this.showEdit[index];
    }
  }
}
</script>

<template>

  <section class="container">
    <article>
      <h1 class="fontbold">{{ recipe.title }}</h1>
      <img :src="`${recipe.imagePath}`">
      <div class="ratingContainer">
          <!-- <font-awesome-icon class="star" icon="fa-solid fa-star" v-for="i in getRating(recipe.id)" /> -->
      </div>
      <h4 class="fontbold">Summary</h4>
      <p class="textfont">{{ recipe.summary }}</p>

      <h4 class="fontbold">Ingredients</h4>
      <ul>
        <li v-for="ingredient of recipe.ingredients">{{ ingredient.name }}</li>
      </ul>
      <h4 class="fontbold">Method</h4>

      <p class="textfont">{{ recipe.content }}</p>
      <hr>
      <p class="created">Published by: {{ recipe.user.username }}</p>
      <p class="created">Published on: {{ recipe.creationDate }}</p>

      <div class="recipeButtonsWrapper" v-if="authStore.isAuthenticated">
        <router-link class="myButton"
          v-if="authStore.isAuthenticated && authStore.id == recipe.user.id || authStore.admin"
          :to="`editrecipe/${recipe.id}`">Edit Recipe</router-link>
        <!-- <a class="myButton" href="#" v-if="authStore.isAuthenticated && authStore.id == recipe.user.id || authStore.admin">Edit Recipe</a> -->


        <router-link class="myButton_del"
          v-if="authStore.isAuthenticated && authStore.id == recipe.user.id || authStore.admin"
          :to="`editrecipe/${recipe.id}`">Delete Recipe</router-link>
      </div>

      <hr>
      <div>
        <h4 class="h4_comment">Comments</h4>
        <div class="commentsWrapper">
          <article class="commentsContainer" v-for="(comment, index) in comments">
            <p>{{ comment.text }}</p>
            <div class="commentPostedWrapper">
              <small>Posted on: {{ comment.creationDate }}</small>
              <small>Posted by: {{ comment.user.username }}</small>
            </div>
            <div class="commentButtonsWrapper"
              v-if="authStore.isAuthenticated && authStore.id == comment.user.id || authStore.admin">
              <button class="myButton_edit" v-if="authStore.isAuthenticated"
                @click="showEditChange(index)">Edit</button>
              <button class="myButton_delete" v-if="authStore.isAuthenticated"
                @click="deleteComment(index)">Delete</button>
            </div>

            <section class="commentContainer"
              v-if="authStore.isAuthenticated && authStore.id == comment.user.id || authStore.admin"
              v-show="showEdit[index]">
              <article>
                <h1 class="fontbold">Write new comment</h1>
                <form id="formRecipe" @submit.prevent="editComment(index)">


                  <p><label for="title"></label>
                    <textarea class="textarea" placeholder="Please edit comment." rows="5"
                      v-model="comment.text"></textarea>
                  </p>

                  <div class="container_buttons">
                    <p><input class="commentButton" type="submit" value="Save comment"></p>
                  </div>

                </form>
              </article>
            </section>


          </article>
          <!-- comment form -->
          <section class="commentContainer" v-if="authStore.isAuthenticated">
            <article>
              <h1 class="fontbold">Write new comment</h1>
              <form id="formRecipe" @submit.prevent="addComment">


                <p><label for="title"></label>
                  <textarea class="textarea" placeholder="Comment this recipe..." rows="5"
                    v-model="comment.text"></textarea>
                </p>

                <div class="container_buttons">
                  <p><input class="commentButton" type="submit" value="Add comment" :disabled="!valid"></p>
                </div>

              </form>
            </article>
          </section>
        </div>
      </div>

      <hr>
      <div class="bottomlinks">
        <a href="#top">Back to top of page</a>
        <router-link :to="{ name: 'Recipes' }">Back to recipes</router-link>
      </div>
      <hr>
    </article>
  </section>

</template>

<style scoped>
.container {
  overflow: hidden;
  display: flex;
  max-width: 70%;
  justify-content: space-around;
  align-items: flex-start;
  margin: auto;
}

.container article {
  margin-left: 10px;
  margin-right: 10px;
  margin-bottom: 20px;
  /* flex-basis: 50%; */
}

.container article img {
  width: 100%;
  display: block;
}

.container article p {
  font-size: medium;
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

.created {
    margin-left: 10px;
    margin-top: 5px;
    margin-bottom: 5px;
    text-align: left;
    font-weight:bold;
    color: #FF9F68;
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
  padding: 10px 20px;
  text-decoration: none;
}

.myButton:hover {
  background-color: #FF9F68;
  color: white;
}

.myButton:active {
  position: relative;
  top: 2px;
}

.myButton_del {
  box-shadow: 0px 10px 14px -7px #276873;
  margin-top: 5px;
  background-color: #FFB9BB;
  border-radius: 8px;
  display: inline-block;
  cursor: pointer;
  color: black;
  font-size: 20px;
  font-weight: bold;
  padding: 10px 20px;
  text-decoration: none;
}

.myButton_del:hover {
  background-color: #FF9F68;
  color: white;
}

.myButton_del:active {
  position: relative;
  top: 2px;
}

.recipeButtonsWrapper {
  display: flex;
  justify-content: space-between;
}

.h4_comment {
  background-color: #FF9F68;
  padding: 20px;
  font-weight: 700;
  margin: 0;
}

.myButton_edit {
  box-shadow: 0px 10px 14px -7px #276873;
  margin-top: 5px;
  margin-right: 10px;
  background-color: #B9DEFF;
  border-radius: 8px;
  display: inline-block;
  cursor: pointer;
  color: black;
  font-size: 20px;
  font-size: medium;
  font-weight: bold;
  padding: 5px 10px;
  text-decoration: none;
  border: none;
}

.myButton_edit:hover {
  background-color: #FF9F68;
  color: white;
}

.myButton_edit:active {
  position: relative;
  top: 2px;
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
  font-size: medium;
  font-weight: bold;
  padding: 5px 10px;
  text-decoration: none;
  border: none;
}

.myButton_delete:hover {
  background-color: #FF9F68;
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

/* comment */
.commentContainer {
  overflow: hidden;
  display: flex;
  justify-content: center;
  background-color: #FFDAB9 !important;
  margin-top: 10px;
}

.commentContainer article {
  /* margin-left: 10px;
    margin-right: 10px;
    margin-bottom: 20px; */
  margin: 0;
  background-color: #FFF6ED;
  width: 100%;
}

.commentContainer article h1 {
  font-size: medium;
  background-color: #FFF6ED;
}

.commentContainer article p {
  font-size: medium;
}


:focus-visible {
  outline-color: #B9DEFF;
  outline-offset: 3px;
  border-color: #FFDAB9;
  border-style: solid;
}

#formRecipe input[type=text],
#formRecipe textarea {
  width: 50%;
  background-color: white;
  height: 50px;
  border: transparent;
  box-shadow: inset 2px 2px 2px grey, 0 -1px 1px white;
  vertical-align: top;
}

#formRecipe textarea {
  height: 70px;
  resize: none;
  border: 3px solid transparent;
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


.container_buttons {
  overflow: hidden;
  display: flex;
  justify-content: center;
  padding-bottom: 10px;
  margin-bottom: 0;
}

.commentButton {
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
  width: 150px;
}

.commentButton:hover {
  background-color: #FFDAB9;
  color: white;
}

.commentButton:active {
  position: relative;
  top: 2px;
}

.commentsContainer {
  background-color: #FFDAB9;
  /* margin: 0!important; */
  margin-left: 0 !important;
  margin-right: 0 !important;
  margin-top: 0;
  padding: 10px;
  margin-bottom: 5px;
}

.commentsContainer p {
  /* background-color: #FFF6ED!important; */
  margin: 0;
}

.commentPostedWrapper {
  display: flex;
  justify-content: space-between;
  padding-top: 10px;
  padding-bottom: 10px;
  font-size: 0.7em;
}

.commentsWrapper {
  background-color: white;
}

.commentButtonsWrapper {
  display: flex;
  justify-content: end;
}

hr {
  border: 2px solid peachpuff;
}

.ratingContainer {
  display: flex;
}
</style>