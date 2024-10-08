package com.principal.alomaster.services;

import com.principal.alomaster.enums.Role;
import com.principal.alomaster.models.User;
import com.principal.alomaster.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        System.out.println("guardando");
        // Codifica la contraseña
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Si el rol no está configurado, se asigna GUEST por defecto
        if (user.getRole() == null) {
            user.setRole(Role.GUEST);
        }

        // Guarda el usuario en el repositorio

        userRepository.save(user);
    }
}
