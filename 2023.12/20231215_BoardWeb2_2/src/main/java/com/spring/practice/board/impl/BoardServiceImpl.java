package com.spring.practice.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.board.BoardService;
import com.spring.practice.board.BoardVO;
import com.spring.practice.board.impl.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	//private BoardDAOSpring boardDAO;
	private BoardDAO boardDAO; // <- 이 코드는 전 BoardDAO사용할 때 필요
	
//	private LogAdvice log;
//	private Log4jAdvice log; // applicationContext.xml에서 공통관심사로 등록했을 때, 이 코드를 작성할 필요가 없음

//	public BoardServicelmpl() { // POJO방식
//		log = new LogAdvice(); 
//		log = new Log4jAdvice();
//	}

	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		// log.printLog();
		// log.printLogging();
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		// log.printLog();
		// log.printLogging();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// log.printLog();
		// log.printLogging();
		 boardDAO.deleteBoard(vo);
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		// log.printLog();
		// log.printLogging();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		// TODO Auto-generated method stub
		// log.printLog();
		// log.printLogging();
		return boardDAO.getBoardList(vo);
	}

}
