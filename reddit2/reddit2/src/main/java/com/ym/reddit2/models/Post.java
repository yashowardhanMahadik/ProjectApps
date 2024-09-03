package com.ym.reddit2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PostsRepo")
public class Post {

    String postId;
    String subredditName;
    String text;
//    List<String> comments;
}
