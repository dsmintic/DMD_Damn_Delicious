<template>
    <section class="container">
        <article>
            <h1 class="fontbold"><router-link :to="{ name: 'Video' }">Find your recipe in this video</router-link></h1>

            <div>
            <video  width="400" controls >
                <source src="../video/coloreggs.mp4" type="video/mp4">
            </video></div>
            <div>
            <video  width="400" controls >
                <source src="../video/eggvideo.mp4" type="video/mp4">
            </video></div>
            <div>
            <video width="400" controls >
                <source src="../video/allRecipes.mp4" type="video/mp4">
            </video></div>

            <p class="textfont">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Architecto quam veniam a,
                cumque, excepturi non
                exercitationem temporibus maiores ipsam quod provident recusandae quos, eligendi ea saepe suscipit rerum
                ipsa sapiente?</p>
        </article>
    </section>
</template>