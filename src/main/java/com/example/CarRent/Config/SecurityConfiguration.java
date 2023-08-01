package com.example.CarRent.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public static PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests( (requests) -> requests
                        .requestMatchers("/bootstrap/**").permitAll()
                        .requestMatchers(toH2Console()).permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/registration/**").permitAll()
                        .requestMatchers("/access-denied").permitAll()
                        .requestMatchers("/logout").permitAll()
                        .requestMatchers("/index").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/cars").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/submitCar").hasAnyRole( "ADMIN")
                        .requestMatchers("/registerCar").hasAnyRole( "ADMIN")
                        .requestMatchers("/editCar").hasAnyRole( "ADMIN")
                        .requestMatchers("/deleteCar").hasAnyRole( "ADMIN")
                        .requestMatchers("/customers").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/submitCustomer").hasAnyRole("ADMIN")
                        .requestMatchers("/registerCustomer").hasAnyRole("ADMIN")
                        .requestMatchers("/editCustomer").hasAnyRole("ADMIN")
                        .requestMatchers("/deleteCustomer").hasAnyRole("ADMIN")
                        .requestMatchers("/searchCustomer").hasAnyRole("ADMIN")
                        .requestMatchers("/reservationForm").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/submitReservation").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated()
                )
                .headers(headers ->headers.frameOptions().disable())
                .csrf(csrf -> csrf.ignoringRequestMatchers(toH2Console()))
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/index")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll())
                .exceptionHandling().accessDeniedPage("/access-denied");
        return httpSecurity.build();
    }
}
