package com.example.dmd_damn_delicious.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

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

    @Column(name= "is_admin", nullable = false)
    private boolean isAdmin;

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

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}

