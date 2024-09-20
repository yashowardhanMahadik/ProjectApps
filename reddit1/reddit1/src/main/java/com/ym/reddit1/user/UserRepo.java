package com.ym.reddit1.user;

import com.ym.reddit1.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {
}
