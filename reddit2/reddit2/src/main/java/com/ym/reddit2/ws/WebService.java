package com.ym.reddit2.ws;

import com.ym.reddit2.Exception.ErrorResponse;
import com.ym.reddit2.Exception.SubredditNotFoundException;
import com.ym.reddit2.Exception.WSException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebService {
    public final static String SUBREDDIT_CHECK_URL = "localhost:8881/sub/check";

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
}
