package kr.kwangan2.springbootsecurity;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import kr.kwangan2.springbootsecurity.domain.Member;
import kr.kwangan2.springbootsecurity.domain.Role;
import kr.kwangan2.springbootsecurity.repository.MemberRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
public class PasswordEncoderTest {

	@Autowired
	private MemberRepository memberRepo;
	

	@Autowired
	private PasswordEncoder encoder;
	  
	   @Test
	   public void testInsert() {
		   	Member member = new Member("manager2",encoder.encode("manager123"),"매니저2",Role.ROLE_MANAGER,"y");
	      memberRepo.save(member);
	   }


}
