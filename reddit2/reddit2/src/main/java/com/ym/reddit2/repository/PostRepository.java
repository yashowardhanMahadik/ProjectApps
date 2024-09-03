package com.ym.reddit2.repository;

import com.ym.reddit2.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface PostRepository extends MongoRepository<Post,String> {
}
