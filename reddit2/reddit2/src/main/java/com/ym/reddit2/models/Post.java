package com.ym.reddit2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PostsRepo")
public class Post {
    @Indexed(unique = true)
    String postId;
    String byUserId;
    String subredditName;
    String text;
//    List<Comment> comments;
}
