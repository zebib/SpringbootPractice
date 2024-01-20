package com.user.userDemo.controller;

import com.user.userDemo.Model.User;
import com.user.userDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired// constructor injection
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User userid=userService.getUserById(id);
        return ResponseEntity.ok(userid);
    }
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        User userVar=userService.addUser(user);
        return ResponseEntity.ok(userVar);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> listOfUsers=userService.getAllUsers();

        return ResponseEntity.ok(listOfUsers);
    }
    @PutMapping(value="/{id}")
    public ResponseEntity<User> modifyUser(@RequestBody User user,@PathVariable int id) throws IllegalAccessException {
        User modifiedUser=userService.putUser(user,id);
        return ResponseEntity.ok(modifiedUser);
    }
}
