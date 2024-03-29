package com.springboot.board.repository;

import com.springboot.board.entity.Board;
import com.springboot.board.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoard(){
        IntStream.rangeClosed(1, 100).forEach(i -> {

            Member member = Member.builder().email("user" + i + i + i + i + "@naver.com").build();

            Board board = Board.builder().title("Title..." + i).content("Content..." + i).writer(member).build();
            boardRepository.save(board);
        });
    }

    @Test
    public void testRead1(){
        Optional<Board> result = boardRepository.findById(100L);

        Board board = result.get();

        System.out.println(board);
        System.out.println(board.getWriter());
    }

    @Test
    public void testReadWithWriter(){
        Object result = boardRepository.getBoardWithWriter(100L);

        Object[] arr = (Object[])result;
        System.out.println("-------------------------------------------------");
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

    @Test
    public void testGetBoardWithReply(){
        List<Object[]> result = boardRepository.getBoardWithReply(100L);

/*        Object[] arr = result.get(0);
        System.out.println("--------------------------------------------------------------");
        System.out.println(arr[0]); Board Entity 정보 저장
        System.out.println(arr[1]); Reply Entity 정보 저장*/

        for(Object[] arr : result){
            System.out.println(Arrays.toString(arr));
        }
    }

    @Test
    public void testWithReplyCount(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageable);


        result.get().forEach(row -> {
            Object[] arr = (Object[])row;
            System.out.println(Arrays.toString(arr));
        });
    }

    @Test
    public void testRead3(){
        Object result = boardRepository.getBoardByBno(100L);
        Object[] arr = (Object[])result;

        System.out.println(arr[0]); // Board 엔티티 정보 저장
        System.out.println(arr[1]); // Member 엔티티 정보 저장
        System.out.println(arr[2]); // Long 저장
    }

    @Test
    public void testSearch1(){
        boardRepository.search1();
    }

    @Test
    public void testSearchPage(){

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending().and(Sort.by("title").ascending()));
        Page<Object[]> result = boardRepository.searchPage("t", "1", pageable);

        result.get().forEach(row -> {
            Object[] arr = (Object[])row;
            System.out.println(Arrays.toString(arr));
        });
    }
}
