package com.nebula.reviewconsumer.filter;

import com.nebula.reviewconsumer.model.CreateReviewDto;
import org.springframework.stereotype.Component;

@Component
class ReviewFilterImpl implements ReviewFilter {

	private static final String INAPPROPRIATE_WORD = "f_word";

	@Override
	public Boolean isCommentApproved(CreateReviewDto dto) {

		if (dto != null && dto.getComment() != null) {
			return !dto.getComment().contains(INAPPROPRIATE_WORD);
		}
		return true;
	}
}
