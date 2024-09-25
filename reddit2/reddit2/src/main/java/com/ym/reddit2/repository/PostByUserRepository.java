package com.ym.reddit2.repository;

import com.ym.reddit2.models.PostByUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface PostByUserRepository extends MongoRepository<PostByUser,String> {

    @Query(value="{userId: '?0' , postId: '?1'}", delete = true)
    public void deleteByUserIdPostId(String userId,String postId);

}
