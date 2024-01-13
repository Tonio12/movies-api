package com.tonilearnsjava.movies.services;

import com.tonilearnsjava.movies.models.Movies;
import com.tonilearnsjava.movies.models.Reviews;
import com.tonilearnsjava.movies.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MongoTemplate mongoTemplate;

    public Reviews createReview(String body, String imdbId){
        Reviews review =reviewRepository.insert(new Reviews(body));

        mongoTemplate.update(Movies.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;

    }
}
