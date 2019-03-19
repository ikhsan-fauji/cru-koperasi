package com.enigma.koperasi.repository;

import com.enigma.koperasi.entities.AnggotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnggotaRepository extends JpaRepository<AnggotaEntity, Integer> {

    AnggotaEntity findByNama(String nama);

//    AnggotaEntity findByNo_hp(String hp);
}
