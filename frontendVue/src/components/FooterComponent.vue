<script>
export default {

}
</script>

<template>
    <section class="container">
        <article>
            <img src="../images/dmd_logo.png" class="logoimage">
        </article>
    </section>

    

    <article class="socialmedia">
        <a href="https://hr-hr.facebook.com/" target="_blank"><font-awesome-icon class="icons" icon="fa-brands fa-facebook" /></a>
        <a href="https://www.instagram.com/" target="_blank"><font-awesome-icon class="icons" icon="fa-brands fa-instagram" /></a>
        <a href="https://www.tiktok.com/en/" target="_blank"><font-awesome-icon class="icons" icon="fa-brands fa-tiktok" /></a>
    </article>

    <article class="socialmedia">
        <p class="textfont">CONTACT US</p>
    </article>

    <section>
        <article class="contact">
            <a href="https://goo.gl/maps/n8Zdw96JXNoWgLEf6" target="_blank"><font-awesome-icon class="icons" icon="fa-solid fa-map-location-dot" /></a>
            <p class="para">Trg bana Josipa Jelačića 1, 10000, Zagreb</p>
        </article>

        <article class="contact">
            <font-awesome-icon class="icons" icon="fa-solid fa-phone" />
            <p class="para">+385 93 9230 111</p>
        </article>
            
        <article class="contact">
            <a href="mailto:dmd@dmd.hr"><font-awesome-icon class="icons" icon="fa-regular fa-envelope" /></a>
            <p class="para">dmd@dmd.hr</p>
        </article>
           
        
    </section>

    <article class="socialmedia">
        <small class="para">Copyright © 2022 DMD, Inc. or its subsidiaries and affiliates. All rights reserved.</small>
    </article>
    

</template>

<style scoped>
.container {
    overflow: hidden;
    display: flex;
    justify-content: center;
    margin-top: 20px;
    border-top: 2px solid peachpuff;
}

.container article {
    margin-top: 20px;
    margin-left: 10px;
    margin-right: 10px;
    margin-bottom: 20px;
}

.para {
    margin-left: 10px;
    color: #FF9F68;
}

.socialmedia {
    display: flex;
    justify-content: center;
    margin-bottom: 10px;
}

.contact {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-bottom: 10px;
}

.socialmedia a {
    color: inherit
}

.socialmedia a:visited{
    color: inherit
}

.icons{
    margin-right: 10px;
    margin-left: 10px;
    font-size: 30px;
    color: #B9DEFF;
}

.textfont {
  font-weight: 700;
  padding: 10px;
  margin-top: 30px;
  margin-bottom: 0px;
  color: #FF9F68;
}
</style>