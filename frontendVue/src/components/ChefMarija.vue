<template>

    <section class="container">

        <article>
            <h1>Mamička the boss</h1>
        </article>

        <article>
            <img src="../images/Marija_chefs.png">
        </article>

        <article>
            <p>
                She is the woman with three Michelin stars. Three! Very few restaurants globally can boast about this award. She is one of the two female chefs to be awarded the maximum three stars in Croatia and Ireland’s Michelin Guide. She started her career when she was 15, and it has been forward ever since.
                <br>
                <br>
                Marija Mamić switched her career from something unrelated to the culinary world – programing to cooking. Marija is known for using rare ingredients you would never think of in making a dish. She is well known for blurring lines between sweet and savory while creating iconic dishes with creative flair.
            </p>
        </article>
    </section>
</template>
  
<style scoped>
.container {
    overflow: hidden;
    /* display: flex; */
    /* justify-content: space-between; */
    /* justify-content: center; */
    align-items: flex-start;

}

.container article {
    margin-left: 10px;
    margin-right: 10px;
    margin-bottom: 20px;
    text-align: left;
}

.container article img {
    width: 100%;
    display: block;
    margin: 5px;
    border: 2px solid black;
}

.container article h1 {
    width: 200px;
    font-size: 700;
    margin-top: 0px;
    text-align: right;
    color: #FF9F68;
}

.container article p {
    font-size: 400;
    margin-top: 0px;
    margin-left: 15px;
    margin-right: 15px;
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