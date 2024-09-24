package com.principal.alomaster.models;

import com.principal.alomaster.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
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
    
    private String password;
    private String username;
}