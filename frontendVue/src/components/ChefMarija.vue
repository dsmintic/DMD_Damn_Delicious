<template>

    <section class="container">
        <article>
            <h1>Marija Mamić</h1>
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
    overflow:hidden;
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
}

.container article {
    margin-left: 10px;
    margin-right: 10px;
    margin-bottom: 20px;
    text-align: left;
    /* overflow:hidden;
    display: block; */
}

.container article img {
    width: 100%;
    display: block;
    margin-top: 0px;
    margin-left: 10px;
    border: 2px solid #FF9F68;
}

.container article h1 {
    width: 200px;
    font-size:large;
    margin-top: 0px;
    text-align: right;
    color: #FF9F68;
}

.container article p {
    font-size: medium;
    margin-top: 0px;
    margin-left: 10px;
    margin-right: 10px;
}
</style>