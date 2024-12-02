package com.omkar.user_api.Controller;

import com.omkar.user_api.Model.BearerToken;
import com.omkar.user_api.Model.UserLogin;
import com.omkar.user_api.Model.Users;
import com.omkar.user_api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public String register(@RequestBody Users user){
        System.out.println(user.getEmail());
        return userService.register(user);
    }
    @PostMapping("/login")
    public BearerToken login(@RequestBody UserLogin userLogin){
        return userService.verify(userLogin);
    }
    @GetMapping("/get")
    public List<Users> get(){
        return userService.get();
    }

}
