/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
            JOptionPane.showMessageDialog(null, "Data Tidak Tersedia");
        }
        
        dashboardUser_View.tableMotor().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = dashboardUser_View.tableMotor().getSelectedRow();
                TableModel model = dashboardUser_View.tableMotor().getModel();
                String id = model.getValueAt(i, 0).toString();
                
                dashboardUser_View.dispose();
                DetailPinjam_View detailPinjam_View = new DetailPinjam_View();
                detailPinjam_View.setId(id);
                detailPinjam_View.lbMerk().setText(model.getValueAt(i, 1).toString());
                detailPinjam_View.lbPlat().setText(model.getValueAt(i, 2).toString());
                detailPinjam_View.lbHarga().setText(model.getValueAt(i, 3).toString());
                PinjamMotor_Controller pinjamMotor_Controller = new PinjamMotor_Controller(rent_Model, detailPinjam_View);
            }
        });
    }
}