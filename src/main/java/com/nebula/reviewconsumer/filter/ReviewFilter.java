package com.nebula.reviewconsumer.filter;

import com.nebula.reviewconsumer.model.CreateReviewDto;

@FunctionalInterface
public interface ReviewFilter {

	Boolean isCommentApproved(CreateReviewDto dto);
}
