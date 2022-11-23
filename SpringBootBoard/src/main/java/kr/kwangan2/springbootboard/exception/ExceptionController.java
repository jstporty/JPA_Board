package kr.kwangan2.springbootboard.exception;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

	@RequestMapping("/errors/boardError")
	public String boardError() {
		throw new BoardNotFoundException("검색된 게시글이 없습니다");
	}

	@RequestMapping("/errors/illegalArgumentError")
	public String ellegalargumentError() {
		throw new IllegalArgumentException("부적절한 인자가 전달 되었습니다");
	}

	@RequestMapping("/errors/sqlError")
	public String sqlRrror() throws SQLException {
		throw new SQLException("SQL 구문에 오류가 있습니다");
	}
	
	@ExceptionHandler(SQLException.class)
	public String numberFormatError(SQLException exception , Model model) {
		model.addAttribute("exception",exception);
		return"/errors/sqlError";
	}
}
