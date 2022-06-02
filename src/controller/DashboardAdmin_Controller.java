/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableModel;
import model.*;
import view.*;

/**
 *
 * @author user
 */
public class DashboardAdmin_Controller {
    Rent_Model rent_Model;
    DashboardAdmin_View dashboardAdmin_View;

    public DashboardAdmin_Controller(Rent_Model rent_Model, DashboardAdmin_View dashboardAdmin_View) {
        this.rent_Model = rent_Model;
        this.dashboardAdmin_View = dashboardAdmin_View;
        
        if(rent_Model.getDataMotor()!=0){
            String dataMotor[][] = rent_Model.ReadMotor();
            dashboardAdmin_View.tableMotor().setModel((new JTable(dataMotor, (Object[]) dashboardAdmin_View.namaKolom())).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Motor Tidak Tersedia");
        }
        
        if(rent_Model.getDataMobil()!=0){
            String dataMobil[][] = rent_Model.ReadMobil();
            dashboardAdmin_View.tableMobil().setModel((new JTable(dataMobil, (Object[]) dashboardAdmin_View.namaKolom())).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Mobil Tidak Tersedia");
        }
        
        dashboardAdmin_View.btnDataKendaraan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                InputKendaraan_View input_view = new InputKendaraan_View();
                dashboardAdmin_View.dispose();
                InputKendaraan_Controller controller = new InputKendaraan_Controller(rent_Model, input_view);
            }
        });
        
        dashboardAdmin_View.btnDaftarSewa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                DaftarSewa_View daftarSewa_View = new DaftarSewa_View();
                dashboardAdmin_View.dispose();
                DaftarSewa_Controller daftarSewa_Controller = new DaftarSewa_Controller(rent_Model, daftarSewa_View);
            }
        });
        
        dashboardAdmin_View.tableMotor().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int baris = dashboardAdmin_View.tableMotor().getSelectedRow();
                TableModel model = dashboardAdmin_View.tableMotor().getModel();
                String selected = model.getValueAt(baris, 0).toString();
                dashboardAdmin_View.dispose();
                
                UpdateKendaraan_View updateKendaraan_View = new UpdateKendaraan_View();
                updateKendaraan_View.setId(selected);
                updateKendaraan_View.fMerk().setText(model.getValueAt(baris, 1).toString());
                updateKendaraan_View.fPlat().setText(model.getValueAt(baris, 2).toString());
                updateKendaraan_View.fHarga().setText(model.getValueAt(baris, 3).toString());
                UpdateMotor_Controller updateMotor_Controller = new UpdateMotor_Controller(rent_Model, updateKendaraan_View);
            }
        });
        
        dashboardAdmin_View.tableMobil().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int baris = dashboardAdmin_View.tableMobil().getSelectedRow();
                TableModel model = dashboardAdmin_View.tableMobil().getModel();
                String selected = model.getValueAt(baris, 0).toString();
                dashboardAdmin_View.dispose();
                
                UpdateKendaraan_View updateKendaraan_View = new UpdateKendaraan_View();
                updateKendaraan_View.setId(selected);
                updateKendaraan_View.fMerk().setText(model.getValueAt(baris, 1).toString());
                updateKendaraan_View.fPlat().setText(model.getValueAt(baris, 2).toString());
                updateKendaraan_View.fHarga().setText(model.getValueAt(baris, 3).toString());
                UpdateMobil_Controller updateMotor_Controller = new UpdateMobil_Controller(rent_Model, updateKendaraan_View);
            }
        });
    }
}