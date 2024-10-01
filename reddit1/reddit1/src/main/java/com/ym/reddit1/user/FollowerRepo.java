package com.ym.reddit1.user;

import com.ym.reddit1.models.Follower;
import com.ym.reddit1.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FollowerRepo extends MongoRepository<Follower,String> {

    @Query(value="{followerId:'?0'}")
    public List<Follower> getFollowingUserList(String userId);
}
