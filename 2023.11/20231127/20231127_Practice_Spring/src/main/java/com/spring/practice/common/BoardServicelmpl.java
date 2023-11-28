package com.spring.practice.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.board.BoardService;
import com.spring.practice.board.BoardVO;
import com.spring.practice.board.impl.BoardDAO;

@Service("boardService")
public class BoardServicelmpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	

	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.insertBoard(vo);

	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList();
	}

}
