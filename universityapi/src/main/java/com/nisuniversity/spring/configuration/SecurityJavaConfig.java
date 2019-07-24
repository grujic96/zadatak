package com.nisuniversity.spring.configuration;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nisuniversity.spring.security.RestAuthEntryPoint;
import com.nisuniversity.spring.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
    @Autowired 
    private RestAuthEntryPoint authenticationEntryPoint;
	
	@Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder);
}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		    .authorizeRequests()
		    .antMatchers("/login").permitAll()
		    .and().httpBasic().realmName("MY APP REALM")
		    .authenticationEntryPoint(authenticationEntryPoint);
	} 
	
	
	
    // Secure the endpoins with HTTP Basic authentication
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//        .authorizeRequests().antMatchers("/").permitAll().and()
//    	.authorizeRequests().antMatchers("/api/college/multiplecollegestudents").authenticated().and()
////        .formLogin().loginProcessingUrl("/login").and()
//        .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
//        .and().csrf().disable();
//      
//    }
//    
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
    /*@Bean
    public UserDetailsService userDetailsService() {
        //ok for demo
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
        return manager;
    }*/

}