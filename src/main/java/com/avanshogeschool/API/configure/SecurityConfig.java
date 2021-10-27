package com.avanshogeschool.API.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        //Needed Spring Security for hashing passwords, but we don't need our API requests
        // to be secured so this disables the security
        http.authorizeRequests().antMatchers("/").permitAll();
        http.csrf().disable();
    }
}
