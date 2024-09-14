package com.ym.reddit2.repository;

import com.ym.reddit2.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentRepo extends MongoRepository<Comment,String > {
    @Query(value = "{postId:'?0'}")
    List<Comment> findAll(String postId);
}
