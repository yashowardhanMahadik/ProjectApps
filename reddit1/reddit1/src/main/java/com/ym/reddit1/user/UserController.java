package com.ym.reddit1.user;

import com.ym.reddit1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/red1/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created");
    }


    @GetMapping("/getAll")
    public ResponseEntity<?> getUsers(@RequestParam Optional<Integer> pageNumber,@RequestParam Optional<Integer> pageSize){
        if(pageNumber.isPresent() && pageSize.isPresent()){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.getAllUsers(pageNumber.get(),pageSize.get()));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.getAllUsers(0,10));
    }

    @GetMapping("/getAll2")
    public ResponseEntity<?> getUsers2(@RequestParam(required = true,defaultValue = "0") Integer pageNumber,
                                       @RequestParam(required = true,defaultValue = "10") Integer pageSize){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.getAllUsers(pageNumber,pageSize));
    }

    @GetMapping("/getUser/{id}")
    @ResponseBody
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping("/follow/{followerId}")
    @ResponseBody
    public boolean followUser(@PathVariable String followerId, @RequestBody String userId){
        if (checkUsersExist(followerId, userId)) return false;
        userService.followUser(userId,followerId);
        return true;
    }

    //todo: add new endpoint which returns the list of user subscribed accounts

    @GetMapping("follow/get/{followerId}")
    public List<String> getFollowingUsers(@PathVariable String followerId){
        System.out.println("followerId is : "+followerId);
        return userService.getFollowingUser(followerId);
    }
    //hgit

    private boolean checkUsersExist(String followerId, String userId) {
        User userById = userService.getUserById(Integer.parseInt(followerId));
        System.out.println("User is : "+userById);
        User follower = userService.getUserById(Integer.parseInt(userId));
        System.out.println("Follower is : "+follower);

        if(userById == null || follower == null)
            return true;
        return false;
    }


}
