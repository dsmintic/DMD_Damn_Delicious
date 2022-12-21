<template>

    <section class="container">

        <article>
            <h1>Denis Križak</h1>
        </article>

        <article>
            <img src="../images/Denis_chefs.png">
        </article>

        <article>
            <p>
                Internationally renowned, multi-Michelin starred chef Denis Križak has opened a string of successful
                restaurants across the globe, from the Croatia and France to Singapore and the United States. Denis has
                also become a star of the small screen both in the Croatia and internationally, with shows such as Krim
                team, DMD Damn Delicious and many more.
                <br>
                <br>
                Croatian by birth, chef Denis Križak was brought up in Stratford-upon-Avon, England, and
                initially aspired to be a professional footballer. However, when an injury prematurely put an end to any
                hopes of a promising career on the pitch, Denis went back to college to complete a course in hotel
                management.
                <br>
                <br>
                In spare time he learn Indian lenguage. 😊
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