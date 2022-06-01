/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JFormattedTextField;
import model.Rent_Model;
import view.DashboardUser_View;
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
                String id = detailPinjam_View.getId();
                String merk = detailPinjam_View.lbMerk().getText();
                System.out.println(merk);
                String plat = detailPinjam_View.lbPlat().getText();
                System.out.println(plat);
                Date tgl_sewa = detailPinjam_View.tglSewa();
                System.out.println(tgl_sewa);
                Date tgl_kembali = detailPinjam_View.tglKembali();
                System.out.println(tgl_kembali);
                rent_Model.sewaMobil(merk, plat, tgl_sewa, tgl_kembali, id);
                detailPinjam_View.dispose();
                DashboardUser_View dashboardUser_View = new DashboardUser_View();
                DashboardUser_Controller dashboard_Controller = new DashboardUser_Controller(rent_Model, dashboardUser_View);
            }
        });
    }
}