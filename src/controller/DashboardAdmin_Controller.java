/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.*;
import javax.swing.*;
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
        
        if(rent_Model.getDataMotor()!=0) {
            String dataMotor[][] = rent_Model.ReadMotor();
            dashboardAdmin_View.tableMotor().setModel((new JTable(dataMotor, (Object[]) dashboardAdmin_View.namaKolom())).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Tersedia");
        }
        
        dashboardAdmin_View.btnDataKendaraan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                InputKendaraan_View inputKendaraan_View = new InputKendaraan_View();
                InputKendaraan_Controller inputKendaraan_Controller = new InputKendaraan_Controller(rent_Model, inputKendaraan_View);
            }
        });
        
        dashboardAdmin_View.tableMotor().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int baris = dashboardAdmin_View.tableMotor().getSelectedRow();
                String selected = dashboardAdmin_View.tableMotor().getValueAt(baris, 0).toString();
                UpdateMotor_View update = new UpdateMotor_View();
                dashboardAdmin_View.setVisible(false);
                UpdateMotor_Controller updateMotor_Controller = new UpdateMotor_Controller();
            }
        });
    }
}