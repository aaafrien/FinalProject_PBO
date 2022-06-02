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
public class UpdateMobil_Controller {
    Rent_Model rent_Model;
    UpdateKendaraan_View updateKendaraan_View;

    public UpdateMobil_Controller(Rent_Model rent_Model, UpdateKendaraan_View updateKendaraan_View) {
        this.rent_Model = rent_Model;
        this.updateKendaraan_View = updateKendaraan_View;
        
        updateKendaraan_View.btnUpdate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String id = updateKendaraan_View.getId();
                String merk = updateKendaraan_View.fMerk().toString();
                String plat = updateKendaraan_View.fPlat().toString();
                int harga = updateKendaraan_View.getHarga();
                System.out.println(harga);
                rent_Model.updateMobil(merk, plat, harga, id);
                updateKendaraan_View.dispose();
                DashboardAdmin_View dashboardAdmin_View = new DashboardAdmin_View();
                DashboardAdmin_Controller dashboardAdmin_Controller = new DashboardAdmin_Controller(rent_Model, dashboardAdmin_View);
            }
        });
        
        updateKendaraan_View.btnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                updateKendaraan_View.dispose();
                DashboardAdmin_View dashboardAdmin_View = new DashboardAdmin_View();
                DashboardAdmin_Controller dashboardAdmin_Controller = new DashboardAdmin_Controller(rent_Model, dashboardAdmin_View);
            }
        });
    }
}
