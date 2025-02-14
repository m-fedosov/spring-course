package dev.fedosov.springcourse.Project2Boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebAuthenticationConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(c -> c
                        .requestMatchers("/books").permitAll() // только общий список книг
                        .requestMatchers("/people").permitAll() // только общий список читателей
                        .anyRequest().authenticated()
                )
                .formLogin(
                        c -> c
                                .loginPage("/auth/login").permitAll()
                )
                .build();
    }
}
