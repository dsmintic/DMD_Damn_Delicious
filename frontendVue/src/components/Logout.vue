<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";

export default defineComponent({
  methods: {
    logout() {
      this.authStore.logout()
          .then(() => this.$router.push({ name: 'Home' }))
    },
  },
  computed: {
    ...mapStores(useAuthStore)
  }
});
</script>

<template>
  <button class="myButton" @click="logout" v-if="authStore.isAuthenticated">Logout</button>
</template>


<style scoped>


.myButton {
  box-shadow: 0px 10px 14px -7px #276873;
  margin-top: 5px;
  background-color: #FFDAB9;
  border-radius: 8px;
  cursor: pointer;
  color: black;
  font-size: 15px;
  font-weight: bold;
  padding: 10px 20px;
  text-decoration: none;
  border: none;
  margin-left: 15px;
}

.myButton:hover {
  background-color: #B9DEFF;
  color: white;
}

.myButton:active {
  position: relative;
  top: 2px;
}

</style>