package com.principal.alomaster.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Map {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    private Long id; // id

    private String latitude;
    private String longitude;

}
