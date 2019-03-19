package com.enigma.koperasi.repository;

import com.enigma.koperasi.entities.TransaksiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaksiRepository extends JpaRepository<TransaksiEntity, Integer> {

    List<TransaksiEntity> findAllByBulan(Integer bulan);

}
