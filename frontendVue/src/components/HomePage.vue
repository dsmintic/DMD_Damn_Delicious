<template>
    <section class="container">

        <article>
            <p class="fontbold">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Architecto quam veniam a,
                cumque, excepturi non
                exercitationem temporibus maiores ipsam quod provident recusandae quos, eligendi ea saepe suscipit rerum
                ipsa sapiente?</p>
        </article>

        <article>
            <!--<h1 class="fontbold">Recipes</h1>
            <img src="../images/world-chefs.webp">-->

            <video class="video" width="700" controls autoplay>
                <source src="../video/homepagevideo.mp4" type="video/mp4">

            </video>
        </article>


    </section>
</template>

<style scoped>
.container {
    overflow: hidden;
    display: flex;
    justify-content:center;
    /* align-items: flex-start; */
    background-color: #FFF6ED;
}

.container article {
    margin-left: 10px;
    margin-right: 10px;
    margin-bottom: 20px;
    flex-basis: 33%;
}

.container article img {
    width: 100%;
    display: block;
}

.container article p {
    font-size: medium;
    align-items: center;
}


.fontbold {
    text-align: left;
    padding: 20px;
    font-weight: 700;
    margin: 0;
}

.textfont {
    font-weight: 100;
    padding: 10px;
    margin: 0;
}

.video {
    margin: 20px;
    padding: 20px;

}
</style>