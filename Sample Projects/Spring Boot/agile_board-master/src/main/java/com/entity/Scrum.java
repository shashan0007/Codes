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
@Table("scrum")
public class Scrum {
    
    @PrimaryKey("scrumname")
    private String scrumname; 
    
    @Column("scrumid")
    private long scrumid;
    
    
    /**
     * Default Constructor
     */
    public Scrum() {
        super();        
    }

    /**
     * Parameterized Constructor
     * @param id
     * @param name
     * @param age
     * @param salary
     */
    public Scrum(String scrumname,int id) {
        super();
        this.scrumname = scrumname;
        this.scrumid = id;
    }
    /**
     * @return the name
     */
    public String getscrumname() {
        return scrumname;
    }

    /**
     * @param name the name to set
     */
    public void setscrumid(long scrumid) {
        this.scrumid = scrumid;
    }

    public long getscrumid() {
        return scrumid;
    }

    /**
     * @param name the name to set
     */
    public void setscrumname(String scrumname) {
        this.scrumname = scrumname;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "scrum [ name=" + scrumname + "id =" + scrumid + "]";
    }   
}