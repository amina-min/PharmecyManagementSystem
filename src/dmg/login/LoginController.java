/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmg.login;

import dmg.cpanel.ControlPanel;
import dmg.screens.UserControlPanel;

import dmg.model.User;
import dmg.service.UserDaoImple;
import dmg.service.UserDaoInterface;
import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author b
 */
public class LoginController {

    public static void login(JFrame loginFrame, String username, String password) {

        UserDaoInterface udao = new UserDaoImple();
        User user = null;
        try {
            user = udao.getUser(username);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        }

        // if user is null from database
        if (user == null) {
            //  new Dialog("User Doesn't Exists").setVisible(true);
            JLabel label = new JLabel("\tUser Doesn't Exists\t");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
        } // if password doesnt match
        else if (!user.getPassword().equals(password)) {
            JLabel label = new JLabel("password doesn't match");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);

        } // if password match login
        else if (user.getPassword().equals(password)) {

            if (user.getRole().equals("admin")) {
                loginFrame.dispose();
                new ControlPanel().setVisible(true);
            } else if (user.getRole().equals("user")) {
                loginFrame.dispose();
                new UserControlPanel().setVisible(true);
            }

        } else {
            JOptionPane.showMessageDialog(loginFrame, " ki holo bujhlam na");
        }

    }



}
