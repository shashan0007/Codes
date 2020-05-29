/**
 * 
 */
package com.dao.impl;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.dao.UserDAO;
import com.entity.User;
import com.util.MyCassandraTemplate;

/**
 * DAOImpl class for User to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
@Repository
public class UserDAOImpl implements UserDAO {
    
    @Autowired
    private MyCassandraTemplate myCassandraTemplate;
    
    @Override
    public User createUser(User User) {     
        return myCassandraTemplate.create(User);
    }
    
    @Override
    public User getUser(String email) {       
        return myCassandraTemplate.findById(email, User.class);
    }
    
    @Override
    public User updateUser(User User) {     
        return myCassandraTemplate.update(User, User.class);
    }
    @Override
    public ResponseEntity<?> findEmail(String email){
    	return myCassandraTemplate.findEmail(email);
    }
    
    @Override
    public ResponseEntity<?> registeruser(String firstname,String lastname, String email, String password, String phone, String confirmpassword){
    	if(!password.equals(confirmpassword)){
    		//System.out.println("both passwords are not same"+HttpStatus.PRECONDITION_FAILED);
    		return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
    	}
    	User user = new User();
    	user.setemail(email);
    	user.setfirstname(firstname);
    	user.setlastname(lastname);
    	user.setpassword(password);
    	user.setphone(phone);
    	User user_exists = myCassandraTemplate.findById(email, User.class);
    	if(user_exists != null){
    		return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
    	}
    	myCassandraTemplate.create(user);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<?> changepassword(String email, String password){
    	User existing_user = myCassandraTemplate.findById(email, User.class);
    	existing_user.setpassword(password);
    	User updated_user = myCassandraTemplate.update(existing_user,User.class);
    	if(!(updated_user.getpassword().equals(password))){
    		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    	}
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<?> getJSONResponse() throws JSONException{
    	return myCassandraTemplate.getJSONResponse();
    }
    
}