package com.springboot.mreview.service;

import com.springboot.mreview.dto.ReviewDTO;
import com.springboot.mreview.entity.Member;
import com.springboot.mreview.entity.Movie;
import com.springboot.mreview.entity.Review;

import java.util.List;

public interface ReviewService {

    List<ReviewDTO> getListOfMovie(Long mno);

    Long save(ReviewDTO reviewDTO);

    default Review dtoToEntity(ReviewDTO reviewDTO){
        Member member = Member.builder()
                .mid(reviewDTO.getMid())
                .build();

        Movie movie = Movie.builder()
                .mno(reviewDTO.getMno())
                .build();

        Review review = Review.builder()
                .reviewnum(reviewDTO.getReviewnum())
                .grade(reviewDTO.getGrade())
                .text(reviewDTO.getText())
                .movie(movie)
                .member(member)
                .build();

        return review;
    }

    default ReviewDTO entityToDTO(Review movieReview){

        ReviewDTO reviewDTO = ReviewDTO.builder()
                .reviewnum(movieReview.getReviewnum())
                .mno(movieReview.getMovie().getMno())
                .mid(movieReview.getMember().getMid())
                .nickname(movieReview.getMember().getNickname())
                .email(movieReview.getMember().getEmail())
                .grade(movieReview.getGrade())
                .text(movieReview.getText())
                .regDate(movieReview.getRegDate())
                .modDate(movieReview.getModDate())
                .build();

        return reviewDTO;
    }
}
