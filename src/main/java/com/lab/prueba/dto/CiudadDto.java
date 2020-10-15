package com.lab.prueba.dto;

import com.lab.prueba.entity.CiudadEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CiudadDto implements Serializable {
    private String nombre;
    private int poblacion;

    public CiudadDto(CiudadEntity ciudadEntity){
        this.setNombre(ciudadEntity.getName());
        this.setPoblacion(ciudadEntity.getPopulation());
    }
}
