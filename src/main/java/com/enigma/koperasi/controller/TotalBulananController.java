package com.enigma.koperasi.controller;

import com.enigma.koperasi.entities.TotalBulananEntity;
import com.enigma.koperasi.repository.TotalBulananRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableWebMvc
@RestController
@RequestMapping(path = "koperasi/total-bulanan")
public class TotalBulananController {

    @Autowired
    private TotalBulananRepository totalBulananRepository;

    // get list bulanan
    @GetMapping(path = "")
    public List<TotalBulananEntity> getListBulanan(){
        return totalBulananRepository.findAll();
    }

}
