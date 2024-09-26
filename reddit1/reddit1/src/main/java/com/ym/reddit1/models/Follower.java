package com.ym.reddit1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Followers")
@CompoundIndex(name = "hoho2",def = "{'userId': 1, 'followerId': 1}",unique = true)
public class Follower {
    @Id
    String id;
    String userId;
    String followerId;
}
