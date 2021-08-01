package com.mackittipat.keycloak.clientcredential.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .authorizeRequests()
                .mvcMatchers("/public/**").permitAll()
                .mvcMatchers("/private/**").authenticated()
                .and()
                .oauth2ResourceServer().jwt();
    }
}
