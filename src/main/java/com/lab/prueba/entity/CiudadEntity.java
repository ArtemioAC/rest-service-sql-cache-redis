package com.lab.prueba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CiudadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    @Basic
    @Column(name = "Name")
    private String name;

//    @Basic
//    @Column(name = "CountryCode")
//    private String CountryCode;
//    @Basic
//    @Column(name = "District")
//    private String District;
    @Basic
    @Column(name = "Population")
    private int population;

    public CiudadEntity(String name, int population){
        this.name = name;
        this.population = population;
    }
}

