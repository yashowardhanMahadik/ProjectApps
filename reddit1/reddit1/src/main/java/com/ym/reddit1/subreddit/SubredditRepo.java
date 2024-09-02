package com.ym.reddit1.subreddit;

import com.ym.reddit1.models.Subreddit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SubredditRepo extends MongoRepository<Subreddit, String> {
    public Optional<Subreddit> findByName(String name);
}
