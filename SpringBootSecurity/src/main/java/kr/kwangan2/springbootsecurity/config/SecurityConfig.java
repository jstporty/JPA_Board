package kr.kwangan2.springbootsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private kr.kwangan2.springbootsecurity.service.impl.BoardUserDetailsService boardUserDetailsService;

	@Override
	protected void configure(HttpSecurity security) throws Exception {

		security.authorizeRequests().antMatchers("/").permitAll();
		security.authorizeRequests().antMatchers("/member").authenticated();
		security.authorizeRequests().antMatchers("/manager").hasRole("MANAGER");
		security.authorizeRequests().antMatchers("/admin").hasRole("ADMIN");
		security.exceptionHandling().accessDeniedPage("/accessDenined");
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");

		security.userDetailsService(boardUserDetailsService);
		security.csrf().disable();
		security.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}