package com.enigma.koperasi.controller;

import com.enigma.koperasi.entities.*;
import com.enigma.koperasi.repository.AnggotaRepository;
import com.enigma.koperasi.repository.BarangRepository;
import com.enigma.koperasi.repository.TotalBulananRepository;
import com.enigma.koperasi.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableWebMvc
@RestController
@RequestMapping(path = "/koperasi")
public class TransaksiController {

    @Autowired
    TransaksiRepository transaksiRepository;

    @Autowired
    TotalBulananRepository totalBulananRepository;

    @Autowired
    BarangRepository barangRepository;

    @Autowired
    AnggotaRepository anggotaRepository;

    // get all transaksi
    @GetMapping(path = "/transaksi")
    @ResponseBody
    public List<TransaksiEntity> getAllTransaksi() {
        return transaksiRepository.findAll();
    }

    // input transaksi 9data input berupa array list
    @PostMapping(path = "/transaksi/add")
    @ResponseBody
    public ResponseEntity<String> addTransaksi(@RequestParam(name = "nama") String nama,//parameter nama
                                               @RequestParam(name = "bulan") String bulan, // parameter bulan
                                               @RequestBody List<SaveTransaksi> transaksi) {

        // ambil data anggota berdasarkan nama
        AnggotaEntity getAnggota = anggotaRepository.findByNama(nama);
        // ambil data totalBulanan berdasarkan nama bulan
        TotalBulananEntity getBulan = totalBulananRepository.findByBulan(bulan);

        // looping jumlah array list yang dimasukan
        for (SaveTransaksi allTrx : transaksi) {
            // ambil barang berdasarkan nama barang
            BarangEntity getBarang = barangRepository.findByNamaBarang(allTrx.getNama_barang());

            // total harga di tampung dalam variable baru
            int total_harga = (allTrx.getJumlah() * getBarang.getHarga());

            // buat object baru dari transaksi dan sret nilainya
            TransaksiEntity newTransaksi = new TransaksiEntity();
            newTransaksi.setBarang(getBarang.getId_barang());
            newTransaksi.setJumlah(allTrx.getJumlah());
            newTransaksi.setTotal_harga(total_harga);
            newTransaksi.setBulan(getBulan.getId_bulan());
            newTransaksi.setAnggota(getAnggota.getId_anggota());

            // simpan setiap trnsaksi baru
            transaksiRepository.save(newTransaksi);

        }

        // ambil list data transaksi terakhir berdasarkan id bulan
        List<TransaksiEntity> totalTrx = transaksiRepository.findAllByBulan(getBulan.getId_bulan());
        int total_transaksi = 0;
        // looping transaksi terakhirr untuk mencari total transaksi per bulan
        for (TransaksiEntity trx : totalTrx) {
            // jumlahkan transaksi
            total_transaksi += trx.getTotal_harga();
        }

        // buat objek baru total bulanan serta set isinya
        TotalBulananEntity newBulanan = new TotalBulananEntity();
        newBulanan.setId_bulan(getBulan.getId_bulan());
        newBulanan.setBulan(bulan);
        newBulanan.setTotal_transaksi(total_transaksi);

        // simpan update bulanan
        totalBulananRepository.save(newBulanan);

        return ResponseEntity.ok().body("Transaksi berhasill");
    }

    // input transaksi
    @PostMapping(path = "/transaksi/add-body")
    @ResponseBody
    public ResponseEntity<String> addTransaksiAllBody(@RequestBody SaveTransaksiAllBody transaksiBody) {

        // ambil data anggota berdasarkan nama
        AnggotaEntity getAnggota = anggotaRepository.findByNama(transaksiBody.getNama_anggota());
        // ambil data totalBulanan berdasarkan nama bulan
        TotalBulananEntity getBulan = totalBulananRepository.findByBulan(transaksiBody.getNama_bulan());
        // ambil barang berdasarkan nama barang
        BarangEntity getBarang = barangRepository.findByNamaBarang(transaksiBody.getNama_barang());

        // total harga di tampung dalam variable baru
        int total_harga = (transaksiBody.getJumlah() * getBarang.getHarga());

        // buat object baru dari transaksi dan sret nilainya
        TransaksiEntity newTransaksi = new TransaksiEntity();
        newTransaksi.setBarang(getBarang.getId_barang());
        newTransaksi.setJumlah(transaksiBody.getJumlah());
        newTransaksi.setTotal_harga(total_harga);
        newTransaksi.setBulan(getBulan.getId_bulan());
        newTransaksi.setAnggota(getAnggota.getId_anggota());

        // simpan setiap trnsaksi baru
        transaksiRepository.save(newTransaksi);

        // ambil list data transaksi terakhir berdasarkan id bulan
        List<TransaksiEntity> totalTrx = transaksiRepository.findAllByBulan(getBulan.getId_bulan());
        int total_transaksi = 0;
        // looping transaksi terakhirr untuk mencari total transaksi per bulan
        for (TransaksiEntity trx : totalTrx) {
            total_transaksi += trx.getTotal_harga();
        }

        TotalBulananEntity newBulanan = new TotalBulananEntity();
        newBulanan.setId_bulan(getBulan.getId_bulan());
        newBulanan.setBulan(getBulan.getBulan());
        newBulanan.setTotal_transaksi(total_transaksi);
        // buat objek baru total bulanan serta set isinya
        totalBulananRepository.save(newBulanan);

        return ResponseEntity.ok().body("Transaksi berhasill");
    }

}
