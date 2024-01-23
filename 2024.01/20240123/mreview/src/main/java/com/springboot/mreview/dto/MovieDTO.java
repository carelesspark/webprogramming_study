package com.springboot.mreview.dto;

import com.springboot.mreview.entity.MovieImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Long mno;
    private String title;

    @Builder.Default
    private List<MovieImageDTO> imageDTOList = new ArrayList<>();

    // 평점
    private double avg;

    // 리뷰
    private int reviewCnt;

    private LocalDateTime regDate;

    private LocalDateTime modDate;


}
