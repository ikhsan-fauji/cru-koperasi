package com.enigma.koperasi.entities;


import javax.persistence.*;

@Entity
@Table(name = "tb_transaksi")
public class TransaksiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_transaksi;

    @Column(name = "id_barang")
    private Integer barang;

    @Column(name = "jumlah")
    private Integer jumlah;

    @Column(name = "total_harga")
    private Integer total_harga;

    @Column(name = "id_bulan")
    private Integer bulan;

    @Column(name = "id_anggota")
    private Integer anggota;

    public Integer getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(Integer id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public Integer getBarang() {
        return barang;
    }

    public void setBarang(Integer barang) {
        this.barang = barang;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(Integer total_harga) {
        this.total_harga = total_harga;
    }

    public Integer getBulan() {
        return bulan;
    }

    public void setBulan(Integer bulan) {
        this.bulan = bulan;
    }

    public Integer getAnggota() {
        return anggota;
    }

    public void setAnggota(Integer anggota) {
        this.anggota = anggota;
    }


}
