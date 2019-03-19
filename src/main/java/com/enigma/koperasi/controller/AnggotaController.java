package com.enigma.koperasi.controller;

import com.enigma.koperasi.entities.AnggotaEntity;
import com.enigma.koperasi.repository.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@EnableWebMvc
@RestController
@RequestMapping(path = "koperasi")
public class AnggotaController {

    @Autowired
    AnggotaRepository anggotaRepository;

    // get all anggota
    @GetMapping(path = "/anggota")
    @ResponseBody
    public List<AnggotaEntity> getAllAnggota(){
        return anggotaRepository.findAll();
    }

    // input anggota
    @PostMapping(path = "/anggota/add")
    @ResponseBody
    public AnggotaEntity addAnggota(@Valid @RequestBody AnggotaEntity anggota){
        return anggotaRepository.save(anggota);
    }

    // update anggota
    @PutMapping(path = "/anggota/edit/{id}")
    @ResponseBody
    public String editAnggota(@PathVariable(value = "id") Integer id, @RequestBody AnggotaEntity anggota){
        Optional<AnggotaEntity> cekAnggota = anggotaRepository.findById(id);
        if (cekAnggota.isPresent()){
            AnggotaEntity newAnggota = new AnggotaEntity();
            newAnggota.setId_anggota(id);
            newAnggota.setNama(anggota.getNama());
            newAnggota.setNo_hp(anggota.getNo_hp());
            anggotaRepository.save(newAnggota);

            return "Update berhasil";
        } else  {
            return "Update gagal";
        }
    }
}
