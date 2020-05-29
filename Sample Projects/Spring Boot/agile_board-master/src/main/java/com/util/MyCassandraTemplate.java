package com.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.entity.Scrum;
import com.entity.SprintTeam;
import com.entity.Task;
import com.entity.Tasks;
import com.entity.TeamName;
import com.entity.User;
import com.entity.UserStory;

/**
 * Utility class for handling all CRUD Operations.
 * @author Shweta
 * @version 1.0
 */
@Repository
public class MyCassandraTemplate {
    
    @Autowired
    private CassandraOperations cassandraTemplate;
    
    /** MyCassandraTemplate Default constructor*/
    public MyCassandraTemplate() {
        System.out.println("MyCassandraTemplate()");
    }
    
    /**
     * Creating the entity.
     * @param entity
     * @return {@link Object}
     */
    public <T> T create(T entity) {
        return cassandraTemplate.insert(entity);
    }
    
    public ResponseEntity<?> createUserStory(UserStory userstory) {
        UserStory story_created = cassandraTemplate.insert(userstory);
        if(story_created == null){
        	return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
 /*   
	public String updateUserStory(UserStory userstory){
		UserStory updateuserstory = cassandraTemplate.update(userstory);
		if(updateuserstory == null){
			return "User Story cannot be modified";
		}
		return "User Story successfully modified";
	}
*/	
    public ResponseEntity<?> findEmail(String email) {
        User user = cassandraTemplate.selectOne("Select * from user where email = " + "'"+email+"'" + " allow filtering", User.class);
        if(user == null){
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
	@SuppressWarnings("deprecation")
	public <T> ResponseEntity<?> deleteUserStory(Object id, Class<T> claz) {
        String result = new String();
        List<Task> taskdelete = cassandraTemplate.select("Select * from Task where userstoryid = " + id + " allow filtering", Task.class);
        if(taskdelete.isEmpty()){
        	result = "No tasks with this user story,safe to delete";
        	cassandraTemplate.deleteById(claz, id);
        	return new ResponseEntity<String>(result, HttpStatus.OK);
        }
		cassandraTemplate.delete(taskdelete);
		cassandraTemplate.deleteById(claz, id);
		result = "User Story has been deleted";
		return new ResponseEntity<String>(result, HttpStatus.OK);
    }
	
	public <T> ResponseEntity<?> updateUserStory(T entity) {
		String result = new String();
        cassandraTemplate.update(entity);
        result = "User Story updated";
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
    
    /**
     * Creating the list of entities.
     * @param entity
     */
    public <T> void createList(List<T> entities) {
        cassandraTemplate.insert(entities);     
    }
    
    /**
     * Updating the entity.
     * @param entity
     * @param claz
     * @return T
     */
    public <T> T update(T entity) {     
        return (T) cassandraTemplate.update(entity);
    }
    
    /**
     * Updating the list of entities.
     * @param entity
     * @param claz
     * @return T
     */
    public <T> void updateList(List<T> entities) {      
        cassandraTemplate.update(entities);
    }
    
    /**
     * Updating the entity.
     * @param entity
     * @param claz
     * @return T
     */
    public <T> T update(T entity, Class<T> claz) {      
        return (T) cassandraTemplate.update(entity);
    }
    
    /**
     * Get the Entity using Id.
     * @param id
     * @param claz
     * @return T
     */
    public <T> T findById(Object id, Class<T> claz) {
        return cassandraTemplate.selectOneById(claz, id);
    }
    
    /**
     * Delete the Entity using Id.
     * @param id
     * @param claz
     */
    public <T> void deleteById(Object id, Class<T> claz) {
        cassandraTemplate.deleteById(claz, id);
    }
    
    /**
     * Delete the Entity using object.
     * @param entity    
     */
    public void delete(Object entity) {
        cassandraTemplate.delete(entity);
    }
    
    /**
     * Deleting the list of entities 
     * @param entities
     */
    public <T> void delete(List<T> entities) {
        cassandraTemplate.delete(entities);
    }
    
    /**
     * Deleting the all entities.   
     * @param claz
     */
    public <T> void deleteAll(Class<T> claz) {
        cassandraTemplate.deleteAll(claz);
    }
    
    /**
     * Getting the all entities.
     * @param claz
     * @return List of entities
     */
    @SuppressWarnings("deprecation")
	public <T> List<T> findAll(Class<T> claz) {
        return (List<T>) cassandraTemplate.selectAll(claz);
    }
    
    /**
     * Getting the all entity values using specific id's data.
     * @param ids
     * @param claz
     * @return
     */
    public <T> List<SprintTeam> findSprintNames(String teamname, Class<T> claz) {
    	List<SprintTeam> sprint = cassandraTemplate.select("select * from SprintTeam where teamname = " + "'"+teamname+"'" + "allow filtering", SprintTeam.class);
        return sprint;
    }
    
    /**
     * Getting the count of records.
     * @param claz
     * @return the count value.
     */
    public <T> void truncate(Class<T> claz) {
        cassandraTemplate.truncate(claz.getName());
    }
    
    /**
     * Getting the count of records.
     * @param claz
     * @return the count value.
     */
    public <T> long getCount(Class<T> claz) {
        return cassandraTemplate.count(claz);
    }   
    
    public <T> boolean findteamname(String teamname, Class<T> claz)
    {
    	TeamName team = cassandraTemplate.selectOne("select * from Team where teamname = " + "'"+teamname+"'" + "allow filtering"  , TeamName.class);
    	if(team == null || !(team.getteamname().equals(teamname))){
    		return true;
    	}
    	return false;
    }

    
    /**
     * Checking the object exists or not.
     * @param id
     * @param claz
     * @return true if the object exists in the database otherwise it will return false.
     */
    public <T> boolean exists(Object id, Class<T> claz) {
        return cassandraTemplate.exists(claz, id);
    }

	public List<SprintTeam> findAll(String teamname, Class<SprintTeam> class1) {
		return cassandraTemplate.select(teamname,class1);
	}
	
	public ResponseEntity<?> createSprintTeam(int id,String teamname, String sprint){
		String result = new String();
		List<SprintTeam> sprints = cassandraTemplate.select("Select * from SprintTeam where sprintname = " + "'"+sprint+"'" + " and teamname = " + "'"+teamname+"'" + " allow filtering", SprintTeam.class);
		if(sprints.isEmpty())
		{
			SprintTeam newsprint = new SprintTeam(id,teamname,sprint);
			cassandraTemplate.insert(newsprint);
			result = "Sprint Name has been created";
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}
		result = "Sprint is already Existing";
		return new ResponseEntity<String>(result, HttpStatus.ALREADY_REPORTED);
	}
	
	public ResponseEntity<?> createTask(int taskid,int UID,String description,String status,String user)
	{
		Task taskcheck = cassandraTemplate.selectOne("Select * from Task where taskname = " + "'"+description+"'" + " and userstoryid = " + UID + " allow filtering", Task.class);
		if(taskcheck == null){
			Task newtask = new Task();
			newtask.setTaskId(taskid);
			newtask.setTaskname(description);
			newtask.setTaskStatus(status);
			newtask.setUserStoryId(UID);
			newtask.setTaskUser(user);
			
			cassandraTemplate.insert(newtask);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
	}
	
	public ResponseEntity<?> findAllUserStory(int id,Class<UserStory> claz){
		Map<Object, Object> result = new HashMap<Object,Object>();
		UserStory individualUS;
		int individualUS_id;
		List<Task> tasks;
		List<UserStory> userstories = cassandraTemplate.select("Select * from UserStory where SprintTeamId = " + id + " allow filtering", UserStory.class);
		for(int i = 0; i < userstories.size(); i++){
			individualUS = userstories.get(i);
			individualUS_id = individualUS.getUserStoryID();
			tasks = cassandraTemplate.select("Select * from Task where userstoryid = " + individualUS_id + " allow filtering", Task.class);
			result.put(individualUS,tasks);
		}
		return new ResponseEntity<Map<Object,Object>>(result, HttpStatus.OK);
	}
	
	public ResponseEntity<?> updateTask(Task task){
		String result = new String();
		Task updatetask = cassandraTemplate.update(task);
		if(updatetask == null){
			result = "Task cannot be modified";
			return new ResponseEntity<String>(result,HttpStatus.BAD_REQUEST);
		}
		result = "Task successfully modified";
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	public ResponseEntity<?> deleteTask(int UID,int TID){
		String result = new String();
		Task taskdelete = cassandraTemplate.selectOne("Select * from Task where taskid = " + TID + " and userstoryid = " + UID + " allow filtering", Task.class);
		if(taskdelete == null){
			result = "No such task exists. Hence cant delete task";
			return new ResponseEntity<String>(result,HttpStatus.BAD_REQUEST);
		}
		cassandraTemplate.delete(taskdelete);
		result = "Task has been deleted successfully";
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	public ResponseEntity<?> getJSONResponse() throws JSONException{

		List<Scrum> scrumlist = cassandraTemplate.select("Select * from Scrum", Scrum.class);
		int no_of_scrums = scrumlist.size();
		
		JSONArray jsonobjectarray = new JSONArray();
		JSONObject[] object = new JSONObject[no_of_scrums];

		for(int i = 0; i < no_of_scrums; i++)
		{
			Scrum scrum = scrumlist.get(i);
			long scrumid = scrum.getscrumid();
			String scrumname = scrum.getscrumname();

			object[i] = new JSONObject();
			object[i].put("Id", scrumid);
			object[i].put("Scrum", scrumname);

			JSONArray scrumstoryarray = new JSONArray();

			List<SprintTeam> sprintlist = cassandraTemplate.select("Select * from Sprintteam where teamname =" +"'"+scrumname+"'"+ " allow filtering", SprintTeam.class);
			int no_of_sprints = sprintlist.size();
			JSONObject[] scrumstories = new JSONObject[no_of_sprints];
			
			for(int j = 0; j < no_of_sprints; j++)
			{
				SprintTeam sprint = sprintlist.get(j);
				String sprintname = sprint.getSprintName();
				int sprintid = sprint.getSprintTeamId();
				scrumstories[i] = new JSONObject();
				scrumstories[i].put("sprint",sprintname);

				JSONArray sprintstories = new JSONArray();
		
				List<UserStory> userstorylist = cassandraTemplate.select("Select * from userstory where sprintteamid =" +sprintid+ " allow filtering", UserStory.class);
				int no_of_userstories = userstorylist.size();
				
				JSONObject[] US1 = new JSONObject[no_of_userstories];
				for(int k = 0; k < no_of_userstories; k++)
				{
					UserStory userstory = userstorylist.get(k);
					String userstoryname = userstory.getUserStoryName();
					int userstoryid = userstory.getUserStoryID();
					US1[k] = new JSONObject();
					US1[k].put("title",userstoryname);

					JSONArray tasks = new JSONArray();
					
					List<Tasks> tasklist = cassandraTemplate.select("Select * from Tasks where userstoryid =" +userstoryid+ " allow filtering", Tasks.class);
					int no_of_tasks = tasklist.size();
					if (!tasklist.isEmpty()) {
					for(int l = 0; l < no_of_tasks; l++)
					{
						JSONObject story1 = new JSONObject();
						Tasks task = tasklist.get(l);
						int taskid = task.getTaskId();
						String taskname = "Task"+taskid;
						String taskdescription = task.getTaskName();
						Date taskdate = task.getDate();
						String taskstatus = task.getTaskStatus();
						String taskowner = task.getTaskUser();
						story1.put("story",taskname);
						story1.put("description",taskdescription);
						story1.put("Date",taskdate);
						story1.put("Status",taskstatus);
						story1.put("Owner",taskowner);
						tasks.put(story1);
					}
				}
					else {
						//throw new JSONException(" Empty list : ");
						//System.out.println("Empty List : ----> continuing");
					}
					US1[k].put("tasks",tasks);
					US1[k].put("editing","false");
					sprintstories.put(US1[k]);
				}
				scrumstories[i].put("SprintStories",sprintstories);
				scrumstoryarray.put(scrumstories[i]);
			}
			object[i].put("ScrumStories",scrumstoryarray);
			jsonobjectarray.put(object[i]);
			System.out.println(object[i].toString(4));
		}
		final String dir = System.getProperty("user.dir");
		try (FileWriter file = new FileWriter("scrumdata1.json")) {
			file.write(jsonobjectarray.toString());
			System.out.println("Successfully Copied JSON to File...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
       