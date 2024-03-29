package com.training.interactivemap.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableOAuth2Sso
@Configuration
public class OAuth2Configuration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/interactive-map/home", "/interactive-map/showRange",
                        "/interactive-map/properties/page={page}", "/interactive-map/range/page={page}",
                        "/pictures/picture/{id}", "/interactive-map/loginPage", "/login", "/webjars/**", "/error**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}