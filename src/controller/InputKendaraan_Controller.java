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
 * @author user
 */
public class InputKendaraan_Controller {
    Rent_Model model;
    InputKendaraan_View view;

    public InputKendaraan_Controller(Rent_Model model, InputKendaraan_View view) {
        this.model = model;
        this.view = view;
        
        view.btnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Rent_Model model = new Rent_Model();
                DashboardAdmin_View view = new DashboardAdmin_View();
                view.setVisible(false);
                DashboardAdmin_Controller admin = new DashboardAdmin_Controller(model,view);
            }
        });
        
        view.btnReset().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                view.fHarga().setText("");
                view.fMerk().setText("");
                view.fPlat().setText("");
            }
        });
    }
}
