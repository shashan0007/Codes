package com.service;

import com.entity.TeamName;

/**
 * Service interface for User to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
public interface TeamNameService {
    /**
     * Used to Create the User Information
     * @param User
     * @return {@link User}
     */
    public TeamName createteamname(String teamname);
    
    /**
     * Getting the User Information using Id
     * @param id
     * @return {@link User}
     */
    public boolean getteamname(String teamname);

}