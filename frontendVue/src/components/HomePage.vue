<template>
    <section class="container">
        <article>
            <p class="fontbold">Welcome to the DMD Damn Delicius website <br>

                "I cook with wine and sometimes I even add it to the food."</p>
        </article>

        <article>
            <video class="video" width="700" controls autoplay>
                <source src="../video/home_page_video.mp4" type="video/mp4">
            </video>
        </article>
    </section>
</template>

<style scoped>
.container {
    overflow: hidden;
    display: flex;
    justify-content: center;
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