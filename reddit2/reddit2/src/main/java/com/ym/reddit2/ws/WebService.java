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
    public String SUBREDDIT_CHECK_URL = wsRed1Url +"/sub/yycheck";
    public  String USER_CHECK_URL = wsRed1Url+"/user/getUser";
    public String FOLLOWING_LIST_URL = wsRed1Url+"/user/follow/get";

    private final RestTemplate restTemplate;

    @Autowired
    public WebService(RestTemplate restTemplate, @Value("${app.red1.url}") String wsRed1Url){
        this.wsRed1Url = wsRed1Url;
        System.out.println("From constructor pront : "+wsRed1Url);
        this.restTemplate = restTemplate;
    }
    public boolean checkSubredditExist(String name){
        String url = SUBREDDIT_CHECK_URL+"/"+name;
        System.out.println(url+"urlzzz z ");
        try {
            return restTemplate.getForObject(url, Boolean.class);
        }
        catch(Exception e){
            throw new WSException(e.getMessage());
        }

    }

    public boolean checkUserExist(int id){
        String url = USER_CHECK_URL+"/"+id;
        System.out.println(" 11 "+this.wsRed1Url);
        System.out.println(" 22wsRed1Url  "+wsRed1Url);
        System.out.println();
        System.out.println(url+"urlzzz z 2");
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
        String url = FOLLOWING_LIST_URL+"/"+userId;
        System.out.println(url+"urlzzz z 3");
        try {
            String[] strings = restTemplate.getForObject(url, String[].class);
            return Arrays.asList(strings);
        }
        catch(Exception e){
            throw new WSException(e.getMessage());
        }

    }
}
