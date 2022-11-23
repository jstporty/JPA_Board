package kr.kwangan2.springbootboard;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.kwangan2.springbootboard.board.entity.Board;
import kr.kwangan2.springbootboard.board.repository.BoardRepository;
import kr.kwangan2.springbootboard.member.entity.Member;
import kr.kwangan2.springbootboard.member.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataInitializeTest {

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private BoardRepository boardRepo;

	@Test
	public void testDataInsert() {
		Member member1 = new Member();

		member1.setId("member1");
		member1.setName("승현");
		member1.setPassword("member111");
		member1.setRole("ROLE_USER");
		memberRepo.save(member1);

		Member member2 = new Member();
		member2.setId("member2");
		member2.setName("승현이 친구");
		member2.setPassword("member2");
		member2.setRole("ROLE_ADMIN");
		memberRepo.save(member2);

		for (int i = 1; i <= 3; i++) {
			Board board = new Board();

			board.setWriter("승현");
			board.setTitle("승현이가 등록한 게시글" + i);
			board.setContent("승현이가 등록한 게시글 내용" + i);
			boardRepo.save(board);
		}
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			
			board.setWriter("승현이 친구");
			board.setTitle("승현이 친구가 등록한 게시글" + i);
			board.setContent("승현이 친구가 등록한 게시글 내용" + i);
			boardRepo.save(board);
		}
	}

}
