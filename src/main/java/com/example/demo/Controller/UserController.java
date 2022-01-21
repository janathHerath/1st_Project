package com.example.demo.Controller;


import com.example.demo.UserNotFoundException;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired //connecting service
    private UserService userService;



    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAllusers();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {

//        return UserService.findUser(id);
//    }

        User user = userService.findUser(id);
        if (user == null) {
            throw new UserNotFoundException("not found" + id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
         User saveUser=userService.addUser(user);
        URI newUserLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(saveUser.getId())
                .toUri();
        return ResponseEntity.created(newUserLocation).build();
    }


    @RequestMapping(method=RequestMethod.PUT, value= "/users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable String id){

        userService.updateUser(user.getId());
    }
}
