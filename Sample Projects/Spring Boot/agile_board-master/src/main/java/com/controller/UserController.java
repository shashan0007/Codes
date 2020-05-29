package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

/**
 * @author Shweta
 * @version 1.0
 */
@RestController
public class UserController {
    
    @Autowired
    private UserService UserService;
    
    public UserController() {
        System.out.println("UserController()");
    }
         
    @RequestMapping(value = "/register*", method = RequestMethod.POST)     
    public ResponseEntity<?> registeruser(@RequestParam("firstname") String firstname,@RequestParam("email") String email, @RequestParam("password") String password,@RequestParam("confirmpassword") String confirmpassword,@RequestParam("phone") String phone,@RequestParam("lastname") String lastname) {
        return UserService.registeruser(firstname,lastname,email,password,phone,confirmpassword);
    }
 
    @RequestMapping(value = "/reset*", method = RequestMethod.PUT)
    public ResponseEntity<?> changepassword(@RequestParam("email") String email,@RequestParam("pass") String password) {        
        return UserService.changepassword(email,password);
    }
 
    @RequestMapping(value = "/User", method = RequestMethod.PUT)
    User update(@RequestBody User User) {
        return UserService.updateUser(User);
    }
}