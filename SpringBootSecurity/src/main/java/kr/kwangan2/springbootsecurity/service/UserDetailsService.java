package kr.kwangan2.springbootsecurity.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {

	
	UserDetails loadUsername(String username) throws UsernameNotFoundException;
}
