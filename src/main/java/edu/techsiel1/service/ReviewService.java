package edu.techsiel1.service;

import edu.techsiel1.entity.Review;
import edu.techsiel1.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    public Iterable<Review> getAll(){
        return reviewRepository.findAll();
    }

    public Review getOne(Integer reviewId){
        return reviewRepository.findById(reviewId).orElseThrow(()
                -> new RuntimeException("Review not found"));
    }

    public Review create(Review review){return reviewRepository.save(review);}

}
