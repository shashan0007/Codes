package com.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * Employee entity class.
 * 
 * @author Shweta
 * @version 1.0
 */
@Table("Task")
public class Task {
    
    @PrimaryKey("taskid")
    private int taskId;    
    
    @Column("userstoryid")
    private int userStoryId;
    
    @Column("status")
    private String status;
    
    @Column("taskname")
    private String taskName;
    
    @Column("username")
    private String userName;
    
    /**
     * Default Constructor
     */
	public Task() {
		super();
	}

	/**
     * Parameterized Constructor
     * @param SprintTeamId
     * @param sprintTeamName
     * 
     */
	
	public Task(int taskid, int USID, String status,String taskname, String username) {
		super();
		this.taskId = taskid;
		this.userStoryId = USID;
		this.status = status;
		this.taskName = taskname;
		this.userName = username;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskid) {
		taskId = taskid;
	}

	public int getUserStoryId() {
		return userStoryId;
	}

	public void setUserStoryId(int USID) {
		this.userStoryId = USID;
	}
	
	public String getTaskStatus()
	{
		return status;
	}
	
	public void setTaskStatus(String status)
	{
		this.status = status;
	}
	
	public String getTaskName()
	{
		return taskName;
	}
	
	public void setTaskname(String taskname)
	{
		this.taskName = taskname;
	}
	
	public String getTaskUser()
	{
		return userName;
	}
	
	public void setTaskUser(String username)
	{
		this.userName = username;
	}
	
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", userStoryID =" + userStoryId + ", status=" + status + ", description =" + taskName + ",user =" + userName + "]";
	}    
    
	
	 
	
	
	
	
}