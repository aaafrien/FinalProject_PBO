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
        
        view.btnAddMotor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String merk = view.getMerk();
                String plat = view.getPlat();
                int harga = view.getHarga();
                model.insertMotor(merk,plat,harga);
                view.setVisible(false);
                DashboardAdmin_View view = new DashboardAdmin_View();
                DashboardAdmin_Controller admin = new DashboardAdmin_Controller(model,view);
            }
        });
        
        view.btnAddMobil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String merk = view.getMerk();
                String plat = view.getPlat();
                int harga = view.getHarga();
                model.insertMobil(merk,plat,harga);
                view.setVisible(false);
                DashboardAdmin_View view = new DashboardAdmin_View();
                DashboardAdmin_Controller admin = new DashboardAdmin_Controller(model,view);
            }
        });        
        
        view.btnReset().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                view.setMerk();
                view.setPlat();
                view.setHarga();
            }
        });
    }
}
