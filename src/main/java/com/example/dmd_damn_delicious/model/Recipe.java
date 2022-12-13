package com.example.dmd_damn_delicious.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
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
    @Column (name = "titles")
    @NotNull
    @Size(min = 3, max = 100, message = "Title should be between 3 and 100.")
    private String title;

    @NotEmpty (message = "Summary can't be empty.")
    @Column  (name = "summaries")
    @NotNull
    private String summary;

    @NotEmpty (message = "Content can't be empty.")
    @Column  (name = "contents")
    @NotNull
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP) // pitati Denisa za update
    @CreationTimestamp
    @Column
    private Date updateDate;

    @OneToMany(mappedBy = "recipes", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)//provjeriti da li je množina
    private Collection<Comment> comments;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "ratings", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)//provjeriti da li je množina
    private Collection<Rating> ratings;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "ingredients")
    @JsonIgnore
    private Set<Ingredient> ingredients = new HashSet<>();

    public Recipe() {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Collection <Comment> getComments () {
        return comments;
    }

    public void setComments (Collection <Comment> comments) {
        this.comments = comments;
    }

    //public void setUser(org.springframework.security.core.userdetails.User user) {
    //} pitati Denisa

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
