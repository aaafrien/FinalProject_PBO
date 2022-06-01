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
    Rent_Model rent_Model;
    InputKendaraan_View inputKendaraan_View;

    public InputKendaraan_Controller(Rent_Model rent_Model, InputKendaraan_View inputKendaraan_View) {
        this.rent_Model = rent_Model;
        this.inputKendaraan_View = inputKendaraan_View;
        
        inputKendaraan_View.btnAddMotor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String merk = inputKendaraan_View.getMerk();
                String plat = inputKendaraan_View.getPlat();
                int harga = inputKendaraan_View.getHarga();
                rent_Model.insertMotor(merk, plat, harga);
                inputKendaraan_View.dispose();
                DashboardAdmin_View dashboardAdmin_View = new DashboardAdmin_View();
                DashboardAdmin_Controller dashboardAdmin_Controller = new DashboardAdmin_Controller(rent_Model, dashboardAdmin_View);
            }
        });
        
        inputKendaraan_View.btnAddMobil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String merk = inputKendaraan_View.getMerk();
                String plat = inputKendaraan_View.getPlat();
                int harga = inputKendaraan_View.getHarga();
                rent_Model.insertMobil(merk, plat, harga);
                inputKendaraan_View.dispose();
                DashboardAdmin_View dashboardAdmin_View = new DashboardAdmin_View();
                DashboardAdmin_Controller dashboardAdmin_Controller = new DashboardAdmin_Controller(rent_Model, dashboardAdmin_View);
            }
        });        
        
        inputKendaraan_View.btnReset().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                inputKendaraan_View.setMerk();
                inputKendaraan_View.setPlat();
                inputKendaraan_View.setHarga();
            }
        });
        
        inputKendaraan_View.btnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                inputKendaraan_View.dispose();
                DashboardAdmin_View dashboardAdmin_View = new DashboardAdmin_View();
                DashboardAdmin_Controller dashboardAdmin_Controller = new DashboardAdmin_Controller(rent_Model, dashboardAdmin_View);
            }
        });
    }
}
