<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";
import Logout from "@/components/Logout.vue";

export default defineComponent({
    components: { Logout },
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

    <section class="container">

        <div>
            <router-link :to="{ name: 'Home' }"><img src="../images/dmd_logo.png" class="logoimage"></router-link>
        </div>

        <div>
            <router-link :to="{ name: 'Recipes' }">Recipes</router-link>
            <router-link :to="{ name: 'Calculator'}">Cook Calculator</router-link>
            <router-link :to="{ name: 'Video' }">Videos</router-link>
            <router-link :to="{ name: 'Chefs' }">Chefs</router-link>
        </div>

        <div>
            <router-link :to="{ name: 'AddRecipe' }" v-if="authStore.isAuthenticated">Add recipe</router-link>
            <label id="usercolor">{{ authStore.username }}</label>
            <router-link :to="{ name: 'SignIn' }" v-if="!authStore.isAuthenticated">Sign in</router-link>
            <Logout></Logout>
        </div>

    </section>


</template>

<style>
.container {
    margin: 0;
    padding: 0;
    overflow: hidden;
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-size: 1.3em;
}


.container a {
    text-decoration: none;
    color: black;
    padding: 10px 20px;
    display: inline-block;
}


.container a:hover {
    /* background-color: whitesmoke; */
    color: #FF9F68;
    opacity: 1;
    /* font-weight: bold; */
}

.logoimage {
    width: 125px;
    padding: 0;
    margin: 0;
}

#usercolor {
    color: #FF9F68;
}
</style>
