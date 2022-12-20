<script>
import { defineComponent } from "vue";

export default defineComponent({
  props: {
    error: {
      type: Object,
      required: true,
    }
  }
})
</script>

<template>
  <div class="error" v-if="error?.message">{{ this.error.message }}</div>
</template>

<style scoped>
.error {
  height: 2rem;
  line-height: 2rem;
  padding-left: 0.2rem;
  color: red;
  border-left: lightcoral 2px solid;
}

</style>