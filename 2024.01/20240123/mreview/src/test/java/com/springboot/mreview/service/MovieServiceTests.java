package com.springboot.mreview.service;

import com.springboot.mreview.dto.MovieDTO;
import com.springboot.mreview.dto.PageRequestDTO;
import com.springboot.mreview.dto.PageResultDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class MovieServiceTests {


    @Autowired
    private MovieService movieService;


    @Test
    public void testSearch(){
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        pageRequestDTO.setPage(1);
        pageRequestDTO.setSize(10);
        pageRequestDTO.setType("t");
        pageRequestDTO.setKeyword("8");

        Pageable pageable = pageRequestDTO.getPageable(Sort.by("mno").descending());

        PageResultDTO<MovieDTO, Object[]> result = movieService.getList(pageRequestDTO);

        /*for(MovieDTO movieDTO : result.getDtoList()){
            System.out.println(movieDTO);
        }*/
    }
}
