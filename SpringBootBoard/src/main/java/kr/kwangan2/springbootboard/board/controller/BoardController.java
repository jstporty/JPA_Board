package kr.kwangan2.springbootboard.board.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.kwangan2.springbootboard.board.entity.Board;
import kr.kwangan2.springbootboard.board.service.BoardService;
import kr.kwangan2.springbootboard.member.entity.Member;

@SessionAttributes("member")
@Controller
@RequestMapping("/board")
public class BoardController {

	
	
	@Autowired
	private BoardService boardService;

	@RequestMapping("/listBoard")
	public String listBoard(@ModelAttribute("member") Member member, Model model, Board board) {

		if (member.getId() == null) {

			return "redirect:/member/login";
		}

		List<Board> boardList = boardService.listBoard(board);
		model.addAttribute("boardList", boardList);
		return "/board/listBoard";

	}

	@GetMapping("/insertBoard")
	public String insertBoardView(@ModelAttribute("member") Member member) {
		if (member.getId() == null) {

			return "redirect:/member/login";
		}
		return "/board/insertBoard";
	}

	@PostMapping("/insertBoardProc")
	public String insertBoardProc(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null) {

			return "redirect:/member/login";
		}
		boardService.insertBoard(board);

		return "redirect:/board/listBoard";

	}

	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("member") Member member, Board board, Model model, String action) {
		model.addAttribute("board", boardService.getBoard(board));
		if (member.getId() == null) {

			return "redirect:/member/login";
		}
		return "/board/getBoard";
	}

	@PostMapping("/updateBoardProc")
	public String updateBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null) {

			return "redirect:/member/login";
		}
		boardService.updateBoard(board);

		return "redirect:/board/listBoard";

	}

	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "redirect:/board/listBoard";

	}

	@GetMapping("/hello")
	public String hello(@ModelAttribute("member") Member member, Model model) {
		model.addAttribute("greeting", "hello thymeleaf!!!!!!!!!!!!!!!");
		if (member.getId() == null) {

			return "redirect:/member/login";
		}
		return "/board/hello";
	}

	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}

}
