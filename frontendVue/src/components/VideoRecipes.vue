<template>

<h1 class="title">Once a week, the best rated recipe is published in a video by one of ours chefs.</h1>
    <section class="container">
        
        <article>
            <h1 class="fontbold">Rainbow eggs</h1>
            <video controls>
                <source src="../video/color_egg.mp4" type="video/mp4">
            </video>
            <p class="textfont">This is the best recipe from week 21 that you have chosen. Prepare this dish with the help of chef Marija. These boiled rainbow eggs brighten dull days and show your creativity.</p>
            <p class="created">Published by: Marija Mamić</p>
            <p class="created">Published on: 22.12.2022</p>
        </article>

        <article>
            <h1 class="fontbold">Fruit Dessert</h1>
            <video controls>
                <source src="../video/Fruit_desert.mp4" type="video/mp4">
            </video>
            <p class="textfont">This is the best recipe from week 20 that you have chosen. Prepare this dish with the help of chef Denis. A fruit dessert cup is an elegant, simple dessert that even somebody who doesn't prepare desserts often can make. Enjoy this dessert.</p>
            <p class="created">Published by: Denis Križak</p>
            <p class="created">Published on: 14.12.2022</p>
        </article>

        <article>
            <h1 class="fontbold">Dessert Cups with Tiramisu</h1>
            <video controls>
                <source src="../video/tiramisu_desert.mp4" type="video/mp4">
            </video>
            <p class="textfont">This is the best recipe from week 19 that you have chosen. Prepare this dish with the help of chef Damir. Dessert cups with tiramisu - for coffee lovers, this is the right dessert. Brown color is also emphasized by serving it in transparent cups.</p>
            <p class="created">Published by: Damir Šmintić</p>
            <p class="created">Published on: 07.12.2022</p>
        </article>
    </section>

    <section class="container">
        <article>
            <h1 class="fontbold">Best recipes</h1>
            <video controls>
                <source src="../video/all_cakes.mp4" type="video/mp4">
            </video>
            <p class="textfont">This is the best recipe from week 18 that you have chosen. Prepare this dish with the help of chef Denis. On our website, you can see pictures of some of the recipes. Become a member and upload your pictures if you want to share your recipes with us.</p>
            <p class="created">Published by: Denis Križak</p>
            <p class="created">Published on: 01.12.2022</p>
        </article>

        <article>
            <h1 class="fontbold">From the heart</h1>
            <video controls>
                <source src="../video/egg_and_backon.mp4" type="video/mp4">
            </video>
            <p class="textfont">This is the best recipe from week 17 that you have chosen. Prepare this dish with the help of chef Marija. There is nothing more simple and satisfying than this recipe for lovers and those who feel that way. I like the simple way the recipe is prepared and the visual is very appealing. Recommendation - to serve in bed.</p>
            <p class="created">Published by: Marija Mamić</p>
            <p class="created">Published on: 22.11.2022</p>
        </article>

        <article>
            <h1 class="fontbold">Steak</h1>
            <video controls>
                <source src="../video/all_recipes.mp4" type="video/mp4">
            </video>
            <p class="textfont">This is the best recipe from week 16 that you have chosen. Prepare this dish with the help of chef Damir. On our website, you can see pictures of some of the recipes. Become a member and upload your pictures if you want to share your recipes with us.</p>
            <p class="created">Published by: Damir Šmintić</p>
            <p class="created">Published on: 15.11.2022</p>
        </article>
    </section>

    <!-- <section class="container">
        <article>
            <h1 class="fontbold">Video 7</h1>
            <video controls>
                <source src="../video/all_recipes.mp4" type="video/mp4">
            </video>
            <p class="textfont">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Architecto quam veniam a,
                cumque, excepturi non
                exercitationem temporibus maiores ipsam quod provident recusandae quos, eligendi ea saepe suscipit rerum
                ipsa sapiente? aksdhfksdjfkg</p>
            <p class="created">Created by: Marija Mamić</p>
            <p class="created">Created on: 08.11.2022</p>
        </article>
    </section> -->
</template>

<style scoped>
.container {
    overflow: hidden;
    display: flex;
    justify-content: space-around;
    align-items: flex-start;
}

.container article {
    margin-left: 10px;
    margin-right: 10px;
    margin-bottom: 20px;
    flex-basis: 33%;
    overflow: hidden;
    /* width: 33%; */
}

.container article h1 {
    text-align: center;
}

.title {
    text-align: center;
    color: #FF9F68;
}

.container article video {
    width: 100%;
    display: block;
}

.container article p {
    font-size: medium;
    background-color: #FFF6ED;
    margin: 0px;
}

.created {
    margin: 0px;
    text-align: right;
    background-color: #FFF6ED;
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