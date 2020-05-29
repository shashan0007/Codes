package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.SprintTeamDAO;
import com.entity.SprintTeam;
import com.service.SprintTeamService;

/**
 * Service Impl class for SprintTeam to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
@Service
public class SprintTeamServiceImpl implements SprintTeamService {

    @Autowired  
    private SprintTeamDAO sprintTeamDAO;

    /**
     * Default Constructor
     */
    public SprintTeamServiceImpl() {
        super();    
    }

	@Override
	public SprintTeam getSprintTeam(int id) {
		 return sprintTeamDAO.getSprintTeam(id);
	}
	
	@Override
	public List<SprintTeam> getSprintTeamByName(String teamname) {
		 return sprintTeamDAO.getSprintTeamByName(teamname);
	}

	@Override
	public SprintTeam updateSprintTeam(SprintTeam team) {
		return sprintTeamDAO.updateSprintTeam(team);
	}

	@Override
	public void deleteSprintTeam(int id) {
		sprintTeamDAO.deleteSprintTeam(id);
	}

	@Override
	public List<SprintTeam> getAllSprintTeam() {
		return sprintTeamDAO.getAllSprintTeam();
	}
	
	@Override
	public ResponseEntity<?> createSprintTeam(String teamname, String sprint)
	{
		return sprintTeamDAO.createSprintTeam(teamname,sprint);
	}

  

}