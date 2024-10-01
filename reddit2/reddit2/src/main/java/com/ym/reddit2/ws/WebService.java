package com.ym.reddit2.ws;

import com.ym.reddit2.Exception.WSException;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebService {
    public final static String SUBREDDIT_CHECK_URL = "http://localhost:8881/red1/sub/check";
    public final static String USER_CHECK_URL = "http://localhost:8881/red1/user/getUser";
    public final static String FOLLOWING_LIST_URL = "http://localhost:8881/red1/user/follow/get";

    private final RestTemplate restTemplate;

    public WebService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public boolean checkSubredditExist(String name){
        String url = SUBREDDIT_CHECK_URL+"/"+name;
        try {
            return restTemplate.getForObject(url, Boolean.class);
        }
        catch(Exception e){
            throw new WSException(e.getMessage());
        }

    }

    public boolean checkUserExist(int id){
        String url = USER_CHECK_URL+"/"+id;
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
        try {
            String[] strings = restTemplate.getForObject(url, String[].class);
            return Arrays.asList(strings);
        }
        catch(Exception e){
            throw new WSException(e.getMessage());
        }

    }
}
