/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Afrien
 */
public class Rent_Model {
    String DBurl = "jdbc:mysql://localhost/db_rent";
    String DBuname = "root";
    String DBpw = "";
    
    Connection conn;
    Statement stat;
    
    public Rent_Model() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBurl, DBuname, DBpw);
            System.out.println("Connection success!");
        } catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Connection failed!");
        }
    }

    public void LoginUser(String uname, String pw) {
        try {
            if(uname.isEmpty() || pw.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username & Password cannot be empty!");
            } else {
                String query = "SELECT * FROM `user` WHERE `username`='" + uname +"' AND `password`='" + pw + "'";
                stat = conn.createStatement();
                stat.executeQuery(query);
                
                JOptionPane.showMessageDialog(null, "Login success!");
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Login failed!");
        }
    }

    public void LoginAdmin(String uname, String pw) {
        try {
            if(uname.isEmpty() || pw.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username & Password cannot be empty!");
            } else {
                String query = "SELECT * FROM `admin` WHERE `username`='" + uname +"' AND `password`='" + pw + "'";
                stat = conn.createStatement();
                stat.executeQuery(query);
                
                JOptionPane.showMessageDialog(null, "Login success!");
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Login failed!");
        }
    }
    
    public void RegisterUser(String uname, String pw, String no_hp) {
        try {
            if(uname.isEmpty() || pw.isEmpty() || no_hp.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username & Password cannot be empty!");
            } else {
                String query = "INSERT INTO `user`(`username`,`password`, `no_hp`)" + "VALUES('" + uname + "','" + pw + "','" + no_hp + "')";
                stat = conn.createStatement();
                stat.executeQuery(query);
                
                JOptionPane.showMessageDialog(null, "Register success!");
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Register  failed!");
        }
    }
    
    public void RegisterAdmin(String uname, String pw, String no_hp) {
        try {
            if(uname.isEmpty() || pw.isEmpty() || no_hp.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username & Password cannot be empty!");
            } else {
                String query = "INSERT INTO `admin`(`username`,`password`, `no_hp`)" + "VALUES('" + uname + "','" + pw + "','" + no_hp + "')";
                stat = conn.createStatement();
                stat.executeQuery(query);
                
                JOptionPane.showMessageDialog(null, "Register success!");
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Register failed!");
        }
    }
    
    public void insertMobil(String merk, String plat, String harga) {
        try {
            int jmlData = 0;
            
            String sama = "SELECT * from `mobil` WHERE `plat`='" + plat + "'";
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sama);
            while(resultSet.next()) {
                jmlData++;
            }
            
            if(jmlData==0) {
                String query = "INSERT INTO `mobil` (`merk`, `plat`, `harga_sewa`)" +
                               "VALUES ('" + merk + "', " + plat + "," + harga + ")";
                stat = conn.createStatement();
                stat.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Mobil berhasil diinput");
            } else {
                throw new Exception("duplicate");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(e.getMessage().equals("duplicate")) {
                JOptionPane.showMessageDialog(null, "Mobil sudah ada");
            } else {
                JOptionPane.showMessageDialog(null, "Mobil gagal diinput");
            }
        }
    }
    
    public void insertMotor(String merk, String plat, String harga) {
        try {
            int jmlData = 0;
            
            String sama = "SELECT * from `motor` WHERE `plat`='" + plat + "'";
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sama);
            while(resultSet.next()) {
                jmlData++;
            }
            
            if(jmlData==0) {
                String query = "INSERT INTO `motor` (`merk`, `plat`, `harga_sewa`)" +
                               "VALUES ('" + merk + "', " + plat + "," + harga + ")";
                stat = conn.createStatement();
                stat.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Motor berhasil diinput");
            } else {
                throw new Exception("duplicate");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(e.getMessage().equals("duplicate")) {
                JOptionPane.showMessageDialog(null, "Motor sudah ada");
            } else {
                JOptionPane.showMessageDialog(null, "Motor gagal diinput");
            }
        }
    }
    
    public void updateMobil(String merk, String plat, String harga, String id) {
        try {
            String query = "UPDATE `mobil` SET "
                    + "`merk`='" + merk + "',"
                    + "`plat`=" + plat + ","
                    + "`harga_sewa`=" + harga 
                    + " WHERE id=" + id;
            
            stat = conn.createStatement();
            stat.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Mobil berhasil diupdate");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mobil gagal diupdate");
        }
    }
    
    public void updateMotor(String merk, String plat, String harga, String id) {
        try {
            String query = "UPDATE `motor` SET "
                    + "`merk`='" + merk + "',"
                    + "`plat`=" + plat + ","
                    + "`harga_sewa`=" + harga 
                    + " WHERE id=" + id;
            
            stat = conn.createStatement();
            stat.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Motor berhasil diupdate");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Motor gagal diupdate");
        }
    }
    
    public void sewaMobil(String merk, String plat, String tgl_sewa, String tgl_kembali, String id) {
        try {
            String query = "INSERT INTO `mobil_disewa` (`merk`, `plat`, `tanggal_sewa`, `tanggal_kembali`)" +
                            "VALUES ('" + merk + "', " + plat + "," + tgl_sewa + "," + tgl_kembali +") WHERE `id`=" + id;
            
            stat = conn.createStatement();
            stat.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Mobil berhasil disewa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mobil gagal disewa");
        }
    }
    
    public void sewaMotor(String merk, String plat, String tgl_sewa, String tgl_kembali, String id) {
        try {
            String query = "INSERT INTO `motor_disewa` (`merk`, `plat`, `tanggal_sewa`, `tanggal_kembali`)" +
                            "VALUES ('" + merk + "', " + plat + "," + tgl_sewa + "," + tgl_kembali +") WHERE `id`=" + id;
            
            stat = conn.createStatement();
            stat.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Motor berhasil disewa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Motor gagal disewa");
        }
    }
}