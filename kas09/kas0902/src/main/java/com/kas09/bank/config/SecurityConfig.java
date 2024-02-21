package com.kas09.bank.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
        @Bean
        public AuthenticationManager authenticationManager(
        AuthenticationConfiguration authenticationConfiguration)
        throws Exception {return authenticationConfiguration.getAuthenticationManager();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }


        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.headers(headersConfigurer -> headersConfigurer
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
                http.authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/cuentas/list", "/movimientos/list").permitAll()
                                .requestMatchers("/users/**").hasRole("ADMIN")
                                .requestMatchers("/cuentas/**").hasAnyRole("ADMIN", "OWNER")
                                .requestMatchers("/cuentas/create", "/cuentas/edit", "/cuentas/delete").hasRole("OWNER")
                                .requestMatchers("/movimientos/**").hasAnyRole("ADMIN", "OWNER", "USER")
                                .requestMatchers("/movimientos/create", "/movimientos/edit", "/movimientos/delete").hasAnyRole("ADMIN", "OWNER", "USER")
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()       
                                .requestMatchers("/h2-console/**").hasRole("ADMIN")
                                .anyRequest().authenticated())
                        .formLogin(formLogin -> formLogin
                                .defaultSuccessUrl("/cuentas/list", true)
                                .permitAll())
                        .logout(logout -> logout
                                .permitAll())
                        // .csrf(csrf -> csrf.disable())
                        .httpBasic(Customizer.withDefaults());
                http.exceptionHandling(exceptions -> exceptions.accessDeniedPage("/accessError"));
                return http.build();
            }
}