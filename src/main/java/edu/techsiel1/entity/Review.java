package edu.techsiel1.entity;

import jakarta.persistence.*;

/**
 * Represents a review entity in the library system.
 */
@Entity
@Table(name="review", schema = "library")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reviewId")
    private Integer reviewId;

    @ManyToOne
    @JoinColumn(name = "bookId", nullable = false)
    private Book bookId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User userId;

    @Basic
    @Column(name="rating", nullable = false)
    private Double rating;

    @Basic
    @Column(name="comment", nullable = false)
    private String comment;

    @Basic
    @Column(name="date", nullable = false)
    private String date;

    /**
     * Get the ID of the review.
     *
     * @return The review ID.
     */
    public Integer getReviewId() {
        return reviewId;
    }

    /**
     * Set the ID of the review.
     *
     * @param reviewId The review ID to set.
     */
    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    /**
     * Get the book associated with the review.
     *
     * @return The Book object representing the book associated with the review.
     */
    public Book getBookId() {
        return bookId;
    }

    /**
     * Set the book associated with the review.
     *
     * @param bookId The Book object representing the book to associate with the review.
     */
    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    /**
     * Get the user who wrote the review.
     *
     * @return The User object representing the user who wrote the review.
     */
    public User getUserId() {
        return userId;
    }

    /**
     * Set the user who wrote the review.
     *
     * @param userId The User object representing the user to associate with the review.
     */
    public void setUserId(User userId) {
        this.userId = userId;
    }

    /**
     * Get the rating given in the review.
     *
     * @return The rating.
     */
    public Double getRating() {
        return rating;
    }

    /**
     * Set the rating for the review.
     *
     * @param rating The rating to set.
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     * Get the comment written in the review.
     *
     * @return The comment.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Set the comment for the review.
     *
     * @param comment The comment to set.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Get the date when the review was made.
     *
     * @return The date of the review.
     */
    public String getDate() {
        return date;
    }

    /**
     * Set the date when the review was made.
     *
     * @param date The date to set.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Creates a new review entity associated with a specific book.
     *
     * @param bookId The Book object representing the book associated with this review.
     */
    public Review(Book bookId) {
        this.bookId = bookId;
    }

    /**
     * Creates a new review entity associated with a specific user.
     *
     * @param userId The User object representing the user who wrote this review.
     */
    public Review(User userId) {
        this.userId = userId;
    }

    /**
     * Default constructor for creating a new Review instance.
     */
    public Review() {
    }

    public Review(Integer reviewId){this.reviewId=reviewId;}
}
