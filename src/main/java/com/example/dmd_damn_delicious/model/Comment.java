package com.example.dmd_damn_delicious.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "Text cannot be empty")
    @Column(name = "text")
    @NotNull
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column (name = "update_date", updatable = true)
    private LocalDateTime updateDate;

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Comment() {
    }

    public Comment(String text, User user, Recipe recipe) {
        this.text = text;
        this.user = user;
        this.recipe = recipe;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }


    //    @Override
//    public String toString() {
//        return "Comment{" +
//                "id=" + id +
//                ", comment_text='" + text + '\'' +
//                ", creationDate=" + creationDate +
//                ", post_id=" + recipe.getId() + // can't go for post object itself as it will make a recursion and overflow a stack
//                ", username=" + user.getUsername() +
//                '}';
//    }


    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", user=" + user +
                ", recipeId=" + recipe.getId() +
                '}';
    }
}
