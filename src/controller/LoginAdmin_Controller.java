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
public class LoginAdmin_Controller {
    Rent_Model rent_Model;
    LoginAdmin_View loginAdmin_View;

    public LoginAdmin_Controller(Rent_Model rent_Model, LoginAdmin_View loginAdmin_View) {
        this.rent_Model = rent_Model;
        this.loginAdmin_View = loginAdmin_View;
        
        loginAdmin_View.btLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String username = loginAdmin_View.getUname();
                String password = loginAdmin_View.getPassword();
                if(username.isEmpty() || password.isEmpty()) {
                    rent_Model.LoginAdmin(username, password);
                    loginAdmin_View.dispose();
                    loginAdmin_View.setVisible(true);
                } else {
                    rent_Model.LoginAdmin(username, password);
                    loginAdmin_View.dispose();
                    DashboardAdmin_View view = new DashboardAdmin_View();
                    DashboardAdmin_Controller dashboardAmin_Controller = new DashboardAdmin_Controller(rent_Model, view);
                }
            }
        });
        
        loginAdmin_View.btCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MainMenu_View mainMenu_View = new MainMenu_View();
                MainMenu_Controller mainMenu_Controller = new MainMenu_Controller(rent_Model, mainMenu_View);
                loginAdmin_View.dispose();
            }
        });
        
        loginAdmin_View.lbLoginUser().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginUser_View LoginUser_View = new LoginUser_View();
                LoginUser_Controller loginUser_Controller = new LoginUser_Controller(rent_Model, LoginUser_View);
                loginAdmin_View.dispose();
            }
        });
    }
}
