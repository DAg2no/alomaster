package com.principal.alomaster.models;


import com.principal.alomaster.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Worker")
@PrimaryKeyJoinColumn(name = "user_id")
public class Worker extends User {

    private byte[] fotoCarnetFrontal;

    private byte[] fotoCarnetTrasero;

    private byte[] certificadoAntecedentes;

    private byte[] certificaciónTrabajoMaestranza;
}
