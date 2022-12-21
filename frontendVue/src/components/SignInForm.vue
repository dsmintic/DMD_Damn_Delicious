<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";
import ErrorMessage from "@/components/ErrorMessage.vue";

export default defineComponent({
  name: "LoginForm",
  components: { ErrorMessage },
  data() {
    return {
      user: {
        username: '',
        password: ''
      },
      error: null,
      isLoggedIn: false,
    }
  },
  methods: {
    login() {
      this.authStore.login(this.user)
        .then(() => this.$router.push({ name: 'Home' }))
        .catch(error => this.error = { message: "Login failed." })
    },
  },
  computed: {
    ...mapStores(useAuthStore),
    valid() {
      return this.user.username.length > 0 && this.user.password.length > 0;
    },
  }
});
</script>

<template>

  <section class="container">
    <article>
      <h1>Sign in</h1>
      <form id="formSignin" @submit.prevent="login" v-if="!authStore.isAuthenticated">
        
        <p class="fontbold">Username</p>
        <p>
          <label for="username">
            <input type="text" id="username" autocomplete="username" class="textarea" v-model="user.username">
          </label>
        </p>

        <p class="fontbold">Password</p>
        <p>
          <label for="password">
            <input type="password" id="password" autocomplete="current-password" class="textarea" v-model="user.password">
          </label>
        </p>

        <div class="container_buttons">
          <button class="myButton" type="submit" :disabled="!valid">Login</button>
        </div>
        
      </form>

      <p class="fontbold"><label>Don't have an account?</label></p>
      
      <p class="fontbold"><router-link :to="{ name: 'Register' }" id="register">Register</router-link>
      <ErrorMessage v-if="error?.message" :error="error" /></p>
      

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
  width: 470px;
}

.container article h1 {
  display: flex;
  justify-content: center;
  font-size: medium;
  background-color: #FFF6ED;
  color: #FDB9FF;
}

.container article p {
  font-size: medium;
  display: flex;
  justify-content: center;
}



:focus-visible {
  outline-color: #B9DEFF;
  outline-offset: 3px;
  border-color: #FFDAB9;
  border-style: solid;
}

#formSignin input[type=text],
#formSignin input[type=password] {
  width: 100%;
  background-color: white;
  height: 25px;
  border: transparent;
  box-shadow: inset 2px 2px 2px grey, 0 -1px 1px white;
  vertical-align: top;
  
}

#formSignin textarea {
  height: 200px;
  resize: none;
  border: 3px solid transparent;
  box-shadow: inset 2px 2px 2px grey, 0 -1px 1px white;
  background-color: white;
  width: 80%;
}


.error {
  background-color: #FDB9FF;
}

#formSignin label {
  display: inline-block;
  width: 200px;
  text-align: left;
  display: flex;
  justify-content: center;
}

.fontbold {
  font-weight: 700;
}

.textfont {
  font-weight: 100;
  padding: 10px;
  margin: 0;
}

#register {
  color: #FF9F68;
}

#register:hover{
  color: #B9DEFF;
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
</style>