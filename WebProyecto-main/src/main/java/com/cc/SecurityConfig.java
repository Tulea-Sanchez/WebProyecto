package com.cc;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("juan")
                    .password("{noop}123")
                    .roles("ADMIN","USER")
                .and()
                .withUser("rebeca")
                    .password("{noop}123")
                    .roles("ADMIN","USER")
                .and()
                .withUser("pedro")
                    .password("{noop}123")
                    .roles("USER")
                .and()
                .withUser("marcos")
                    .password("{noop}123")
                    .roles("ADMIN");
    }
    
}
