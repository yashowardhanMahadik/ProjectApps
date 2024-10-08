package com.ym.reddit2.repository;

import com.ym.reddit2.models.Post;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface PostRepository extends MongoRepository<Post,String> {

    @Query(value = "{postId:'?0'}")
    public Post getPostById(String postId);

    @Aggregation(pipeline = {
            "{ '$match': { 'byUserId' : ?0 } }",
            "{ '$sort' : {'timestamp' : -1, 'postId' : 1 } }",
            "{ '$limit' : 1 }"
    })
    public Post getUsersPost(String id);
}
