package com.principal.alomaster.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/registro").permitAll()
                .requestMatchers("/invitado/**").hasRole("GUEST")
                .requestMatchers("/vendedor/**").hasRole("WORKER")
                .requestMatchers("/cliente/**").hasRole("CLIENT")
                .anyRequest().authenticated()
        );

        http.formLogin(
                form -> form
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/registro")
                        .failureUrl("/login?error")
        );
        http.httpBasic(
                httpBasic -> httpBasic
                        .realmName("Alomaster")
                        .authenticationEntryPoint((request, response, authException) -> response.sendRedirect("/login?error"))
        );
        http.csrf( csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Implementación de UserDetailsService
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}