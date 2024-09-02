package com.ym.reddit1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Subreddit {
    @Id
    String id;
    String name;

    public Subreddit(String name){
        this.name = name;
    }
}
