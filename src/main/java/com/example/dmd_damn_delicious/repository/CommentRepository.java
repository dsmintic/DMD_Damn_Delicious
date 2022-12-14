package com.example.dmd_damn_delicious.repository;

import com.example.dmd_damn_delicious.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Collection<Comment> findAllByOrderByCreationDateDesc();

    Collection<Comment> findAllByOrderByCreationDateAsc();

    List<Comment> findAllByRecipeId(long id);

    List<Comment> findAllByUserId(long userId);

    Optional<Comment> findById(long id);
}
