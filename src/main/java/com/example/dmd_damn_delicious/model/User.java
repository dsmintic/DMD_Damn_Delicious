package com.example.dmd_damn_delicious.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "Username cannot be empty")
    @Column(name = "username")
    @NotNull
    @Length(min = 3, max = 20, message = "Must be between 3 and 20 characters long")
    private String username;

    @NotEmpty(message = "Password cannot be empty")
    @Column(name = "password")
    @NotNull
    @Length(min = 8, message = "Password must be atleast 8 characters long")
    private String password;

    @Column(name= "role", nullable = false)
    private boolean role;


    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Comment> comments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Recipe> recipes = new LinkedHashSet<>();

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    //Što s Authority?
//    @OneToOne()
//    @JoinColumn(name = "authority_id", nullable = false)
//    private Authority authority;
//
//    public Authority getAuthority() {
//        return authority;
//    }
//
//    public void setAuthority(Authority authority) {
//        this.authority = authority;
//    }
    public User() {
    }

    public User(String username, String password, boolean role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(getAuthority());
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", comments=" + comments +
                ", recipes=" + recipes +
                '}';
    }
}

