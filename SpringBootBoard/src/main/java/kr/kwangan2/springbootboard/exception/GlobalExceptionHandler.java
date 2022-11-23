package kr.kwangan2.springbootboard.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BoardException.class)
	public String handleCustomExceptioin(BoardException exception, Model model) {

		model.addAttribute("exception",exception	);
		return"/errors/boardError";
	}

	@ExceptionHandler(Exception.class)
	public String handleExceptioin(Exception exception, Model model) {

		model.addAttribute("exception", exception);
		return "/errors/globalError";
	}
}
