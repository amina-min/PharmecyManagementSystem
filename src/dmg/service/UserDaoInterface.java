/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.service;

import dmg.model.DrugModel;
import dmg.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author b
 */
public interface UserDaoInterface {
    User getUser(String username) throws Exception;
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    List<User> getUserList();
     
}
