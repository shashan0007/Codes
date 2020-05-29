package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.SprintTeam;
import com.entity.TeamName;
import com.service.SprintTeamService;
import com.service.TeamNameService;

/**
 * @author Shweta
 * @version 1.0
 */
@RestController
public class TeamNameController {
    
    @Autowired
    private TeamNameService TeamNameService;
    
    @Autowired
    private SprintTeamService SprintTeamService;
    
    public TeamNameController() {
        System.out.println("TeamNameController()");
    }
         
    @RequestMapping(value = "/create/team", method = RequestMethod.POST)    
    public ResponseEntity<?> create(@RequestParam("team") String teamname) {
       boolean team = TeamNameService.getteamname(teamname);
       String result = new String();
       if(team == false)
       {
    	   result = "Team Name already Exists";
    	   return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
       }
       TeamName team_created = TeamNameService.createteamname(teamname);
       if(team_created==null || !(team_created.getteamname()).equals(teamname))
       {
    	   result = "TeamName has not been created due to some issue" ;
    	   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
       result = "Team Name has been created";
       return new ResponseEntity<>(HttpStatus.OK);
    }
 
    @RequestMapping(value = "/get/team", method = RequestMethod.GET)
    public List<SprintTeam> get(@RequestParam("team") String teamname) {
    	return SprintTeamService.getSprintTeamByName(teamname);
    }
}


