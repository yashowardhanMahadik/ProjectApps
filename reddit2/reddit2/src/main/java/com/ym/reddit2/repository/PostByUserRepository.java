package com.ym.reddit2.repository;

import com.ym.reddit2.models.PostByUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface PostByUserRepository extends MongoRepository<PostByUser,String> {

}
