package edu.techsiel1.controller;

import edu.techsiel1.entity.Review;
import edu.techsiel1.service.ReviewService;
import edu.techsiel1.service.exception.ReviewNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing Review entities via RESTful endpoints.
 */
@RestController
@RequestMapping("api/review")
public class ReviewController {

    private final ReviewService reviewService;

    /**
     * Constructor injection for ReviewService.
     *
     * @param reviewService The ReviewService used to interact with Review entities.
     */
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * Add a new Review.
     *
     * @param review The Review object to be added.
     * @return The created Review object with a HTTP status of CREATED (201).
     */
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Review addReview(@RequestBody Review review) {
        return reviewService.create(review);
    }

    /**
     * Retrieve all Reviews.
     *
     * @return Iterable of all Reviews.
     */
    @GetMapping("/getAll")
    public @ResponseBody Iterable<Review> getAllReviews() {
        return reviewService.getAll();
    }

    /**
     * Get a specific Review by ID.
     *
     * @param reviewId The ID of the Review to retrieve.
     * @return ResponseEntity containing the retrieved Review, or an error response if not found or invalid ID.
     */
    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getOne(@PathVariable Integer reviewId) {
        try {
            Review review = reviewService.getOne(reviewId);
            return ResponseEntity.ok(review);
        } catch (ReviewNotFoundException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } catch (IllegalArgumentException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    /**
     * Delete a Review by ID.
     *
     * @param reviewId The ID of the Review to delete.
     * @return ResponseEntity with NO_CONTENT status if successful, or an error response if Review not found or invalid ID.
     */
    @DeleteMapping("/{reviewId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteReview(@PathVariable Integer reviewId) {
        try {
            reviewService.delete(reviewId);
            return ResponseEntity.noContent().build();
        } catch (ReviewNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
