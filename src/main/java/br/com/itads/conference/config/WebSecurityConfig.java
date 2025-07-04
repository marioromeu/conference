package br.com.itads.conference.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import br.com.itads.conference.controller.filter.MyAuthFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	 @Bean
	 protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
	     http.csrf( (csrf) -> {
	    	 csrf.disable();
	     })  .authorizeHttpRequests((requests) -> {
	         requests
	             .requestMatchers("/swagger-ui/*").permitAll()
	             .requestMatchers("/v3/api-docs/*").permitAll()
	             .requestMatchers("/v3/api-docs").permitAll()
	             .requestMatchers("/actuator/*").permitAll()	             
	             .anyRequest().authenticated();
	     }).addFilterBefore(
	    		 new MyAuthFilter(),
	    		 org.springframework.security.web.authentication.AuthenticationFilter.class
	     );
	     
	     return http.build();
	     
	 }
}
