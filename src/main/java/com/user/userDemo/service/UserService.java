package com.user.userDemo.service;

import com.user.userDemo.Model.User;
import com.user.userDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired// field injection
    private UserRepository userRepository;


    public List<User> getAllUsers(){

        return userRepository.findAll();
    }

    public User getUserById(int id){

        return userRepository.findById(id).get();
    }

    public  User addUser(User user){
        return userRepository.save(user);
    }

    public User putUser(User user, int id) throws IllegalAccessException {
        User modifiedUser;
        Optional<User> userToModify=userRepository.findById(id);
        if(userToModify.isPresent()){
           User userFound = userToModify.get();
            // Check for null values before updating
            if (user.getName() != null) {
                userFound.setName(user.getName());
            }

            if (user.getAge()!=0 && user.getAge()>200) {
                userFound.setAge(user.getAge());
            }

           modifiedUser= userRepository.save(userFound);
        }
        else{
            throw new IllegalAccessException("User Not found");
        }

        return modifiedUser;
    }

}
