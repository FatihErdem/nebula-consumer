package com.nebula.reviewconsumer.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateReviewDto {

	private Integer reviewId;

	private Integer productId;

	private String comment;

	private String reviewerName;

	private LocalDateTime reviewDate;

	private String emailAddress;

	private Integer rating;

	private ReviewStatus status;

}
