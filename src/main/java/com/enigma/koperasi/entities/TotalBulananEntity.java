package com.enigma.koperasi.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_total_bulanan")
public class TotalBulananEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_bulan;

    @Column(name = "bulan")
    private String bulan;

    private int total_transaksi;



    public Integer getId_bulan() {
        return id_bulan;
    }

    public void setId_bulan(Integer id_bulan) {
        this.id_bulan = id_bulan;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public int getTotal_transaksi() {
        return total_transaksi;
    }

    public void setTotal_transaksi(int total_transaksi) {
        this.total_transaksi = total_transaksi;
    }
}
