package com.principal.alomaster.models;



import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Worker")
@PrimaryKeyJoinColumn(name = "user_id")
public class Worker extends User {
    
    @NotNull(message = "Foto carnet frontal es requerida")
    private String fotoCarnetFrontal;

    @NotNull(message = "Foto carnet trasero es requerida")
    private String fotoCarnetTrasero;
    
    @NotNull(message = "Certificado de antecedentes es requerido")
 
    private String certificadoAntecedentes;

    @NotNull(message = "Certificación de trabajo maestranza es requerida")
    
    private String certificacionTrabajoMaestranza;
}
