package com.ym.reddit1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserRepo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    int id;
    String name;
    @Indexed(unique = true)
    String email;

}
