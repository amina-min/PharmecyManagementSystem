/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomUI;

import java.awt.Color;

/**
 *
 * @author b
 */
public class Themes {

    public static Color getMenuUnselectedBg() {
        return Color.decode("#718CAE");
    }

    public static Color getMenuHoverBg() {
        //return Color.decode("#786E59");
        return Color.decode("#445C7C");

    }

    public static Color getMenuSelectedBg() {
        return Color.decode("#445C7C");

    }

    // from 
    public static Color getLeftPanelColor() {
        return getMenuUnselectedBg();
    }

}
