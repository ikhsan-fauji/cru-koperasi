package com.enigma.koperasi.entities;

/*
* entitas ini di gunakan  untuk menampung nilai sementara dari inputan user
* contoh
*   [
*       {
*           "nama_barang": "Coklat",
*           "jumlah": 3
*       },
*       {
 *           "nama_barang": "Coklat",
 *           "jumlah": 3
 *       }
*   ]
*/

public class SaveTransaksi {

    private String nama_barang;
    private Integer jumlah;

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
