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
public class DashboardUser_Controller {
    Rent_Model rent_Model;
    DashboardUser_View dashboardUser_View;

    public DashboardUser_Controller(Rent_Model rent_Model, DashboardUser_View dashboardUser_View) {
        this.rent_Model = rent_Model;
        this.dashboardUser_View = dashboardUser_View;
    }
}
