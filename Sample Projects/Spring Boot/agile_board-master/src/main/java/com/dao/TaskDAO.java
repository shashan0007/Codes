package com.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.entity.User;

/**
 * DAO interface for User to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
public interface TaskDAO {
    /**
     * Used to Create the User Information
     * @param User
     * @return {@link User}
     */
    public ResponseEntity<?> createTask(int UID,String description, String status, String user);
    public ResponseEntity<?> updateTask(int UID,int TID,String description,String status,String user);
    public ResponseEntity<?> deleteTask(int UID,int TID);
}