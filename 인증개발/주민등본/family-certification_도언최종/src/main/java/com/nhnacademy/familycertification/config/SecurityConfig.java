package com.nhnacademy.familycertification.config;

import com.nhnacademy.familycertification.auth.CustomLoginSuccessHandler;
import com.nhnacademy.familycertification.auth.OauthLoginHandler;
import com.nhnacademy.familycertification.service.CustomUserDetailsService;
import com.nhnacademy.familycertification.service.PrincipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig {

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

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
            .oauth2Login()
                .clientRegistrationRepository(clientRegistrationRepository())
                .authorizedClientService(authorizedClientService())
                .successHandler(new OauthLoginHandler())
                .authorizationEndpoint()
                    .baseUri("/login")
                    .and()
                .userInfoEndpoint()
                    .userService(principalOauth2UserService)
                    .and()
                .permitAll()
                .and()
            .formLogin()
                .usernameParameter("id")
                .passwordParameter("pwd")
                //인증이 필요한 url에 접근하면 /userLogin으로 이동
                .loginPage("/userLogin")
                //form action url (form action="/userLogin")
                .loginProcessingUrl("/userLogin")
                .successHandler(new CustomLoginSuccessHandler())
                // 로그인 url에 접근권한 승인??
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
        //custom user details를 이용해 권한 부여
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        // bcrypt password encoder를 이용해 비밀번호 해시함수화
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    //clientRepository를 github로 설정
    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(github());
    }

    @Bean
    public OAuth2AuthorizedClientService authorizedClientService() {
        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
    }

    //password 해시함수 -> bcrypt이용
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    private ClientRegistration github() {
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .userNameAttributeName("name")
                .clientId("d3ca66456add6ffa223e")
                .clientSecret("a1068e9f514c4d8f578648755bb47e344d8858ab")
                .build();
    }
}
