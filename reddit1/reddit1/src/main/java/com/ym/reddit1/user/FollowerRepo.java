package com.ym.reddit1.user;

import com.ym.reddit1.models.Follower;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FollowerRepo extends MongoRepository<Follower,String> {
}
