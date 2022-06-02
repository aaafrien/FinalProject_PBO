/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;

/**
 *
 * @author Asus
 */
public class MainMenu_Controller {
    Rent_Model rent_Model;
    MainMenu_View mainMenu_View;

    public MainMenu_Controller(Rent_Model rent_Model, MainMenu_View mainMenu_View) {
        this.rent_Model = rent_Model;
        this.mainMenu_View = mainMenu_View;
        
        mainMenu_View.btLoginUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                LoginUser_View loginUser_View = new LoginUser_View();
                mainMenu_View.dispose();
                LoginUser_Controller loginUser_Controller = new LoginUser_Controller(rent_Model, loginUser_View);
            }
        });
        
        mainMenu_View.btLoginAdmin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                LoginAdmin_View loginAdmin_View = new LoginAdmin_View();
                mainMenu_View.dispose();
                LoginAdmin_Controller loginAdmin_Controller = new LoginAdmin_Controller(rent_Model, loginAdmin_View);
            }
        });
    }   
}