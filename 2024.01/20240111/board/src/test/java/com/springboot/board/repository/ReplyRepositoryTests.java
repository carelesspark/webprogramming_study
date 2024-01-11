package com.springboot.board.repository;

import com.springboot.board.entity.Board;
import com.springboot.board.entity.Reply;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertReply(){
        IntStream.rangeClosed(1,300).forEach(i -> {
            long bno = (long)(Math.random() * 100) + 1;

            Board board = Board.builder().bno(bno).build();

            Reply reply = Reply.builder().text("Reply..." + i).board(board).replyer("guest").build();

            replyRepository.save(reply);
        });
    }

    @Transactional
    @Test
    public void readReply1(){
        Optional<Reply> result = replyRepository.findById(100L);

        Reply reply = result.get();

        System.out.println(reply);
        System.out.println(reply.getBoard());
    }
}
