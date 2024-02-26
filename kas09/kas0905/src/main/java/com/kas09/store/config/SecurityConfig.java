package com.kas09.store.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
@EnableWebMvc
@EnableMethodSecurity
public class SecurityConfig {
        @Bean
        public AuthenticationManager authenticationManager(
                        AuthenticationConfiguration authenticationConfiguration)
                        throws Exception {
                return authenticationConfiguration.getAuthenticationManager();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.headers(headersConfigurer -> headersConfigurer
                                .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
                http.authorizeHttpRequests(auth -> auth
                                .requestMatchers("/public/**", "/registro/nuevo", "/registro/nuevo/submit").permitAll()
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                .requestMatchers("/valoraciones/list/**", "/valoraciones/new/**", "/valoraciones/producto/**", "/valoraciones/usuario/**").hasAnyRole("USER", "ADMIN", "MANAGER")
                                .requestMatchers("/productos/**", "/categorias/**", "/valoraciones/**").hasAnyRole("ADMIN", "MANAGER")
                                .requestMatchers("/usuarios/**").hasRole("ADMIN")
                                .requestMatchers("/h2-console/**").hasRole("ADMIN")
                                .anyRequest().authenticated())
                                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer
                                                .loginPage("/login") // mapping par mostrar formulario de login
                                                .loginProcessingUrl("/login")
                                                .failureUrl("/login?error") // vuelve a signin con mensaje de error
                                                .defaultSuccessUrl("/public/home", true).permitAll())
                                                .rememberMe(Customizer.withDefaults())
                                .logout((logout) -> logout
                                                .logoutSuccessUrl("/public/home").permitAll())
                                // .csrf(csrf -> csrf.disable())
                                .httpBasic(Customizer.withDefaults());
                http.exceptionHandling(exceptions -> exceptions.accessDeniedPage("/errorPage"));
                return http.build();
        }
}