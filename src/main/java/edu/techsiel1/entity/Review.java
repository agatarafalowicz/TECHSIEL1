package edu.techsiel1.entity;
import jakarta.persistence.*;


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

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
