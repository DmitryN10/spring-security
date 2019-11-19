package com.in28minutes.springboot.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Authentication : User --> Roles
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .withUser("USER").password("{noop}password").roles("USER")
                .and()
                .withUser("ADMIN").password("{noop}password").roles("USER", "ADMIN");
    }

    // Authorization : Role -> Access
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests().antMatchers("/students/**")
                .hasRole("USER").antMatchers("/users/**").hasRole("ADMIN")
                .antMatchers("/**").hasRole("ADMIN")
                .and().csrf().disable()
                .formLogin()
                .disable();
    }

    // Secure the endpoins with HTTP Basic authentication
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http
//				//HTTP Basic authentication
//				.httpBasic()
//				.and()
//				.authorizeRequests()
//				.antMatchers(HttpMethod.GET, "/books/**").hasRole("USER")
//				.antMatchers(HttpMethod.POST, "/books").hasRole("ADMIN")
//				.antMatchers(HttpMethod.PUT, "/books/**").hasRole("ADMIN")
//				.antMatchers(HttpMethod.PATCH, "/books/**").hasRole("ADMIN")
//				.antMatchers(HttpMethod.DELETE, "/books/**").hasRole("ADMIN")
//				.and()
//				.csrf().disable()
//				.formLogin().disable();
//	}

}
