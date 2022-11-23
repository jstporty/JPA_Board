package kr.kwangan2.springbootsecurity.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import kr.kwangan2.springbootsecurity.domain.Member;

public class SecurityUser extends User  {


	public SecurityUser(Member member) {
		super(member.getId(),   member.getPassword(),
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}

}
