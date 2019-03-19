package com.enigma.koperasi.controller;

import com.enigma.koperasi.entities.AnggotaEntity;
import com.enigma.koperasi.entities.BarangEntity;
import com.enigma.koperasi.repository.AnggotaRepository;
import com.enigma.koperasi.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@EnableWebMvc
@RestController
@RequestMapping(path = "/koperasi")
public class BarangController {

    @Autowired
    BarangRepository barangRepository;

    // get all barang
    @GetMapping(path = "/barang", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<BarangEntity> getAllBarang(){
        return barangRepository.findAll();
    }

    // input barang
    @PostMapping(path = "/barang/add")
    @ResponseBody
    public BarangEntity addbarang(@Valid @RequestBody BarangEntity barang){
        return barangRepository.save(barang);
    }

    // update barang
    @PutMapping(path = "/barang/edit/{id}")
    @ResponseBody
    public String editAnggota(@PathVariable(value = "id") Integer id, @RequestBody BarangEntity barang){
        Optional<BarangEntity> cekBarang = barangRepository.findById(id);
        if (cekBarang.isPresent()){
            BarangEntity newBarang = new BarangEntity();
            newBarang.setId_barang(id);
            newBarang.setNamaBarang(barang.getNamaBarang());
            newBarang.setHarga(barang.getHarga());
            barangRepository.save(newBarang);

            return "Update barang berhasil";
        } else  {
            return "Update barang gagal";
        }
    }
}
