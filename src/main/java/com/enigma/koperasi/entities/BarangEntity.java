package com.enigma.koperasi.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_barang")
public class BarangEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_barang;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "harga")
    private int harga;

    public Integer getId_barang() {
        return id_barang;
    }

    public void setId_barang(Integer id_barang) {
        this.id_barang = id_barang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
