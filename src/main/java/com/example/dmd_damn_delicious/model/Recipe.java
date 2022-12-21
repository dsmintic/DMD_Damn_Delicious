package com.example.dmd_damn_delicious.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name= "id", nullable = false)
    private Long id;


    @NotEmpty(message = "Title can't be empty.")
    @Column (name = "title")
    @NotNull
    @Size(min = 3, max = 100, message = "Title should be between 3 and 100.")
    private String title;

    @NotEmpty (message = "Summary can't be empty.")
    @Column  (name = "summary", columnDefinition = "TEXT")
    @NotNull
    private String summary;

    @NotEmpty (message = "Content can't be empty.")
    @Column  (name = "content", columnDefinition = "TEXT")
    @NotNull
    private String content;

    @NotEmpty (message = "Content can't be empty.")
    @Column  (name = "image_path")
    @NotNull
    private String imagePath;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column
    private LocalDateTime creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column (name = "update_date", updatable = true)
    private LocalDateTime updateDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //@JsonIgnore
    private Set<Ingredient> ingredients = new HashSet<>();

    public Recipe() {
    }

    public Recipe(String title, String summary, String content, String imagePath, User user, Set<Ingredient> ingredients) {
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.imagePath = imagePath;
        this.user = user;
        this.ingredients = ingredients;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", user=" + user +
                ", ingredients=" + ingredients +
                '}';
    }
}
