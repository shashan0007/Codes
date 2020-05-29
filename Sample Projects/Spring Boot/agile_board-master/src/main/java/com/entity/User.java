package com.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * Employee entity class.
 * 
 * @author Shweta
 * @version 1.0
 */
@Table("User")
public class User {
    
    @PrimaryKey("email")
    private String email;    
    
    @Column("firstname")
    private String firstname; 
    
    @Column("lastname")
    private String lastname; 
    
    @Column("password")
    private String password;
    
    @Column("phone")
    private String phone;
    
    /**
     * Default Constructor
     */
    public User() {
        super();        
    }

    /**
     * Parameterized Constructor
     * @param id
     * @param name
     * @param age
     * @param salary
     */
    public User(String firstname, String lastname, String email,String password,String phone) {
        super();
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.password = password;
    }


    /**
     * @return the name
     */
    public String getemail() {
        return email;
    }

    /**
     * @param name the name to set
     */
    public void setemail(String email) {
        this.email = email;
    }



    /**
     * @return the name
     */
    public String getfirstname() {
        return firstname;
    }

    /**
     * @param name the name to set
     */
    public void setfirstname(String fname) {
        this.firstname = fname;
    }
    
    public String getlastname() {
        return lastname;
    }

    /**
     * @param name the name to set
     */
    public void setlastname(String lname) {
        this.lastname = lname;
    }
    
    public String getpassword() {
        return password;
    }

    /**
     * @param salary the salary to set
     */
    public void setpassword(String password) {
        this.password = password;
    }
    
    public String getphone() {
        return phone;
    }

    /**
     * @param name the name to set
     */
    public void setphone(String ph_no) {
        this.phone = ph_no;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [ email=" + email + ", firstname=" + firstname + ", lastname = " + lastname + " , password=" + password + " , phone=" + phone + "]";
    }   
}