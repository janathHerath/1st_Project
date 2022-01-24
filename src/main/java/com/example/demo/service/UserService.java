package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {
    private static List<User> users=new ArrayList<>();
    private static  int  userCount=2;

    static {
        users.add(new User(1,"jana",1997));
        users.add(new User(2,"jasa",1930));
        users.add(new User(3,"hasalanka",1948));
    }
    public List<User> findAllusers(){
gi
        return users;
    }
    public User addUser(User user) {
        if (user.getId() == null) {
            user.setId(userCount++);
        } else {
            users.add(user);
            return user;
        }
     return null;
    }
    public static User findUser(int id){
        for (User user:users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public static User updateUser(int id){
        for (User user:users){
            if(user.getId()==id){
                users.set(id, user);
                return user;
            }
        }
        return null;
    }

//    public  List<User> printUsers() {
//
//        return users;
//    }
}





