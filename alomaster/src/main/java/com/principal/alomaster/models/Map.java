package com.principal.alomaster.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Map {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    private Long id; // id

    private String latitude;
    private String longitude;

}
