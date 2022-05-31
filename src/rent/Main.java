/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rent;

import model.Rent_Model;
import controller.MainMenu_Controller;
import view.*;

/**
 *
 * @author Afrien
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainMenu_View mainMenu_View = new MainMenu_View();
        Rent_Model rent_Model = new Rent_Model();
        MainMenu_Controller mainMenu_Controller = new MainMenu_Controller(rent_Model, mainMenu_View);
    }
    
}