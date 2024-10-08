package com.ym.reddit2.ws;

import com.ym.reddit2.Exception.WSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebService {
    @Value("${app.red1.url}")
    private String wsRed1Url;
    public static final String SUBREDDIT_CHECK_URL ="/sub/check";
    public static final  String USER_CHECK_URL = "/user/getUser";
    public static final String FOLLOWING_LIST_URL ="/user/follow/get";

    private final RestTemplate restTemplate;

    @Autowired
    public WebService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public boolean checkSubredditExist(String name){
        String url = wsRed1Url + SUBREDDIT_CHECK_URL+"/"+name;
        System.out.println(url+"  urlzzz z ");
        try {
            return restTemplate.getForObject(url, Boolean.class);
        }
        catch(Exception e){
            throw new WSException(e.getMessage());
        }

    }

    public boolean checkUserExist(int id){
        String url = wsRed1Url + USER_CHECK_URL+"/"+id;
        System.out.println(url+"  urlzzz z 2");
        try{
            Object ob =  restTemplate.getForObject(url, Object.class);
            return ob!=null;
        }
        catch(Exception e){
            throw new WSException(e.getMessage()+" WS EXCEPTION : "
                    + Arrays.stream(e.getStackTrace()).map(StackTraceElement::toString).collect(Collectors.toList()));
        }
    }

    public List<String> getFollowingList(String userId){
        String url = wsRed1Url + FOLLOWING_LIST_URL+"/"+userId;
        System.out.println(url+"  urlzzz z 3");
        try {
            String[] strings = restTemplate.getForObject(url, String[].class);
            return Arrays.asList(strings);
        }
        catch(Exception e){
            throw new WSException(e.getMessage());
        }

    }
}
