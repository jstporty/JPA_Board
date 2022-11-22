package kr.kwangan2.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.kwangan2.test.domain.Person;

@Controller
public class PersonController2 {

	@GetMapping("/getViewName")
	public String getViewName() {
		return "testView";

	}

	@GetMapping("/getViewName2")
	public void getViewName2() {
	}

	@GetMapping("/getRedirectURL")
	public String getRedirectURL() {
		return "redirect:/";
	}

	@GetMapping("/getModel")
	public void getModel(Model model) {
		model.addAttribute("name", "YEO");
	}

}
