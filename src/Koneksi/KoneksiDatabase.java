/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class KoneksiDatabase {
    private static Connection koneksi;

    public static Connection getKoneksi() {

        if (koneksi == null) {

            try {

                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

                koneksi = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/db_pasien",
                        "root",
                        "");

                System.out.println("Koneksi Berhasil");

            } catch (SQLException ex) {

                System.out.println("Koneksi Gagal : " + ex.getMessage());

            }

        }

        return koneksi;

    }
}
