package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.dao.TaskDAO;
import com.service.TaskService;

/**
 * Service Impl class for User to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired  
    private TaskDAO TaskDAO;

    /**
     * Default Constructor
     */
    public TaskServiceImpl() {
        super();    
    }

    @Override   
    public ResponseEntity<?> createTask(int UID,String description, String status, String user) {     
        return TaskDAO.createTask(UID,description,status,user);
    }
    
    public ResponseEntity<?> updateTask(int UID,int TID,String description,String status,String user)
    {
    	return TaskDAO.updateTask(UID,TID,description,status,user);
    }
    public ResponseEntity<?> deleteTask(int UID,int TID){
    	return TaskDAO.deleteTask(UID,TID);
    }

}