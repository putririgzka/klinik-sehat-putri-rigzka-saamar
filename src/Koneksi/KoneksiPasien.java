/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.PasienModel;

/**
 *
 * @author asus
 */
public class KoneksiPasien {
    Connection konek;
    PreparedStatement ps;
    ResultSet rs;

    public KoneksiPasien() {
    konek = KoneksiDatabase.getKoneksi();
    }

    public void simpanData(PasienModel pasien) {
        try {

            String sql = "INSERT INTO pasien (no_rm,nama_pasien,umur,alamat,poli) VALUES (?,?,?,?,?)";
            PreparedStatement ps = konek.prepareStatement(sql);

            ps.setString(1, pasien.getNo_rm());
            ps.setString(2, pasien.getNama_pasien());
            ps.setInt(3, pasien.getUmur());
            ps.setString(4, pasien.getAlamat());
            ps.setString(5, pasien.getPoli());

            ps.executeUpdate();

            System.out.println("Berhasil Disimpan!");

        } catch (Exception error) {
            System.out.println("Ada yang error disini --> " + error);
        }
    }

    public ResultSet tampilData() {

        try {

            String query = "SELECT * FROM pasien";

            ps = konek.prepareStatement(
                    query,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            rs = ps.executeQuery();

        } catch (Exception e) {

            System.out.println(e);

        }

        return rs;
    }

    public void ubah(PasienModel pasien) {

        try {

            String sql = "UPDATE pasien SET nama_pasien=?, umur=?, alamat=?, poli=? WHERE no_rm=?";

            PreparedStatement ps = konek.prepareStatement(sql);

            ps.setString(1, pasien.getNama_pasien());
            ps.setInt(2, pasien.getUmur());
            ps.setString(3, pasien.getAlamat());
            ps.setString(4, pasien.getPoli());
            ps.setString(5, pasien.getNo_rm());

            ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }

    }

    public void hapus(String no_rm) {

        try {

            String sql = "DELETE FROM pasien WHERE no_rm=?";

            PreparedStatement ps = konek.prepareStatement(sql);

            ps.setString(1, no_rm);

            ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error : " + e);

        }

    }

    public PasienModel cari(String no_rm) {

        PasienModel pasien = new PasienModel();

        try {

            String sql = "SELECT * FROM pasien WHERE no_rm=?";

            PreparedStatement ps = konek.prepareStatement(sql);

            ps.setString(1, no_rm);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                pasien.setNo_rm(rs.getString("no_rm"));
                pasien.setNama_pasien(rs.getString("nama_pasien"));
                pasien.setUmur(rs.getInt("umur"));
                pasien.setAlamat(rs.getString("alamat"));
                pasien.setPoli(rs.getString("poli"));

            }

        } catch (Exception e) {

            System.out.println("Error : " + e);

        }

        return pasien;

    }
}
