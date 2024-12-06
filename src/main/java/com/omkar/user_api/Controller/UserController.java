package com.omkar.user_api.Controller;

import com.omkar.user_api.Model.BearerToken;
import com.omkar.user_api.Model.UserLogin;
import com.omkar.user_api.Model.Users;
import com.omkar.user_api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"https://omkartrendz.ccbp.tech/","https://omkarsfasion.ccbp.tech/", "https://omkarp7hy1rjscpfoqqb.drops.nxtwave.tech/"})
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
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<?> delete(@PathVariable("email") String email){
         userService.delete(email);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User Successfully Deleted");
    }

}
