package kr.kwangan2.springbootboard.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kwangan2.springbootboard.board.entity.Board;
import kr.kwangan2.springbootboard.board.repository.BoardRepository;
import kr.kwangan2.springbootboard.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Override
	public List<Board> listBoard(Board board) {
		return (List<Board>) boardRepository.findAll();
	}

	@Override
	   public Board getBoard(Board board) {
	      Board findBoard = boardRepository.findById(board.getSeq()).get();
	     
	      findBoard.setCnt(findBoard.getCnt()+1);
	      
	      boardRepository.save(findBoard);
	      
	      
	      return boardRepository.findById(findBoard.getSeq()).get();
	   }

	@Override
	public void insertBoard(Board board) {
		boardRepository.save(board);
	}

	@Override
	public void updateBoard(Board board) {
		
		Board findboad= boardRepository.findById(board.getSeq()).get();
		
		findboad.setTitle(board.getTitle());
		findboad.setContent(board.getContent());
		boardRepository.save(findboad);
	}

	@Override
	public void deleteBoard(Board board) {
		
		boardRepository.delete(board);
		//boardRepository.deleteById(board.getSeq());
		
	}

}
