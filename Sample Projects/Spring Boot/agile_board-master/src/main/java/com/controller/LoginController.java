package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class LoginController {
    
    @Autowired
    private UserService UserService;
    
    public LoginController() {
        System.out.println("LoginController()");
    }
    
    @RequestMapping(
    	    value = "/login*", 
    	    method = RequestMethod.GET
    	    )
    	public ResponseEntity<?> process(@RequestParam("email") String email, @RequestParam("pass") String password) 
    	    throws Exception {
    	    
    	    User login_user = new User();
    	    	login_user = UserService.getUser(email);
    	    
    	    if(login_user == null){
    	    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	    }
    	    if(login_user.getemail().equals(email) && login_user.getpassword().equals(password)){
    	    	return UserService.getJSONResponse();
    	    	//return new ResponseEntity<>(HttpStatus.OK);
    	    } else {
    	    	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    	    }
   
    	}
    
    @RequestMapping(value = "/forgotPassword*", method = RequestMethod.GET)    
    public ResponseEntity<?> forgotpwd(@RequestParam("forgotemail") String email) {
        return UserService.findEmail(email);
    }
    
}