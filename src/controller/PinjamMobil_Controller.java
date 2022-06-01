/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Rent_Model;
import view.DetailPinjam_View;

/**
 *
 * @author Afrien
 */
public class PinjamMobil_Controller {
    Rent_Model rent_Model;
    DetailPinjam_View detailPinjam_View;

    public PinjamMobil_Controller(Rent_Model rent_Model, DetailPinjam_View detailPinjam_View) {
        this.rent_Model = rent_Model;
        this.detailPinjam_View = detailPinjam_View;
        
        detailPinjam_View.btPinjam().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String merk = detailPinjam_View.getMerk();
                String plat = detailPinjam_View.getPlat();
                String harga = detailPinjam_View.getHarga();
//                rent_Model.get(username, password);
//                loginUser_View.dispose();
//                DashboardUser_View dashboard_View = new DashboardUser_View();
//                DashboardUser_Controller dashboard_Controller = new DashboardUser_Controller(rent_Model, dashboard_View);
                }
            });
}
}
