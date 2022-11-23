package kr.kwangan2.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/loginSuccess")
	public String loginSuccess() {
		return "loginSuccess";
	}

	@GetMapping("/accessDenined")
	public String accessDenined() {
		return "accessDenined";
	}

	@GetMapping("/")
	public String index() {
		System.out.println("index 요청");
		return "index";
	}

	@RequestMapping("/member")
	public String forMember() {
		System.out.println("member 요청");
		return "member";
	}

	@RequestMapping("/manager")
	public String forManager() {
		System.out.println("Manager 요청");
		return "manager";
	}

	@RequestMapping("/admin")
	public String forAdmin() {
		System.out.println("Admin 요청");
		return "admin";
	}
}