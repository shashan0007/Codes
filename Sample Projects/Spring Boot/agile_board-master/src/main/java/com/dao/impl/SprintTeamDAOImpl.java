/**
 * 
 */
package com.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.dao.SprintTeamDAO;
import com.entity.SprintTeam;
import com.util.MyCassandraTemplate;

/**
 * DAOImpl class for SprintTeam to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
@Repository
public class SprintTeamDAOImpl implements SprintTeamDAO {
    
	private static int id = 0; 
    @Autowired
    private MyCassandraTemplate myCassandraTemplate;

	@Override
	public SprintTeam getSprintTeam(int id) {
		return myCassandraTemplate.findById(id, SprintTeam.class);
	}
	
	@Override
	public List<SprintTeam> getSprintTeamByName(String teamname) {
		
		return myCassandraTemplate.findSprintNames(teamname,SprintTeam.class);
	}

	@Override
	public SprintTeam updateSprintTeam(SprintTeam team) {
		return myCassandraTemplate.update(team, SprintTeam.class);
	}

	@Override
	public void deleteSprintTeam(int id) {
		myCassandraTemplate.deleteById(id, SprintTeam.class);
		
	}

	@Override
	public List<SprintTeam> getAllSprintTeam() {
		return myCassandraTemplate.findAll(SprintTeam.class);
	}
	
	@Override
	public ResponseEntity<?> createSprintTeam(String teamname, String sprint)
	{
		id++;
		return myCassandraTemplate.createSprintTeam(id,teamname,sprint);
	}
}