package com.springboot.board.controller;

import com.springboot.board.dto.ReplyDTO;
import com.springboot.board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/replies")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;
    
    // 특정 댓글 조회
    // localhost:8000/replies/board?bno=99 @RequestParam
    // localhost:8000/replies/board/99     @PathVariable
    @GetMapping(value = "/board/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReplyDTO>> getListByBoard(@PathVariable("bno") Long bno){
        log.info("bno..." + bno);

        List<ReplyDTO> list = replyService.getList(bno);

        return new ResponseEntity(list, HttpStatus.OK);
    }

    // 댓글 등록
    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody ReplyDTO replyDTO){
        log.info("replyDTO : " + replyDTO);

        Long rno = replyService.register(replyDTO);

        return new ResponseEntity<>(rno, HttpStatus.OK);
    }

    // 댓글 수정
    @PutMapping("/{rno}")
    public ResponseEntity<String> modify(@RequestBody ReplyDTO replyDTO){
        log.info(replyDTO);

        replyService.modify(replyDTO);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    
    // 댓글 삭제
    @DeleteMapping("/{rno}")
    public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
        log.info("rno..." + rno);
        replyService.remove(rno);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
