package com.entity;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * Employee entity class.
 * 
 * @author Shweta
 * @version 1.0
 */
@Table("team")
public class TeamName {
    
    @PrimaryKey("teamname")
    private String teamname; 
    
    /**
     * Default Constructor
     */
    public TeamName() {
        super();        
    }

    /**
     * Parameterized Constructor
     * @param id
     * @param name
     * @param age
     * @param salary
     */
    public TeamName(String teamname) {
        super();
        this.teamname = teamname;
    }
    /**
     * @return the name
     */
    public String getteamname() {
        return teamname;
    }

    /**
     * @param name the name to set
     */
    public void setteamname(String teamname) {
        this.teamname = teamname;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "team [ name=" + teamname + "]";
    }   
}