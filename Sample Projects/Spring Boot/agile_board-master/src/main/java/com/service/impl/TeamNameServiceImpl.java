package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TeamNameDAO;
import com.entity.TeamName;
import com.service.TeamNameService;

/**
 * Service Impl class for User to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
@Service
public class TeamNameServiceImpl implements TeamNameService {

    @Autowired  
    private TeamNameDAO TeamNameDAO;

    /**
     * Default Constructor
     */
    public TeamNameServiceImpl() {
        super();    
    }

    @Override   
    public TeamName createteamname(String teamname) {     
        return TeamNameDAO.createteamname(teamname);
    }

    @Override   
    public boolean getteamname(String teamname) {       
        return TeamNameDAO.getteamname(teamname);
    }

}