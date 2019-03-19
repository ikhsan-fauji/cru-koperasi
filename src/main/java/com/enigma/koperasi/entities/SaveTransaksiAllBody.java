package com.enigma.koperasi.entities;

/*
 * entitas ini di gunakan  untuk menampung nilai sementara dari inputan user
 * contoh
 *
*       {
*           "nama_anggota": "Ikhsan Fauji",
*           "nama_bulan": "Maret",
*           "nama_barang": "Coklat",
*           "jumlah": 3
*       }
 */
public class SaveTransaksiAllBody {

    private String nama_anggota;
    private String nama_bulan;
    private String nama_barang;
    private Integer jumlah;

    public String getNama_anggota() {
        return nama_anggota;
    }

    public void setNama_anggota(String nama_anggota) {
        this.nama_anggota = nama_anggota;
    }

    public String getNama_bulan() {
        return nama_bulan;
    }

    public void setNama_bulan(String nama_bulan) {
        this.nama_bulan = nama_bulan;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
}
