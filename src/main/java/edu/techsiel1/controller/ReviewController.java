package edu.techsiel1.controller;

import edu.techsiel1.entity.Review;
import edu.techsiel1.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Review getOne(@PathVariable Integer reviewId){return reviewService.getOne(reviewId);}
}
