<template>
    <section class="container">
      <article>
          <h1 class="fontbold"><router-link :to="{ name:'Recipe'}">Biscuit Eggs</router-link></h1>
          <img src="../images/BiscuitEggs.png">
          <p class="textfont">The butterless biscuits for these Benedicts are perfect for kids to make because they are so simple. For little and big kids: Let them help with measuring, mixing and cutting out the biscuits and making the eggless hollandaise.</p>
      </article>
  
      <article>
          <h1 class="fontbold">Title 2</h1>
          <img src="../images/King Prawns and Clam Minestrone.png">
          <p class="textfont">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis mollitia officiis ad
            unde perspiciatis ratione. Voluptate commodi dignissimos distinctio. Animi in est eligendi corporis deleniti
            magnam qui ad culpa voluptate?
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis mollitia officiis ad
            unde perspiciatis ratione. Voluptate commodi dignissimos distinctio. Animi in est eligendi corporis deleniti
            magnam qui ad culpa voluptate?
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis mollitia officiis ad
            unde perspiciatis ratione. Voluptate commodi dignissimos distinctio. Animi in est eligendi corporis deleniti
            magnam qui ad culpa voluptate?</p>
      </article>
  
      <article>
          <h1 class="fontbold">Title 3</h1>
          <img src="../images/Avocado Toasts.png">
          <p class="textfont">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis mollitia officiis ad
            unde perspiciatis ratione. Voluptate commodi dignissimos distinctio. Animi in est eligendi corporis deleniti
            magnam qui ad culpa voluptate?</p>
      </article>
    </section>
  
  
    <section class="container">
      <article>
          <h1 class="fontbold">Title 4</h1>
          <img src="../images/Chicken Kabobs with Grilled Onions.png">
  
          <p class="textfont">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis mollitia officiis ad
            unde perspiciatis ratione. Voluptate commodi dignissimos distinctio. Animi in est eligendi corporis deleniti
            magnam qui ad culpa voluptate?</p>
      </article>
  
      <article>
          <h1 class="fontbold">Title 5</h1>
          <img src="../images/French omelette.png">
  
          <p class="textfont">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis mollitia officiis ad
            unde perspiciatis ratione. Voluptate commodi dignissimos distinctio. Animi in est eligendi corporis deleniti
            magnam qui ad culpa voluptate?</p>
      </article>
  
      <article>
          <h1 class="fontbold">Title 6</h1>
          <img src="../images/Prosciutto Lamb Burgers.png">
  
          <p class="textfont">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis mollitia officiis ad
            unde perspiciatis ratione. Voluptate commodi dignissimos distinctio. Animi in est eligendi corporis deleniti
            magnam qui ad culpa voluptate?</p>
      </article>
    </section>
  
    <section class="container">
      <article>
          <h1 class="fontbold">Title 4</h1>
          <img src="../images/Tomato Soup.png">
  
          <p class="textfont">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis mollitia officiis ad
            unde perspiciatis ratione. Voluptate commodi dignissimos distinctio. Animi in est eligendi corporis deleniti
            magnam qui ad culpa voluptate?</p>
      </article>
  
      <article>
          <h1 class="fontbold">Title 5</h1>
          <img src="../images/Tenderstem, Bacon and Egg Brunch Salad.png">
  
          <p class="textfont">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis mollitia officiis ad
            unde perspiciatis ratione. Voluptate commodi dignissimos distinctio. Animi in est eligendi corporis deleniti
            magnam qui ad culpa voluptate?</p>
      </article>
  
      <article>
          <h1 class="fontbold">Title 6</h1>
          <img src="../images/Steak on Garlic Toast with Provolone and Parsley oil.png">
  
          <p class="textfont">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis mollitia officiis ad
            unde perspiciatis ratione. Voluptate commodi dignissimos distinctio. Animi in est eligendi corporis deleniti
            magnam qui ad culpa voluptate?</p>
      </article>
    </section>
    
    <section class="container">
      <article>
          <h1 class="fontbold">Title 4</h1>
          <img src="../images/5-Minute Yoghurt and Fruit Parfaits.png">
  
          <p class="textfont">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis mollitia officiis ad
            unde perspiciatis ratione. Voluptate commodi dignissimos distinctio. Animi in est eligendi corporis deleniti
            magnam qui ad culpa voluptate?</p>
      </article>
  
      <article>
          <h1 class="fontbold">Title 5</h1>
          <img src="../images/Spicy Hoisin Glazed Aubergine.png">
  
          <p class="textfont">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis mollitia officiis ad
            unde perspiciatis ratione. Voluptate commodi dignissimos distinctio. Animi in est eligendi corporis deleniti
            magnam qui ad culpa voluptate?</p>
      </article>
  
      <article>
          <h1 class="fontbold">Title 6</h1>
          <img src="../images/Smoked Salmon and Sugar Snap Pea Salad in a Jar.png">
  
          <p class="textfont">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis mollitia officiis ad
            unde perspiciatis ratione. Voluptate commodi dignissimos distinctio. Animi in est eligendi corporis deleniti
            magnam qui ad culpa voluptate?</p>
      </article>
    </section>


  
  </template>


<style scoped>

.container {
    overflow: hidden;
    display: flex;
    justify-content: space-around;
    align-items: flex-start;
}

.container a{
    margin: 0;
    padding: 0;
}

.container article{
  margin-left: 10px;
  margin-right: 10px;
  margin-bottom: 20px;
  flex-basis: 33%;
}

.container article img{
  width: 100%;
  display: block;
}

.container article p{
  font-size: medium;
  background-color: #FFF6ED;
}


.fontbold {
  background-color:peachpuff;
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
