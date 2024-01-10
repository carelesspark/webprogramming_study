package com.springboot.board.service;

import com.springboot.board.dto.BoardDTO;
import com.springboot.board.dto.PageRequestDTO;
import com.springboot.board.dto.PageResultDTO;
import com.springboot.board.entity.Board;
import com.springboot.board.entity.Member;
import com.springboot.board.entity.Reply;
import com.springboot.board.repository.BoardRepository;
import com.springboot.board.repository.ReplyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.function.Function;

@Service
@RequiredArgsConstructor // final이 붙어있는 필드에 대해 생성자를 생성
@Log4j2
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;

    @Override
    public Long register(BoardDTO dto) {

        log.info(dto);

        Board board = dtoToEntity(dto);

        boardRepository.save(board);

        return board.getBno();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
        log.info(pageRequestDTO);

        Function<Object[], BoardDTO> fn = ((en) -> entityToDto((Board)en[0], (Member)en[1], (Long)en[2]));

        Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("bno").descending()));

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public BoardDTO get(Long bno) {
        Object result = boardRepository.getBoardByBno(bno);
        Object[] arr = (Object[])result;



        return entityToDto((Board)arr[0], (Member)arr[1], (Long)arr[2]);
    }

    @Transactional
    @Override
    public void removeWithReplies(Long bno) {
        replyRepository.deleteByBno(bno);
        boardRepository.deleteById(bno);
    }

    @Transactional
    @Override
    public void modify(BoardDTO boardDTO) {
        Board board = boardRepository.getOne(boardDTO.getBno());

        if(board != null){
            board.changeTitle(boardDTO.getTitle());
            board.changeContent(boardDTO.getContent());
        }

        boardRepository.save(board);
    }
}
