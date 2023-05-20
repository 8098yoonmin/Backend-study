package com.nhnacademy.familycertification.config;

import com.nhnacademy.familycertification.auth.LoginSuccessHandler;
import com.nhnacademy.familycertification.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
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
                .requestMatchers("/family/**").hasAnyAuthority("Resident")
                .anyRequest().permitAll()
                .and()
                .requiresChannel()
                .requestMatchers("/family/**").requiresSecure()
                .anyRequest().requiresInsecure()
                .and()
                .formLogin()
                    .usernameParameter("id")
                    .passwordParameter("pwd")
                    .loginPage("/auth/login")
                    .loginProcessingUrl("/login")
                    .successHandler(new LoginSuccessHandler())
                .and()
                .logout()
                .and()
//                member post요청할 때는 없이 build해야함 -> disable() 하고 나서 .and()로 바꿔줌
                .csrf()
                .disable()
//                .and()
                .sessionManagement()
                .sessionFixation()
                .none()
                .and()
                .headers()
                .defaultsDisabled()
                /* TODO #4: 실습 - Security HTTP Response header 중 `X-Frame-Options` 헤더의 값을 SAMEORIGIN으로 설정해주세요. */
                .frameOptions().sameOrigin()
                .and()
                .exceptionHandling()
                /* TODO #9: 실습 - custom 403 에러 페이지(`/error/403`)를 설정해주세요. */
                .accessDeniedPage("/error/403")
                .and()
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(CustomUserDetailsService customUserDetailsService) {
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
