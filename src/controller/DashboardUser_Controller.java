/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableModel;
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
        
        if(rent_Model.getDataMotor()!=0) {
            String dataMotor[][] = rent_Model.ReadMotor();
            dashboardUser_View.tableMotor().setModel((new JTable(dataMotor, (Object[]) dashboardUser_View.namaKolom())).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Tidak ada motor yang tersedia");
        }
        
        if(rent_Model.getDataMobil()!=0) {
            String dataMobil[][] = rent_Model.ReadMobil();
            dashboardUser_View.tableMobil().setModel((new JTable(dataMobil, (Object[]) dashboardUser_View.namaKolom())).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Tidak ada mobil yang tersedia");
        }
        
        dashboardUser_View.btnDaftarSewa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dashboardUser_View.dispose();
                DaftarSewa_View daftarSewa_View = new DaftarSewa_View();
                DaftarSewaUser_Controller daftarSewaUser_Controller = new DaftarSewaUser_Controller(rent_Model, daftarSewa_View);
            }
        });
        
        dashboardUser_View.tableMotor().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = dashboardUser_View.tableMotor().getSelectedRow();
                TableModel model = dashboardUser_View.tableMotor().getModel();
                String id = model.getValueAt(i, 0).toString();
                
                dashboardUser_View.dispose();
                DetailSewa_View detailSewa_View = new DetailSewa_View();
                detailSewa_View.setId(id);
                detailSewa_View.lbMerk().setText(model.getValueAt(i, 1).toString());
                detailSewa_View.lbPlat().setText(model.getValueAt(i, 2).toString());
                detailSewa_View.lbHarga().setText(model.getValueAt(i, 3).toString());
                SewaMotor_Controller pinjamMotor_Controller = new SewaMotor_Controller(rent_Model, detailSewa_View);
            }
        });
        
        dashboardUser_View.tableMobil().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = dashboardUser_View.tableMobil().getSelectedRow();
                TableModel model = dashboardUser_View.tableMobil().getModel();
                String id = model.getValueAt(i, 0).toString();
                
                dashboardUser_View.dispose();
                DetailSewa_View detailSewa_View = new DetailSewa_View();
                detailSewa_View.setId(id);
                detailSewa_View.lbMerk().setText(model.getValueAt(i, 1).toString());
                detailSewa_View.lbPlat().setText(model.getValueAt(i, 2).toString());
                detailSewa_View.lbHarga().setText(model.getValueAt(i, 3).toString());
                SewaMobil_Controller pinjamMobil_Controller = new SewaMobil_Controller(rent_Model, detailSewa_View);
            }
        });
        
        dashboardUser_View.btnLogOut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int logOut = JOptionPane.showConfirmDialog(dashboardUser_View.btnLogOut(),"Are you sure?");
                
                if (logOut == JOptionPane.YES_OPTION){
                    MainMenu_View mainMenu_View = new MainMenu_View();
                    dashboardUser_View.dispose();
                    MainMenu_Controller mainMenu_Controller = new MainMenu_Controller(rent_Model, mainMenu_View);
                }
            }
        });
    }
}
