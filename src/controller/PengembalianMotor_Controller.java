/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Rent_Model;
import view.*;

/**
 *
 * @author Afrien
 */
public class PengembalianMotor_Controller {
    Rent_Model rent_Model;
    Pengembalian_View pengembalian_View;

    public PengembalianMotor_Controller(Rent_Model rent_Model, Pengembalian_View pengembalian_View) {
        this.rent_Model = rent_Model;
        this.pengembalian_View = pengembalian_View;
        
        pengembalian_View.btKembalikan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String id = pengembalian_View.getId();
                String merk = pengembalian_View.lbMerk().getText();
                String plat = pengembalian_View.lbPlat().getText();
                int harga = pengembalian_View.getHarga();
                rent_Model.kembalikanMotor(merk, plat, harga, id);
                pengembalian_View.dispose();
                DaftarSewa_View daftarSewa_View = new DaftarSewa_View();
                DaftarSewaUser_Controller daftarSewaUser_Controller = new DaftarSewaUser_Controller(rent_Model, daftarSewa_View);
            }
        });
        
        pengembalian_View.btCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                pengembalian_View.dispose();
                DaftarSewa_View daftarSewa_View = new DaftarSewa_View();
                DaftarSewaUser_Controller daftarSewaUser_Controller = new DaftarSewaUser_Controller(rent_Model, daftarSewa_View);
            }
        });
    }
}
