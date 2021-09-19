/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.service;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import dmg.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
  

/**
 *
 * @author b
 */
public class UserDaoImple implements UserDaoInterface {

    Connection conn = DBConnector.getConnection();

    @Override
    public void addUser(User user) {
        try {
            String sql = "insert into credentials values (?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getFullname());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole());
            ps.setDate(6, user.getLastLogin());
            ps.setDate(7, user.getAddedOn());
            ps.execute();
            System.out.println("Added Successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteUser(int id) {
        try {
            String sql = "delete from credentials where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("deleted succesfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateUser(User user) {
        deleteUser(user.getId());
        addUser(user);
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>();
        String sql = "select * from credentials";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getDate(7));
                userList.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userList;
    }
 
    @Override
    public User getUser(String username) throws Exception {
        User user = null;
        try {
            String sql = "select * from credentials where username = ?";
            
            if(conn==null){
                throw new Exception("Could'n connect to database");
            }
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();

            user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getDate(7));

            return user;
        }  catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return user;
    }
}
