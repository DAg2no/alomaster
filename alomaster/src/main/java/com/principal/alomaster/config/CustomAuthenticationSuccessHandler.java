package com.principal.alomaster.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // Verifica los roles del usuario autenticado y redirige según el rol
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_WORKER"))) {
            response.sendRedirect("/worker/home");
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
            response.sendRedirect("/client/home");
        } else {
            response.sendRedirect("/auth"); // Por defecto, si no tiene un rol específico
        }
    }
}
