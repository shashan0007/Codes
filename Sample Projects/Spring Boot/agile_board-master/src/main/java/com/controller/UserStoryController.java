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

import com.entity.UserStory;
import com.service.UserStoryService;

/**
 * @author Shweta
 * @version 1.0
 */
@RestController
public class UserStoryController {
    
    @Autowired
    private UserStoryService userStoryService;
    
    public UserStoryController() {
        System.out.println("UserStoryService()");
    }
         
    @RequestMapping(value = "/create/userstory", method = RequestMethod.POST)    
    public ResponseEntity<?> create(@RequestParam("sprintteamid") int sprintteamid,@RequestParam("userstoryname") String description) {        
        return userStoryService.createUserStory(sprintteamid,description);
    }
    
    @RequestMapping(value = "/delete/userstory", method = RequestMethod.DELETE)    
    public ResponseEntity<?> delete(@RequestParam("userstoryid") int userstoryid) {        
        return userStoryService.deleteUserStory(userstoryid);
    }
    
    @RequestMapping(value = "/update/userstory", method = RequestMethod.PUT)    
    public ResponseEntity<?> update(@RequestParam("userstoryid") int userstoryid,@RequestParam("sprintteamid") int sprintteamid,@RequestParam("userstoryname") String description,@RequestParam("status") String status) {        
        return userStoryService.updateUserStory(userstoryid,sprintteamid,description,status);
    }
}