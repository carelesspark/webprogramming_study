package com.springboot.mreview.controller;

import com.springboot.mreview.dto.ReviewDTO;
import com.springboot.mreview.repository.ReviewRepository;
import com.springboot.mreview.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{mno}/all")
    public ResponseEntity<List<ReviewDTO>> getList(@PathVariable("mno") Long mno){
        log.info("---------------------review List");
        log.info(mno);

        List<ReviewDTO> reviewDTOList = reviewService.getListOfMovie(mno);

        return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);
    }

    @PostMapping("/{mno}")
    public ResponseEntity<Long> save(@RequestBody ReviewDTO reviewDTO){
        log.info("save-----------");

        Long reviewnum = reviewService.save(reviewDTO);

        return new ResponseEntity<>(reviewnum, HttpStatus.OK);

    }
}
