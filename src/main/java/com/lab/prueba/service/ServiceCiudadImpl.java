package com.lab.prueba.service;

import com.lab.prueba.dto.CiudadDto;
import com.lab.prueba.entity.CiudadEntity;
import com.lab.prueba.repository.CiudadEntityRepositorio;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ServiceCiudadImpl implements ServiceCiudad {

    private final CiudadEntityRepositorio repositorio;

    public ServiceCiudadImpl( CiudadEntityRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    @Cacheable(value="prueba")
    public List<CiudadDto> consultaCiudades() {
        log.info("Entro en consultaCiudades : findAll");
        List<CiudadEntity> temp = repositorio.findAll();

        return temp.parallelStream()
                .map(ciudadEntity -> new CiudadDto(ciudadEntity))
                .collect(Collectors.toList());
    }

    @Override
    public CiudadDto crearCiudad(CiudadDto ciudadNueva){
        CiudadDto aux = new CiudadDto();
        log.info("Vamos a insertar : " + ciudadNueva);
        if(ciudadNueva != null){
            CiudadEntity temp = new CiudadEntity(ciudadNueva.getNombre(),ciudadNueva.getPoblacion());
            temp = repositorio.save(temp);
            aux.setNombre(temp.getName());
            aux.setPoblacion(temp.getPopulation());
        }
        return aux;
    }

    @Override
    public List<CiudadDto> borrarCiudadPorPoblacion(int poblacion) {
        log.info("Iniciando delete");
        List<CiudadDto> temp = null;
        if(!repositorio.findByPopulation(poblacion).isEmpty()) {
            log.info("a borrar - poblacion : " + poblacion);
            return repositorio.deleteByPopulation(poblacion)
                    .parallelStream()
                    .map(ciudadEntity -> new CiudadDto(ciudadEntity.getName(), ciudadEntity.getPopulation()))
                    .collect(Collectors.toList());
        }
        return temp;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "prueba")
    })
    public boolean vaciarCache() {
        return true;
    }
}
