package com.nebula.reviewconsumer.model;

import lombok.Data;

@Data
public class CreateReviewDto {

	private Integer reviewId;

	private String comment;

	public CreateReviewDto(Integer reviewId, String comment) {
		this.reviewId = reviewId;
		this.comment = comment;
	}
}
