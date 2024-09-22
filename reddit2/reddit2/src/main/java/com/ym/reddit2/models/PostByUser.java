package com.ym.reddit2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PostsUserRepo")
public class PostByUser {
    String userId;
    @Indexed(unique = true)
    String postId;
//    List<Comment> comments;
}
