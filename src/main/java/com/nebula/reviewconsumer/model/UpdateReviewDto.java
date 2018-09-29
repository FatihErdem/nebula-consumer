package com.nebula.reviewconsumer.model;

import lombok.Data;

@Data
public class UpdateReviewDto {

	private Integer id;

	private ReviewStatus status;
}
