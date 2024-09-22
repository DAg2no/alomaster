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
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;

    private byte[] fotoActualizada;

    private String rut;

    private String dirección;

    private String númeroTeléfono;

    private String correo;

    @Enumerated(EnumType.STRING)
    private Role role;
}
