//package com.ym.likeApp.models;
//
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.stereotype.Component;
//
//@Component
//@Document
//public enum Vote {
//    UPVOTE("upvote"),
//    DOWNVOTE("downvote");
//
//    private final String value;
//
//    Vote(String value) {
//        this.value = value;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public static Vote fromString(String text) {
//        for (Vote Vote : Vote.values()) {
//            if (Vote.value.equalsIgnoreCase(text)) {
//                return Vote;
//            }
//        }
//        throw new IllegalArgumentException("Unknown Vote: " + text);
//    }
//}
