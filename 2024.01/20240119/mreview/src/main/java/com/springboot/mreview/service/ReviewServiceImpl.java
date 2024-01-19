package com.springboot.mreview.service;

import com.springboot.mreview.dto.ReviewDTO;
import com.springboot.mreview.entity.Movie;
import com.springboot.mreview.entity.Review;
import com.springboot.mreview.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReviewServiceImpl implements  ReviewService{

    private final ReviewRepository reviewRepository;
    @Override
    public List<ReviewDTO> getListOfMovie(Long mno) {

        List<Review> result = reviewRepository.findByMovie(Movie.builder()
                .mno(mno).build());

        return result.stream().map(review -> entityToDTO(review)).collect(Collectors.toList());
    }

    @Override
    public Long save(ReviewDTO reviewDTO) {
        Review review = dtoToEntity(reviewDTO);

        reviewRepository.save(review);

        return review.getReviewnum();
    }
}
