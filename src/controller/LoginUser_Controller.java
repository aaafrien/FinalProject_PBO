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
public class LoginUser_Controller {
    Rent_Model rent_Model;
    LoginUser_View loginUser_View;

    public LoginUser_Controller(Rent_Model rent_Model, LoginUser_View loginUser_View) {
        this.rent_Model = rent_Model;
        this.loginUser_View = loginUser_View;
        
        loginUser_View.btLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String username = loginUser_View.getUname();
                String password = loginUser_View.getPassword();
                String cekpass = rent_Model.passUser(username, password);
                rent_Model.LoginUser(username, password);
                if(username.isEmpty() || password.isEmpty() || !password.equals(cekpass)) {
                    loginUser_View.dispose();
                    loginUser_View.setVisible(true);
                } else{
                    loginUser_View.dispose();
                    DashboardUser_View dashboardUser_View = new DashboardUser_View();
                    DashboardUser_Controller dashboardUser_Controller = new DashboardUser_Controller(rent_Model, dashboardUser_View);
                }
            }
        });
        
        loginUser_View.btCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                loginUser_View.dispose();
                MainMenu_View mainMenu_View = new MainMenu_View();
                MainMenu_Controller mainMenu_Controller = new MainMenu_Controller(rent_Model, mainMenu_View);
            }
        });
        
        loginUser_View.lbRegist().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginUser_View.dispose();
                RegisterUser_View registerUser_View = new RegisterUser_View();
                RegisterUser_Controller registerUser_Controller = new RegisterUser_Controller(rent_Model, registerUser_View);
            }
        });
        
        loginUser_View.lbLoginAdmin().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginUser_View.dispose();
                LoginAdmin_View loginAdmin_View = new LoginAdmin_View();
                LoginAdmin_Controller loginAdmin_Controller = new LoginAdmin_Controller(rent_Model, loginAdmin_View);
            }
        });
    }
}