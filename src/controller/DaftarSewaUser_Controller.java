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
import javax.swing.*;
import javax.swing.table.TableModel;
import model.Rent_Model;
import view.*;

/**
 *
 * @author Afrien
 */
public class DaftarSewaUser_Controller {
    Rent_Model rent_Model;
    DaftarSewa_View daftarSewa_View;

    public DaftarSewaUser_Controller(Rent_Model rent_Model, DaftarSewa_View daftarSewa_View) {
        this.rent_Model = rent_Model;
        this.daftarSewa_View = daftarSewa_View;
        
        if(rent_Model.getDataSewaMotor()!=0){
            String dataSewaMotor[][] = rent_Model.ReadSewaMotor();
            daftarSewa_View.tableSewaMotor().setModel((new JTable(dataSewaMotor, (Object[]) daftarSewa_View.namaKolomMotor())).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Tidak ada motor yang disewa");
        }
        
        if(rent_Model.getDataSewaMobil()!=0) {
            String dataSewaMobil[][] = rent_Model.ReadSewaMobil();
            daftarSewa_View.tableSewaMobil().setModel((new JTable(dataSewaMobil, (Object[]) daftarSewa_View.namaKolomMobil())).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Tidak ada motor yang disewa");
        }
        
        daftarSewa_View.tableSewaMotor().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = daftarSewa_View.tableSewaMotor().getSelectedRow();
                TableModel model = daftarSewa_View.tableSewaMotor().getModel();
                String id = model.getValueAt(i, 0).toString();
                
                daftarSewa_View.dispose();
                Pengembalian_View pengembalian_View = new Pengembalian_View();
                pengembalian_View.setId(id);
                pengembalian_View.lbMerk().setText(model.getValueAt(i, 2).toString());
                pengembalian_View.lbPlat().setText(model.getValueAt(i, 3).toString());
                pengembalian_View.lbHarga().setText(model.getValueAt(i, 4).toString());
                pengembalian_View.lbTglSewa().setText(model.getValueAt(i, 5).toString());
                pengembalian_View.lbTglKembali().setText(model.getValueAt(i, 6).toString());
                PengembalianMotor_Controller pengembalianMotor_Controller = new PengembalianMotor_Controller(rent_Model, pengembalian_View);
            }
        });
        
        daftarSewa_View.tableSewaMobil().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = daftarSewa_View.tableSewaMobil().getSelectedRow();
                TableModel model = daftarSewa_View.tableSewaMobil().getModel();
                String id = model.getValueAt(i, 0).toString();
                
                daftarSewa_View.dispose();
                Pengembalian_View pengembalian_View = new Pengembalian_View();
                pengembalian_View.setId(id);
                pengembalian_View.lbMerk().setText(model.getValueAt(i, 2).toString());
                pengembalian_View.lbPlat().setText(model.getValueAt(i, 3).toString());
                pengembalian_View.lbHarga().setText(model.getValueAt(i, 4).toString());
                pengembalian_View.lbTglSewa().setText(model.getValueAt(i, 5).toString());
                pengembalian_View.lbTglKembali().setText(model.getValueAt(i, 6).toString());
                PengembalianMobil_Controller pengembalianMobil_Controller = new PengembalianMobil_Controller(rent_Model, pengembalian_View);
            }
        });
        
        daftarSewa_View.btnKembali().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                daftarSewa_View.dispose();
                DashboardUser_View dashboardUser_View = new DashboardUser_View();
                DashboardUser_Controller dashboardUser_Controller = new DashboardUser_Controller(rent_Model, dashboardUser_View);
            }
        });
    }    
}
