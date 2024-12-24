package org.example.petwalk.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // You can use other encoders if necessary
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF protection for stateless APIs (recommended for REST APIs)
                .csrf(csrf -> csrf.disable())
                .authorizeRequests()
                .requestMatchers("/register", "/login", "/user/get-all").permitAll()  // Public endpoints
                .anyRequest().authenticated()  // All other requests require authentication
                .and()
                .formLogin(form -> form.disable())  // Disable form login as it's deprecated
                .httpBasic(httpBasic -> httpBasic.disable());  // Disable HTTP Basic Authentication

        return http.build();
    }
}
