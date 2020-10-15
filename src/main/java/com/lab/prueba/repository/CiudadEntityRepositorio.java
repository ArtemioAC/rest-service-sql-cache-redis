package com.lab.prueba.repository;

import com.lab.prueba.dto.CiudadDto;
import com.lab.prueba.entity.CiudadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CiudadEntityRepositorio extends JpaRepository<CiudadEntity, Long> {
    List<CiudadEntity> findAll();
    CiudadEntity save(CiudadEntity ciudadaNueva);
    List<CiudadEntity> findByPopulation(int poblacion);
    @Transactional
    List<CiudadEntity> deleteByPopulation(int poblacion);

}