<template>

    <section class="container">

        <article>
            <h1>Damir Šmintić</h1>
        </article>

        <article>
            <img src="../images/Damir_chefs.png.jpg">
        </article>

        <article>
            <p>
                Damir Šmintić (born 23.12.1985) is an Craotian sensation , teacher and cookbook author. He is known for his casual approach to cuisine, which has led him to front numerous television shows and open many restaurants.
                <br>
                <br>
                Damir reached the public eye when his series The Naked Chef premiered, he opened a campaign, Feed Me Better, to introduce schoolchildren to healthier foods, which was later backed by the government. He was the owner of a restaurant chain, Damir Šmintić Restaurant Group, which opened its first restaurant, DamirThe Naked Chef, in Oxford in 2015. 
            </p>
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
    text-align: left;
}

.container article img {
    width: 100%;
    display: block;
    margin: 5px;
    border: 2px solid #FF9F68;
}

.container article h1 {
    width: 200px;
    font-size: 700;
    margin-top: 0px;
    text-align: right;
    color: #FF9F68;
}

.container article p {
    font-size: medium;
    margin-top: 0px;
    margin-left: 15px;
    margin-right: 15px;
}
</style>