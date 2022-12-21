<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";
import ErrorMessage from "@/components/ErrorMessage.vue";

export default defineComponent({
  name: "RegistrationForm",
  components: { ErrorMessage },
  data() {
    return {
      registrationData: {
        username: '',
        password1: '',
        password2: ''
      },
      response: null,
      error: null
    }
  },
  computed: {
    ...mapStores(useAuthStore),
    valid() {
      const usernameValid = this.registrationData.username.length > 0;
      const passwordValid = this.registrationData.password1.length > 3;
      const passwordRepeatValid = this.registrationData.password1 === this.registrationData.password2;
      return usernameValid && passwordValid && passwordRepeatValid;
    },
  },
  methods: {
    register() {
      this.error = null;
      this.authStore.register(this.registrationData)
        .then(data => {
          this.response = data;
          this.$router.push({ name: 'Home' })
        })
        .catch(error => {
          this.error = error.message
        })
    }
  }
});
</script>

<template>
  <section class="container">
    <article>
      <h1>Create DMD account</h1>
      <form id="formRegister" @submit.prevent="register" v-if="!response">

        <p class="fontbold">Username</p>
        <p>
          <label for="username">
            <input type="text" id="username" autocomplete="username" v-model="registrationData.username">
          </label>
        </p>

        <p class="fontbold">Password</p>
        <p>
          <label for="password1">
            <input type="password" id="password1" autocomplete="new-password" v-model="registrationData.password1">
          </label>
        </p>

        <p class="fontbold">Repeat password</p>
        <p><label for="password2">
            <input type="password" id="password2" autocomplete="new-password" v-model="registrationData.password2">
          </label></p>

        <div class="container_buttons">
          <button class="myButton" type="submit" :disabled="!valid">Register</button>
        </div>
      </form>

    </article>
  </section>

  <ErrorMessage v-if="error?.message" :error="error" />
</template>

<style scoped>
fieldset {
  border: 0;
}

fieldset>label {
  display: block;
  width: 10rem;
  margin-bottom: 1rem;
}

label>span {
  display: block;
  margin-bottom: 0.2rem;
}

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

#formRegister input[type=text],
#formRegister input[type=password] {
  width: 100%;
  background-color: white;
  height: 25px;
  border: transparent;
  box-shadow: inset 2px 2px 2px grey, 0 -1px 1px white;
  vertical-align: top;
  margin-top: 0px;
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
