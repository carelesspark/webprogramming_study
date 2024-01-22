package com.springboot.mreview.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.springboot.mreview.entity.Movie;
import com.springboot.mreview.entity.QMovie;
import com.springboot.mreview.entity.QMovieImage;
import com.springboot.mreview.entity.QReview;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class SearchMovieRepositoryImpl extends QuerydslRepositorySupport implements SearchMovieRepository {

    public SearchMovieRepositoryImpl(){
        super(Movie.class);
    }


    @Override
    public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {

        log.info("searchPage().....");

        QMovie movie = QMovie.movie;
        QMovieImage movieImage = QMovieImage.movieImage;
        QReview review = QReview.review;

        JPQLQuery<Movie> jpqlQuery = from(movie);
        jpqlQuery.leftJoin(movieImage).on(movieImage.movie.eq(movie));
        jpqlQuery.leftJoin(review).on(review.movie.eq(movie));

        // SELECT b, m, count(r) FROM Board b
        // LEFT JOIN b.writer m LEFT OUTER JOIN Reply r ON r.board = b

        JPQLQuery<Tuple> tuple = jpqlQuery.select(movie, movieImage, review.grade.avg(),review.count());

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        BooleanExpression booleanExpression = movie.mno.gt(0L);

        booleanBuilder.and(booleanExpression);

        if(type != null){
            String[] typeArr = type.split("");

            BooleanBuilder conditionBuilder = new BooleanBuilder();

            for(String t : typeArr){
                switch(t){
                    case "t":
                        conditionBuilder.or(movie.title.contains(keyword));
                        break;
                }
            }

            booleanBuilder.and(conditionBuilder);

        }

        tuple.where(booleanBuilder);
//        tuple.groupBy(board);

//        List<Tuple> result = tuple.fetch();
//        log.info(result);

        // where bno > 0
        // and (title like %?% or email like %?%.....)
        // group by ???

        Sort sort = pageable.getSort();
        sort.stream().forEach(order -> {
            Order direction = order.isAscending() ? Order.ASC : Order.DESC;

            String prop = order.getProperty();

            // 정렬의 기준 값을 정의함
            PathBuilder orderByExpressiong = new PathBuilder(Movie.class, "movie");
            tuple.orderBy(new OrderSpecifier(direction, orderByExpressiong.get(prop)));
        });

        tuple.groupBy(movie);

        tuple.offset(pageable.getOffset());
        tuple.limit(pageable.getPageSize());

        List<Tuple> result = tuple.fetch();
        log.info(result);

        long count = tuple.fetchCount();

        log.info(count);

        
        // PageImpl 객체
        return new PageImpl<Object[]>(
                result.stream().map(t -> t.toArray()).collect(Collectors.toList()),
                pageable, count
        );
    }
}


