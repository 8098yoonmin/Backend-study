package com.nhnacademy.remind.config;

import com.nhnacademy.remind.auth.CustomLoginSuccessHandler;
import com.nhnacademy.remind.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity(debug=true)
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                .requestMatchers("/myPage/**").authenticated()
                .requestMatchers("/birth/**").authenticated()
                .requestMatchers("/family/**").authenticated()
                .requestMatchers("/death/**").authenticated()
                .requestMatchers("/index").authenticated()
                .requestMatchers("/oauth").authenticated()
                .requestMatchers("/redirect-index").authenticated()
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .usernameParameter("id")
                .passwordParameter("pwd")
                .loginPage("/userLogin")
                .loginProcessingUrl("/userLogin")
                .successHandler(new CustomLoginSuccessHandler())
                .permitAll()
                .and()
            .logout()
                .invalidateHttpSession(true)
                .deleteCookies("SESSION")
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .csrf()
                .disable()
//                .and()
            .sessionManagement()
                .sessionFixation()
                .none()
                .and()
            .headers()
                .defaultsDisabled()
                .frameOptions().sameOrigin()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/error/403")
                .and()
            .build();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider(CustomUserDetailsService customUserDetailsService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
