package com.valtech.training.firstspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.valtech.training.firstspringboot.component.Arithmetic;
import com.valtech.training.firstspringboot.component.ArithmeticImpl;
import com.valtech.training.firstspringboot.component.HelloWorld;
import com.valtech.training.firstspringboot.component.SimpleInterest;
import com.valtech.training.firstspringboot.component.SimpleInterestImpl;

@Configuration
public class SecurityConfig {
   
//	@Bean
//	public Arithmetic arithmetic() {
//		return new  ArithmeticImpl();
//	}
//	@Bean
//	public SimpleInterest simpleInterst(Arithmetic a) {
//		return new SimpleInterestImpl(a);
//	}
	
	@Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	httpSecurity.csrf().disable().authorizeRequests().antMatchers("/user","/orders/**","/hello","/changePassword")
	.hasAnyRole("USER","ADMIN").antMatchers("/admin")
	.hasRole("ADMIN").antMatchers("/anon","/login","/logout","/register").anonymous().
	anyRequest().authenticated();
		
	//httpSecurity.httpBasic();
	httpSecurity.formLogin().loginPage("/login").defaultSuccessUrl("/hello?name=valtech")
	.failureUrl("/login?error=true");
			return httpSecurity.build();
		
	}
//	@Bean
//	public UserDetailsManager userDetailsManager() {
//		UserDetails root= User.builder().username("root").password("root").roles("USER").build();
//		UserDetails admin=User.builder().username("admin").password("admin").roles("ADMIN","USER").build();
//		return new InMemoryUserDetailsManager(root,admin);
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		//return NoOpPasswordEncoder.getInstance();
	return new BCryptPasswordEncoder();
	}
	
}
