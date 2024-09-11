package com.ym.likeApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeEvent implements Serializable {
    public long postId;
    public long userId;
    public Instant timestamp;
}
