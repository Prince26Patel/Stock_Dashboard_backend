package com.example.stock_tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, WebMvcConfigurer webMvcConfigurer) throws Exception {
        http
            .cors(cors -> cors.configurationSource(request -> webMvcConfigurer)) // Use the existing CORS configuration from CorsConfig
            .csrf(csrf -> csrf.disable()) // Disable CSRF for APIs (not recommended for production with stateful sessions)
            .authorizeRequests(auth -> auth
                .anyRequest().permitAll() // Allow all requests without authentication
            );
        return http.build();
    }
}
