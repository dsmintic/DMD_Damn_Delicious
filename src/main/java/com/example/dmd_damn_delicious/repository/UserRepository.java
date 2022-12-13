package com.example.dmd_damn_delicious.repository;

import com.example.dmd_damn_delicious.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {

        List<User> findByUsernameContaining (String username);
    }
