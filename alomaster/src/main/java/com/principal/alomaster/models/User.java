package com.principal.alomaster.models;


import com.principal.alomaster.annotations.PasswordMatches;
import com.principal.alomaster.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


@Entity(name = "UserCustom")
@Table(name = "User", uniqueConstraints = @UniqueConstraint(columnNames = "rut"))
@Inheritance(strategy = InheritanceType.JOINED)
@PasswordMatches
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nombre completo es requerido")
    private String nombreCompleto;

    private byte[] fotoActualizada;

    @NotBlank(message = "RUT es requerido")
    @Column(unique = true)
    private String rut;

    @NotBlank(message = "Dirección es requerida")
    private String direccion;

    @NotBlank(message = "Número de teléfono es requerido")
    private String numeroTelefono;

    @Email(message = "Correo electrónico no es válido")
    @NotBlank(message = "Correo electrónico es requerido")
    private String correo;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Rol es requerido")
    private Role role;

    @NotBlank(message = "Contraseña es requerida")
    private String password;

    @Transient
    private String passwordConfirm;

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @NotBlank(message = "Nombre de usuario es requerido")
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public byte[] getFotoActualizada() {
        return fotoActualizada;
    }

    public void setFotoActualizada(byte[] fotoActualizada) {
        this.fotoActualizada = fotoActualizada;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(Long id, String nombreCompleto, byte[] fotoActualizada, String rut, String direccion, String numeroTelefono, String correo, Role role, String password, String username) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.fotoActualizada = fotoActualizada;
        this.rut = rut;
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.role = role;
        this.password = password;
        this.username = username;
    }

    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(getRole().name()));
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