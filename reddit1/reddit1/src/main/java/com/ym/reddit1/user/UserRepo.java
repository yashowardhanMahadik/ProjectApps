package com.ym.reddit1.user;

import com.ym.reddit1.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepo extends MongoRepository<User,String> {

    @Query("{id:?0}")
    public User findByUserId(int id);
}
