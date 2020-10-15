package com.lab.prueba.controller;

import com.lab.prueba.dto.CiudadDto;
import com.lab.prueba.entity.CiudadEntity;
import com.lab.prueba.service.ServiceCiudad;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
//@RequestMapping("v1")
public class DataServiceController {

    /* Para probar que se construyó bien el proyecto
    @GetMapping("/saludo")
    public String respuestaController(){
        return new String("esto es un saludo");
    }
     */

    private ServiceCiudad serviceCiudad;

    public DataServiceController( ServiceCiudad serviceCiudad){
        this.serviceCiudad = serviceCiudad;
    }


    @GetMapping("/ciudades")
    public List<CiudadDto> consultaCiudades(){
        return serviceCiudad.consultaCiudades();
    }

    @DeleteMapping("/ciudades/cleanCache")
    public boolean vaciarRedisCache(){
        return serviceCiudad.vaciarCache();
    }

    @PostMapping(value = "/ciudades/create", consumes = "application/json", produces = "application/json")
    public CiudadDto crearCiudad( @RequestBody CiudadDto ciudadNueva){
        vaciarRedisCache();
        return serviceCiudad.crearCiudad(ciudadNueva);
    }

    @DeleteMapping(value = "/ciudades/delete", consumes = "application/json")
    public List<CiudadDto> borrarCiudadPorPoblacion(@RequestBody CiudadDto ciudad){
        log.info("A borrar ----- : ", ciudad);
        vaciarRedisCache();
        return serviceCiudad.borrarCiudadPorPoblacion(ciudad.getPoblacion());
    }
}
