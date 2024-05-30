package com.works.project.models;

import java.time.OffsetDateTime;

public class Review {
    private long rating;
    private String comment;
    private String date;
    private String reviewerName;
    private String reviewerEmail;

    public long getRating() { return rating; }
    public void setRating(long value) { this.rating = value; }

    public String getComment() { return comment; }
    public void setComment(String value) { this.comment = value; }

    public String getDate() { return date; }
    public void setDate(String value) { this.date = value; }

    public String getReviewerName() { return reviewerName; }
    public void setReviewerName(String value) { this.reviewerName = value; }

    public String getReviewerEmail() { return reviewerEmail; }
    public void setReviewerEmail(String value) { this.reviewerEmail = value; }
}
