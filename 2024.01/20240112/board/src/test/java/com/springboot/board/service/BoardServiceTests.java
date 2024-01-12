package com.springboot.board.service;

import com.springboot.board.dto.BoardDTO;
import com.springboot.board.dto.PageRequestDTO;
import com.springboot.board.dto.PageResultDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){
        BoardDTO dto = BoardDTO
                .builder()
                .title("Test")
                .content("Test...")
                .writerEmail("user3333@naver.com")
                .build();

        Long bno = boardService.register(dto);
    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        // System.out.println(result.getDtoList());
        for(BoardDTO boardDTO : result.getDtoList()){
            System.out.println(boardDTO);
        }
    }

    @Test
    public void testGet(){

        BoardDTO result = boardService.get(100L);
        System.out.println(result);
    }

    @Test
    public void testRemove(){
        boardService.removeWithReplies(1L);
        System.out.println("1번 BNO 글이 삭제 되었습니다.");
    }

    @Test
    public void testModify(){
        BoardDTO boardDTO = BoardDTO.builder()
                .title("제목 변경합니다")
                .content("내용 변경합니다")
                        .bno(2L).build();
        boardService.modify(boardDTO);
        System.out.println("2번 BNO 글이 수정 되었습니다.");
    }

}
