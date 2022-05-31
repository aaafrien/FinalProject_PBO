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
public class Dashboard_Controller {
    Rent_Model rent_Model;
    Dashboard_View dashboard_View;

    public Dashboard_Controller(Rent_Model rent_Model, Dashboard_View dashboard_View) {
        this.rent_Model = rent_Model;
        this.dashboard_View = dashboard_View;
        
        dashboard_View.btMobil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                
            }
        });
    }
    
    
}
