package com.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.TeamNameDAO;
import com.entity.TeamName;
import com.util.MyCassandraTemplate;

/**
 * DAOImpl class for User to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
@Repository
public class TeamNameDAOImpl implements TeamNameDAO {
    
    @Autowired
    private MyCassandraTemplate myCassandraTemplate;
    
    @Override
    public TeamName createteamname(String teamname) {
    	TeamName team = new TeamName();
    	team.setteamname(teamname);
        return myCassandraTemplate.create(team);
    }
    
    @Override
    public boolean getteamname(String teamname) {       
        return myCassandraTemplate.findteamname(teamname, TeamName.class);
    }
}