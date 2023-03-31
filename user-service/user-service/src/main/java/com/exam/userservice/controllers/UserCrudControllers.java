package com.exam.userservice.controllers;

import com.exam.userservice.entity.AppUser;
import com.exam.userservice.exceptions.ResourceNotFoundException;
import com.exam.userservice.repository.AppUserRepository;
import com.exam.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/userCruds")
public class UserCrudControllers {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private UserService userService;


    //create
    @PostMapping("/user")
    public AppUser createUser(@RequestBody AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    //read
    @GetMapping("/user")
    public Iterable< AppUser > getAllUsers() {
        return appUserRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity < AppUser > getUsersById(@PathVariable(value = "id") Integer userId) throws ResourceNotFoundException {
        return userService.getUserById(userId);
    }

    //update
    @PutMapping("/user/{id}")
    public ResponseEntity < AppUser > updateUsers(@PathVariable(value = "id") Integer userId,
                                                      @RequestBody AppUser appUserDetail) throws ResourceNotFoundException {
        return userService.updateUsers(userId, appUserDetail);
    }

    //delete
    @DeleteMapping("/user/{id}")
    public Map< String, Boolean > deleteUsers(@PathVariable(value = "id") Integer userId)
            throws ResourceNotFoundException {
        return userService.deleteUser(userId);

    }

    //checked
    @GetMapping("/todos/check/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isChecked(@PathVariable("id") int id) throws ResourceNotFoundException {
        return userService.isChecked(id);
    }


}
