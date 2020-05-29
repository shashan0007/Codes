package com.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * UserStory entity class.
 * 
 * @author Shweta
 * @version 1.0
 */

@Table("userstory")
public class UserStory {
    
    @PrimaryKey("SprintTeamId")
    private int SprintTeamId;    
    
    @Column("UserStoryName")
    private String UserStoryName;    
    
    @Column
    private int UserStoryID;    
    
    @Column("Status")
    private String Status;

    /**
     * Default constructor
     *
     */
    
	public UserStory() {
		super();
	}
	
	 /**
     * Parameterise constructor
     *
     */

	public UserStory(int sprintTeamId, String userStoryName, int userStoryID, String status) {
		super();
		SprintTeamId = sprintTeamId;
		UserStoryName = userStoryName;
		UserStoryID = userStoryID;
		Status = status;
	}

	public int getSprintTeamId() {
		return SprintTeamId;
	}

	public void setSprintTeamId(int sprintTeamId) {
		SprintTeamId = sprintTeamId;
	}

	public String getUserStoryName() {
		return UserStoryName;
	}

	public void setUserStoryName(String userStoryName) {
		UserStoryName = userStoryName;
	}

	public int getUserStoryID() {
		return UserStoryID;
	}

	public void setUserStoryID(int userStoryID) {
		UserStoryID = userStoryID;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "UserStory [SprintTeamId=" + SprintTeamId + ", UserStoryName=" + UserStoryName + ", UserStoryID="
				+ UserStoryID + ", Status=" + Status + "]";
	}
	
	
    
   
    
    
}