package com.ym.reddit2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CommentsRepo")
@AllArgsConstructor
@Data
@NoArgsConstructor
@CompoundIndex(name = "hoho",def = "{'userId': 1, 'postId': 1}",unique = true)
public class Comment {
    @Id
    String comment_id;
    String userId;
    String postId;
    String text;
}
