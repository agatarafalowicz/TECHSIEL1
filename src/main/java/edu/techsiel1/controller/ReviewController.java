package edu.techsiel1.controller;

import edu.techsiel1.entity.Review;
import edu.techsiel1.service.ReviewService;
import edu.techsiel1.service.exception.ReviewNotFoundException;
import edu.techsiel1.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/review")
public class ReviewController {
    private final ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Review addReview(@RequestBody Review review){
        return reviewService.create(review);
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<Review> getAllReviews(){
        return reviewService.getAll();
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getOne(@PathVariable Integer reviewId) {
        try{
            Review review = reviewService.getOne(reviewId);
            return ResponseEntity.ok(review);
        } catch (ReviewNotFoundException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } catch (IllegalArgumentException e){
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

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
