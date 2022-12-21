<template>
    <section class="container">
        <article>
            <h1 class="fontbold">Video 1</h1>
            <video controls>
                <source src="../video/color_egg.mp4" type="video/mp4">
            </video>
            <p class="textfont">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Architecto quam veniam a,
                cumque, excepturi non
                exercitationem temporibus maiores ipsam quod provident recusandae quos, eligendi ea saepe suscipit rerum
                ipsa sapiente?</p>
            <p class="created">Created by: Marija Mamić</p>
            <p class="created">Created on: 22.12.2022</p>
        </article>

        <article>
            <h1 class="fontbold">Video 2</h1>
            <video controls>
                <source src="../video/Fruit_desert.mp4" type="video/mp4">
            </video>
            <p class="textfont">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Architecto quam veniam a,
                cumque, excepturi non
                exercitationem temporibus maiores ipsam quod provident recusandae quos, eligendi ea saepe suscipit rerum
                ipsa sapiente?</p>
            <p class="created">Created by: Denis Križak</p>
            <p class="created">Created on: 14.12.2022</p>
        </article>

        <article>
            <h1 class="fontbold">Video 3</h1>
            <video controls>
                <source src="../video/tiramisu_desert.mp4" type="video/mp4">
            </video>
            <p class="textfont">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Architecto quam veniam a,
                cumque, excepturi non
                exercitationem temporibus maiores ipsam quod provident recusandae quos, eligendi ea saepe suscipit rerum
                ipsa sapiente?</p>
            <p class="created">Created by: Damir Šmintić</p>
            <p class="created">Created on: 07.12.2022</p>
        </article>
    </section>

    <section class="container">
        <article>
            <h1 class="fontbold">Video 4</h1>
            <video controls>
                <source src="../video/all_cakes.mp4" type="video/mp4">
            </video>
            <p class="textfont">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Architecto quam veniam a,
                cumque, excepturi non
                exercitationem temporibus maiores ipsam quod provident recusandae quos, eligendi ea saepe suscipit rerum
                ipsa sapiente?</p>
            <p class="created">Created by: Denis Križak</p>
            <p class="created">Created on: 01.12.2022</p>
        </article>

        <article>
            <h1 class="fontbold">Video 5</h1>
            <video controls>
                <source src="../video/egg_and_backon.mp4" type="video/mp4">
            </video>
            <p class="textfont">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Architecto quam veniam a,
                cumque, excepturi non
                exercitationem temporibus maiores ipsam quod provident recusandae quos, eligendi ea saepe suscipit rerum
                ipsa sapiente?</p>
            <p class="created">Created by: Marija Mamić</p>
            <p class="created">Created on: 22.11.2022</p>
        </article>

        <article>
            <h1 class="fontbold">Video 6</h1>
            <video controls>
                <source src="../video/all_recipes.mp4" type="video/mp4">
            </video>
            <p class="textfont">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Architecto quam veniam a,
                cumque, excepturi non
                exercitationem temporibus maiores ipsam quod provident recusandae quos, eligendi ea saepe suscipit rerum
                ipsa sapiente? aksdhfksdjfkg</p>
            <p class="created">Created by: Damir Šmintić</p>
            <p class="created">Created on: 15.11.2022</p>
        </article>
    </section>

    <section class="container">
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
    </section>
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