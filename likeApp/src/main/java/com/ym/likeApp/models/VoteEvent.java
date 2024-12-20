package com.ym.likeApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class VoteEvent {
    public long postId;
    public long userId;
    public String type;
    public Instant timestamp;
}
