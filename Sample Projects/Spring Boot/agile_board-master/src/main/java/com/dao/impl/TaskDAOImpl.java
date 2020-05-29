package com.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.dao.TaskDAO;
import com.entity.Task;
import com.util.MyCassandraTemplate;

/**
 * DAOImpl class for User to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
@Repository
public class TaskDAOImpl implements TaskDAO {
	
	private static int taskId = 0;
    
    @Autowired
    private MyCassandraTemplate myCassandraTemplate;
    
    @Override
    public ResponseEntity<?> createTask(int UID, String description, String status, String user) {
    	taskId++;
        return myCassandraTemplate.createTask(taskId,UID,description,status,user);
    }
    
    @Override
    public ResponseEntity<?> updateTask(int UID,int TID,String description,String status,String user){
    	Task updatetask = new Task();
    	updatetask.setUserStoryId(UID);
    	updatetask.setTaskId(TID);
    	updatetask.setTaskname(description);
    	updatetask.setTaskStatus(status);
    	updatetask.setTaskUser(user);
    	return myCassandraTemplate.updateTask(updatetask);
    }
    
    @Override
    public ResponseEntity<?> deleteTask(int UID,int TID){
    	return myCassandraTemplate.deleteTask(UID,TID);
    	
    }
}