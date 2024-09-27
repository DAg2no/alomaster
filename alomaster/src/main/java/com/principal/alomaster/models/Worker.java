package com.principal.alomaster.models;

import com.principal.alomaster.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Worker")
@PrimaryKeyJoinColumn(name = "user_id")
public class Worker extends User {
    @NotNull(message = "Foto carnet frontal es requerida")
    private byte[] fotoCarnetFrontal;

    @NotNull(message = "Foto carnet trasero es requerida")
    private byte[] fotoCarnetTrasero;

    @NotNull(message = "Certificado de antecedentes es requerido")
    private byte[] certificadoAntecedentes;

    @NotNull(message = "Certificación de trabajo maestranza es requerida")
    private byte[] certificaciónTrabajoMaestranza;
}