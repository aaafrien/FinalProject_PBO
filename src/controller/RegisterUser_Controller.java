/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Rent_Model;
import view.*;

/**
 *
 * @author Afrien
 */
public class RegisterUser_Controller {
    Rent_Model rent_Model;
    RegisterUser_View registerUser_View;
    
    public RegisterUser_Controller(Rent_Model rent_Model, RegisterUser_View registerUser_View) {
        this.rent_Model = rent_Model;
        this.registerUser_View = registerUser_View;
        
        registerUser_View.btRegist().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String username = registerUser_View.getUname();
                String password = registerUser_View.getPw();
                String no_hp = registerUser_View.getNohp();
                rent_Model.RegisterUser(username, password, no_hp);
                Dashboard_View dashboard_View = new Dashboard_View();
                Dashboard_Controller dashboard_Controller = new Dashboard_Controller(rent_Model, dashboard_View);
                registerUser_View.dispose();
            }
        });
        
        
    }
}
