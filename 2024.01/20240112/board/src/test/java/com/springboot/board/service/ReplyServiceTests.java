package com.springboot.board.service;

import com.springboot.board.dto.ReplyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ReplyServiceTests {

    @Autowired
    private ReplyService replyService;

    @Test
    public void testGetList(){
       List<ReplyDTO> result = replyService.getList(95L);
       result.forEach(replyDTO -> System.out.println(replyDTO));
    }
}
