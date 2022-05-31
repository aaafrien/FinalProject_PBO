/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Rent_Model;
import view.RegisterAdmin_View;

/**
 *
 * @author Afrien
 */
public class RegisterAdmin_Controller {
    Rent_Model rent_Model;
    RegisterAdmin_View registerAdmin_View;

    public RegisterAdmin_Controller(Rent_Model rent_Model, RegisterAdmin_View registerAdmin_View) {
        this.rent_Model = rent_Model;
        this.registerAdmin_View = registerAdmin_View;
    }
    
    
}
