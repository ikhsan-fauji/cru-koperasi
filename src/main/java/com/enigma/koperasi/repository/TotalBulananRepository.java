package com.enigma.koperasi.repository;

import com.enigma.koperasi.entities.TotalBulananEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalBulananRepository extends JpaRepository<TotalBulananEntity, Integer> {
    TotalBulananEntity findByBulan(String bulan);
}
