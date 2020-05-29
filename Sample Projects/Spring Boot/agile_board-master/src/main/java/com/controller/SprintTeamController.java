package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.entity.SprintTeam;
import com.entity.UserStory;
import com.service.SprintTeamService;
import com.service.UserStoryService;

/**
 * @author Shweta
 * @version 1.0
 */
@RestController
public class SprintTeamController {
    
    @Autowired
    private SprintTeamService sprintTeamService;
    
    @Autowired
    private UserStoryService userStoryService;
    
    
    public SprintTeamController() {
        System.out.println("SprintTeamController()");
    }
    
    @RequestMapping(value = "/sprintteam/create", method = RequestMethod.POST)    
    public ResponseEntity<?> createsprint(@RequestParam("team") String teamname, @RequestParam("sprint") String sprint) {
        return sprintTeamService.createSprintTeam(teamname,sprint);
    }
    
    @RequestMapping(value = "/sprintteam/get", method = RequestMethod.GET)    
    public ResponseEntity<?> getuserstory(@RequestParam("sprintteamid") int id,@RequestParam("team") String teamname, @RequestParam("sprint") String sprint) {
        return userStoryService.getuserstories(id);
    }
    
    @RequestMapping(value = "/sprintteam/{SprintTeamId}", method = RequestMethod.DELETE)
    void delete(@PathVariable("SprintTeamId") int id) {
    	sprintTeamService.deleteSprintTeam(id);
    }
 
    @RequestMapping(value="/sprintteam", method = RequestMethod.GET)
    List<SprintTeam> findAll() {
        return sprintTeamService.getAllSprintTeam();
    }
 
    @RequestMapping(value = "/sprintteam/{SprintTeamId}", method = RequestMethod.GET)
    SprintTeam findById(@PathVariable("SprintTeamId") int id) {        
        return sprintTeamService.getSprintTeam(id);
    }
 
    @RequestMapping(value = "/sprintteam", method = RequestMethod.PUT)
    SprintTeam update(@RequestBody SprintTeam team) {
        return sprintTeamService.updateSprintTeam(team);
    }
}

