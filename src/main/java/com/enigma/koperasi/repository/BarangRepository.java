package com.enigma.koperasi.repository;

import com.enigma.koperasi.entities.BarangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepository extends JpaRepository<BarangEntity, Integer> {

    BarangEntity findByNamaBarang(String namabarang);

}
