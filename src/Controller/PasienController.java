/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Koneksi.KoneksiPasien;
import Model.PasienModel;
import java.sql.ResultSet;

/**
 *
 * @author asus
 */
public class PasienController {
    KoneksiPasien hubungkan;

    public PasienController() {
        hubungkan = new KoneksiPasien();
    }

    // Simpan
    public void simpanData(String no_rm, String nama_pasien, int umur, String alamat, String poli) {

    PasienModel pasien = new PasienModel();

    pasien.setNo_rm(no_rm);
    pasien.setNama_pasien(nama_pasien);
    pasien.setUmur(umur);
    pasien.setAlamat(alamat);
    pasien.setPoli(poli);

    hubungkan.simpanData(pasien);
    }

    // Tampil Data
    public ResultSet tampilData() {
        return hubungkan.tampilData();
    }

    // Ubah
    public void ubah(String no_rm, String nama_pasien, int umur, String alamat, String poli) {

        PasienModel pasien = new PasienModel();

        pasien.setNo_rm(no_rm);
        pasien.setNama_pasien(nama_pasien);
        pasien.setUmur(umur);
        pasien.setAlamat(alamat);
        pasien.setPoli(poli);

        hubungkan.ubah(pasien);
    }

    // Hapus
    public void hapus(String no_rm) {
        hubungkan.hapus(no_rm);
    }

    // Cari
    public PasienModel cari(String no_rm) {
        return hubungkan.cari(no_rm);
    } 
}
