package com.enigma.koperasi.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_anggota")
public class AnggotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_anggota;

    @Column(name = "nama")
    private String nama;

    @Column(name = "no_hp")
    private String no_hp;

    public Integer getId_anggota() {
        return id_anggota;
    }

    public void setId_anggota(Integer id_anggota) {
        this.id_anggota = id_anggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }
}
