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
    Rent_Model model;
    DashboardAdmin_View view;

    public DashboardAdmin_Controller(Rent_Model model, DashboardAdmin_View view) {
        this.model = model;
        this.view = view;
        
        if(model.getDataMotor()!=0){
            String dataMotor[][] = model.ReadMotor();
            view.tableMotor().setModel((new JTable(dataMotor, view.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Tersedia");
        }
        
        view.tableMotor().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mousePressed(e);
                int baris = view.tableMotor().getSelectedRow();
                String selected = view.tableMotor().getValueAt(baris, 0).toString();
                UpdateMotor_View update = new UpdateMotor_View();
                view.setVisible(false);
                UpdateMotor_Controller updatecontroller = new UpdateMotor_Controller();
                
            }

        });
    }
}
