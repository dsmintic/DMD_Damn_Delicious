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
  <form @submit.prevent="register" v-if="!response">
    <fieldset>
      <label for="username">
        <span>Username</span>
        <input type="text" id="username" autocomplete="username" v-model="registrationData.username">
      </label>

      <label for="password1">
        <span>Password</span>
        <input type="password" id="password1" autocomplete="new-password" v-model="registrationData.password1">
      </label>

      <label for="password2">
        <span>Password repeat</span>
        <input type="password" id="password2" autocomplete="new-password" v-model="registrationData.password2">
      </label>

      <button type="submit" :disabled="!valid">Register</button>
    </fieldset>
  </form>

  <ErrorMessage v-if="error?.message" :error="error"/>
</template>

<style scoped>
fieldset {
  border: 0;
}

fieldset > label {
  display: block;
  width: 10rem;
  margin-bottom: 1rem;
}

label > span {
  display: block;
  margin-bottom: 0.2rem;
}
</style>
