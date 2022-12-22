<template>
  <section class="container">

    <!-- <router-link :to="{name:'Home'}"><img src="../images/dmd_logo.png" class="logoimage"></router-link> -->

    <!-- <article>
      <p>Damir Šmintić</p>
      <router-link :to="{name:'Damir'}"><img src="../images/D></router-link>
    </article> -->

    <article>
      <p>Marija Mamić</p>
      <router-link :to="{name:'Marija'}"><img src="../images/Marija_chefs.png"></router-link>
    </article>

    <article>
      <p>Denis Križak</p>
      <router-link :to="{name:'Dennis'}"><img src="../images/Denis_chefs.png"></router-link>
    </article>
  </section>
</template>

<style scoped>
.container {
  overflow: hidden;
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  
}

.container article {
  margin-left: 10px;
  margin-right: 10px;
  margin-bottom: 20px;
  width: 33%;
  text-align: center;
}

.container article img {
  width: 50%;
  display: block;
  margin: auto;
  border: 2px solid black;
}

.container article p {
  font-size: 700;
}

.container a {
  margin: 0;
  padding: 0;
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
</style>