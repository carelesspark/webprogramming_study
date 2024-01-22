package com.springboot.mreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.mreview.entity.MovieImage;

public interface MovieImageRepository extends JpaRepository<MovieImage,Long> {
}
