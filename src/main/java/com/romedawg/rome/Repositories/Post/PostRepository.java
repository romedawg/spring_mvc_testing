package com.romedawg.rome.Repositories.Post;

import com.romedawg.rome.Domain.Post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
