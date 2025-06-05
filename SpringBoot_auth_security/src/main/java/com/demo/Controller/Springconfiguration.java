package com.demo.Controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Springconfiguration {
	@Autowired
	private DataSource datasource;
//authenticate users by using database,we will get to know the users detailes from the databace
	//By using the datasource we will get the db detailes 
	@Autowired
	public void authManager(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasource).passwordEncoder(new BCryptPasswordEncoder())
				.usersByUsernameQuery("SELECT username,password,enabled FROM users WHERE  username=?")
				.authoritiesByUsernameQuery("SELECT username,authority FROM authorities WHERE username=?");

	}
	//authorize will happend using below code ,to whom we will allow will writen below 
	@Bean
	 SecurityFilterChain securityConfig(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests((req)->req
				.requestMatchers("/").permitAll()
				.requestMatchers("/admin").hasAnyRole("ADMIN")
				.requestMatchers("/user").hasAnyRole("ADMIN","USER")
				.anyRequest().authenticated()).formLogin(Customizer.withDefaults());
		return  http.build();
	}
}
