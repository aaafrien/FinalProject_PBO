/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.*;
import view.*;

/**
 *
 * @author user
 */
public class DaftarSewa_Controller {
    Rent_Model rent_Model;
    DaftarSewa_View daftarSewa_View;

    public DaftarSewa_Controller(Rent_Model rent_Model, DaftarSewa_View daftarSewa_View) {
        this.rent_Model = rent_Model;
        this.daftarSewa_View = daftarSewa_View;
        
        if(rent_Model.getDataSewaMotor()!=0){
            String dataSewaMotor[][] = rent_Model.ReadSewaMotor();
            daftarSewa_View.tableSewaMotor().setModel((new JTable(dataSewaMotor, (Object[]) daftarSewa_View.namaKolomMotor())).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Tidak ada motor yang disewa");
        }
        
        if(rent_Model.getDataSewaMobil()!=0){
            String dataSewaMobil[][] = rent_Model.ReadSewaMobil();
            daftarSewa_View.tableSewaMobil().setModel((new JTable(dataSewaMobil, (Object[]) daftarSewa_View.namaKolomMobil())).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Tidak ada motor yang disewa");
        }
        
        daftarSewa_View.btnKembali().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                DashboardAdmin_View dashboardAdmin_View = new DashboardAdmin_View();
                daftarSewa_View.dispose();
                DashboardAdmin_Controller dashboardAdmin_Controller = new DashboardAdmin_Controller(rent_Model, dashboardAdmin_View);
            }
        });
    }
    
    
}
