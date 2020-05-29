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
@Table("sprintteam")
public class SprintTeam {
    
    @PrimaryKey("sprintteamid")
    private int sprintTeamId;    
    
    @Column("teamName")
    private String teamName;
    
    @Column("sprintname")
    private String sprintName;

    /**
     * Default Constructor
     */
	public SprintTeam() {
		super();
	}

	/**
     * Parameterized Constructor
     * @param SprintTeamId
     * @param sprintTeamName
     * 
     */
	
	public SprintTeam(int sprintTeamId, String TeamName, String sprintname) {
		super();
		this.sprintTeamId = sprintTeamId;
		this.sprintName = sprintname;
		this.teamName = TeamName;
	}

	public int getSprintTeamId() {
		return sprintTeamId;
	}

	public void setSprintTeamId(int sprintteamid) {
		sprintTeamId = sprintteamid;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}
	
	public String getTeamName()
	{
		return teamName;
	}
	
	public void setTeamName(String TeamName)
	{
		this.teamName = TeamName;
	}

	@Override
	public String toString() {
		return "SprintTeam [SprintTeamId=" + sprintTeamId + ", sprintName=" + sprintName + ", TeamName=" + teamName + "]";
	}    
    
	
	 
	
	
	
	
}