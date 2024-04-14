package edu.techsiel1.service;

import edu.techsiel1.entity.Review;
import edu.techsiel1.repository.ReviewRepository;
import edu.techsiel1.service.exception.ReviewNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing reviews.
 * This class provides methods to perform CRUD operations on reviews.
 */
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    /**
     * Constructs a ReviewService with the specified ReviewRepository.
     *
     * @param reviewRepository The repository used for accessing and managing reviews.
     */
    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    /**
     * Retrieves all reviews.
     *
     * @return An Iterable of all reviews.
     */
    public Iterable<Review> getAll() {
        return reviewRepository.findAll();
    }

    /**
     * Retrieves a review by its ID.
     *
     * @param reviewId The ID of the review to retrieve.
     * @return The review with the specified ID.
     * @throws IllegalArgumentException if the reviewId is null or not a positive integer.
     * @throws ReviewNotFoundException if the review with the specified ID is not found.
     */
    public Review getOne(Integer reviewId) {
        if (reviewId == null || reviewId <= 0) {
            throw new IllegalArgumentException("Invalid review ID. Review ID must be a positive integer.");
        }
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException(String.format("Review with id '%s' not found", reviewId)));
    }

    /**
     * Creates a new review.
     *
     * @param review The review to create.
     * @return The created review.
     */
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    /**
     * Deletes a review by its ID.
     *
     * @param reviewId The ID of the review to delete.
     * @throws IllegalArgumentException if the reviewId is null or not a positive integer.
     * @throws ReviewNotFoundException if the review with the specified ID is not found.
     */
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
