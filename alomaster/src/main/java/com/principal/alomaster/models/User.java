package com.principal.alomaster.models;


import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.principal.alomaster.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User", uniqueConstraints = @UniqueConstraint(columnNames = "rut"))
@Inheritance(strategy = InheritanceType.JOINED)

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nombre completo es requerido")
    private String nombreCompleto;


    @Column(unique = true)
    private int rut;

    @NotBlank(message = "Dirección es requerida")
    private String direccion;

    
    private int numeroTelefono;

    @Email(message = "Correo electrónico no es válido")
    @NotBlank(message = "Correo electrónico es requerido")
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @NotBlank(message = "Contraseña es requerida")
    private String password;

    @Transient
    @NotBlank(message = "Confirmación de contraseña es requerida")
    private String passwordConfirm;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(getRole().name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}