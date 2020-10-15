package com.lab.prueba.service;

import com.lab.prueba.dto.CiudadDto;
import com.lab.prueba.entity.CiudadEntity;

import java.util.List;

public interface ServiceCiudad {
    public List<CiudadDto> consultaCiudades();
    public boolean vaciarCache();
    public CiudadDto crearCiudad(CiudadDto ciudadNueva);
    public List<CiudadDto> borrarCiudadPorPoblacion(int poblacion);
}
