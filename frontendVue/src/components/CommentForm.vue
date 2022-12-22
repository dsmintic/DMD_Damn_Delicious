<script>
export default {
    data(){
      return {
        commentText: ''
      }
    }
}
</script>

<template>

    <section class="commentContainer">
        <article>
            <h1 class="fontbold">Write new comment</h1>
            <form id="formRecipe">


                <p><label for="title"></label>
                    <textarea class="textarea" placeholder="Please enter a comment on the recipe" rows="5" v-model="commentText"></textarea>
                </p>

                <div class="container_buttons">
                    <p><input class="commentButton" type="submit" value="Add comment" @click="$emit('addComment', commentText)"></p>
                </div>

            </form>
        </article>
    </section>

</template>

<style scoped>
.commentContainer {
    overflow: hidden;
    display: flex;
    justify-content: center;

}

.commentContainer article {
    margin-left: 10px;
    margin-right: 10px;
    margin-bottom: 20px;
    background-color: #FFF6ED;
    width: 1000px;
}

.commentContainer article h1 {
    font-size: medium;
    background-color: #FFF6ED;
}

.commentContainer article p {
    font-size: medium;
}


:focus-visible {
    outline-color: #B9DEFF;
    outline-offset: 3px;
    border-color: #FFDAB9;
    border-style: solid;
}

#formRecipe input[type=text],
#formRecipe textarea {
    width: 50%;
    background-color: white;
    height: 25px;
    border: transparent;
    box-shadow: inset 2px 2px 2px grey, 0 -1px 1px white;
    vertical-align: top;
}

#formRecipe textarea {
    height: 50px;
    resize: none;
    border: 3px solid transparent;
    box-shadow: inset 2px 2px 2px grey, 0 -1px 1px white;
    background-color: white;
    width: 80%;
}


.error {
    background-color: #FDB9FF;
}

#formRecipe label {
    display: inline-block;
    width: 100px;
    text-align: right;
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

.container_buttons {
    overflow: hidden;
    display: flex;
    justify-content: center;
    padding-bottom: 10px;
    margin-bottom: 0;
}

.commentButton {
    box-shadow: 0px 10px 14px -7px #276873;
    margin-top: 5px;
    background-color: #B9DEFF;
    border-radius: 8px;
    cursor: pointer;
    color: black;
    font-size: 15px;
    font-weight: bold;
    padding: 10px 20px;
    text-decoration: none;
    border: none;
}

.commentButton:hover {
    background-color: #FFDAB9;
    color: white;
}

.commentButton:active {
    position: relative;
    top: 2px;
}
</style>