package edu.techsiel1.service;

import edu.techsiel1.entity.Loan;
import edu.techsiel1.entity.Review;
import edu.techsiel1.entity.User;
import edu.techsiel1.repository.ReviewRepository;
import edu.techsiel1.service.exception.ReviewNotFoundException;
import edu.techsiel1.service.exception.UserNotFoundException;
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

    public Review getOne(Integer reviewId) {
        if (reviewId == null || reviewId <= 0) {
            throw new IllegalArgumentException("Invalid review ID. Review ID must be a positive integer.");
        }
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException(String.format("Review with id '%s' not found", reviewId)));
    }

    public Review create(Review review){
        return reviewRepository.save(review);}

    public void delete(Integer reviewId) {
        if (reviewId == null || reviewId <= 0) {
            throw new IllegalArgumentException("Invalid review ID. Review ID must be a positive integer.");
        }
        if (!reviewRepository.existsById(reviewId)) {
            throw new ReviewNotFoundException(String.format("Review with id '%s' not found", reviewId));
        }
        reviewRepository.deleteById(reviewId);
    }

}
