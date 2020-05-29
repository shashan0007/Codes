package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.TaskService;

/**
 * @author Shweta
 * @version 1.0
 */
@RestController
public class TaskController {
    
    @Autowired
    private TaskService TaskService;
    
    public TaskController() {
        System.out.println("TaskController()");
    }
         
    @RequestMapping(value = "/create/task", method = RequestMethod.POST)    
    public ResponseEntity<?> create(@RequestParam("userstoryid") int UID,@RequestParam("description") String description,@RequestParam("status") String status,@RequestParam("username") String user) {        
        return TaskService.createTask(UID,description,status,user);
    }
    
    @RequestMapping(value = "/delete/task", method = RequestMethod.DELETE)    
    public ResponseEntity<?> delete(@RequestParam("userstoryid") int UID,@RequestParam("taskid") int TID) {        
        return TaskService.deleteTask(UID,TID);
    }
    
    @RequestMapping(value = "/update/task", method = RequestMethod.PUT)    
    public ResponseEntity<?> modify(@RequestParam("userstoryid") int UID,@RequestParam("taskid") int TID,@RequestParam("description") String description,@RequestParam("status") String status,@RequestParam("username") String user) {        
        return TaskService.updateTask(UID,TID,description,status,user);
    }
    
}