package com.dao;

import com.entity.TeamName;
import com.entity.User;

/**
 * DAO interface for User to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
public interface TeamNameDAO {
    /**
     * Used to Create the team Information
     * @param teamname
     * @return {@string teamname}
     */
    public TeamName createteamname(String teamname);
    
    /**
     * Getting the User Information using Id
     * @param id
     * @return {@link User}
     */
    public boolean getteamname(String teamname);
}