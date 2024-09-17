package com.ym.reddit1.subreddit;

import com.ym.reddit1.models.Subreddit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface SubredditRepo extends MongoRepository<Subreddit, String> {
    @Query("{name:?0}")
    public Optional<Subreddit> findByName(String name);
}
