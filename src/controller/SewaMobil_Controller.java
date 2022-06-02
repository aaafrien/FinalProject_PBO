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
import view.DetailSewa_View;

/**
 *
 * @author Afrien
 */
public class SewaMobil_Controller {
    Rent_Model rent_Model;
    DetailSewa_View detailSewa_View;

    public SewaMobil_Controller(Rent_Model rent_Model, DetailSewa_View detailSewa_View) {
        this.rent_Model = rent_Model;
        this.detailSewa_View = detailSewa_View;
        
        detailSewa_View.btPinjam().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String id = detailSewa_View.getId();
                String merk = detailSewa_View.lbMerk().getText();
                System.out.println(merk);
                String plat = detailSewa_View.lbPlat().getText();
                System.out.println(plat);
                Date tgl_sewa = detailSewa_View.tglSewa();
                System.out.println(tgl_sewa);
                Date tgl_kembali = detailSewa_View.tglKembali();
                System.out.println(tgl_kembali);
                rent_Model.sewaMobil(merk, plat, tgl_sewa, tgl_kembali, id);
                detailSewa_View.dispose();
                DashboardUser_View dashboardUser_View = new DashboardUser_View();
                DashboardUser_Controller dashboard_Controller = new DashboardUser_Controller(rent_Model, dashboardUser_View);
            }
        });
    }
}