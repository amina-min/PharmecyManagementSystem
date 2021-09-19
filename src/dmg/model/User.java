/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author b
 */
public class User implements Serializable{
    
    private int id;
    private String fullname;
    private String username;
    private String password;
    private String role;
    private Date lastLogin;
    private Date addedOn;

    public User(int id, String fullname, String username, String password, String role, Date lastLogin, Date addedOn) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.role = role;
        this.lastLogin = lastLogin;
        this.addedOn = addedOn;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", fullname=" + fullname + ", username=" + username + ", password=" + password + ", role=" + role + ", lastLogin=" + lastLogin + ", addedOn=" + addedOn + '}';
    }
    
    
    
    
}
