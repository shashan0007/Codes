package com.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.entity.SprintTeam;

/**
 * DAO interface for SprintTeam to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
public interface SprintTeamDAO {
    /**
     * Used to Create the SprintTeam Information
     * @param SprintTeam
     * @return {@link SprintTeam}
     */
    
    /**
     * Getting the SprintTeam Information using Id
     * @param id
     * @return {@link SprintTeam}
     */
    public SprintTeam getSprintTeam(int id);
    public List<SprintTeam> getSprintTeamByName(String teamname);
    
    /**
     * Used to Update the SprintTeam Information
     * @param SprintTeam
     * @return {@link SprintTeam}
     */
    
    public SprintTeam updateSprintTeam(SprintTeam team);
    
    /**
     * Deleting the SprintTeam Information using Id
     * @param id
     */
    public void deleteSprintTeam(int id);
    
    /**
     * Getting the All SprintTeams information
     * @return
     */
    public List<SprintTeam> getAllSprintTeam();

	public ResponseEntity<?> createSprintTeam(String teamname, String sprint);
}