/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
                String password = registerUser_View.getPassword();
                String no_hp = registerUser_View.getNohp();
                if(username.isEmpty() || password.isEmpty() || no_hp.isEmpty()) {
                    rent_Model.RegisterUser(username, password, no_hp);
                    registerUser_View.dispose();
                    registerUser_View.setVisible(true);
                } else {
                    registerUser_View.dispose();
                    rent_Model.RegisterUser(username, password, no_hp);
                    DashboardUser_View dashboardUser_View = new DashboardUser_View();
                    DashboardUser_Controller dashboardUser_Controller = new DashboardUser_Controller(rent_Model, dashboardUser_View);
                }
            }
        });
        
        registerUser_View.btCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                registerUser_View.dispose();
                MainMenu_View mainMenu_View = new MainMenu_View();
                MainMenu_Controller mainMenu_Controller = new MainMenu_Controller(rent_Model, mainMenu_View);
            }
        });
        
        registerUser_View.lbLogin().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registerUser_View.dispose();
                LoginUser_View loginUser_View = new LoginUser_View();
                LoginUser_Controller loginUser_Controller = new LoginUser_Controller(rent_Model, loginUser_View);
            }
        });
    }
}
