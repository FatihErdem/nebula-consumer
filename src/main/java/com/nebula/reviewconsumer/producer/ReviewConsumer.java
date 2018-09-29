package com.nebula.reviewconsumer.producer;

import com.nebula.reviewconsumer.config.RabbitConfig;
import com.nebula.reviewconsumer.filter.ReviewFilter;
import com.nebula.reviewconsumer.model.CreateReviewDto;
import com.nebula.reviewconsumer.model.ReviewStatus;
import com.nebula.reviewconsumer.model.UpdateReviewDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ReviewConsumer {

	private final ReviewFilter reviewFilter;

	private final RabbitTemplate rabbitTemplate;

	@RabbitListener(queues=RabbitConfig.REVIEW_CREATED_QUEUE)
	public void createdReviewConsumer(CreateReviewDto createReviewDto) {
		Boolean isCommentApproved = reviewFilter.isCommentApproved(createReviewDto);

		if(isCommentApproved) {
			createReviewDto.setStatus(ReviewStatus.APPROVED);
		} else {
			createReviewDto.setStatus(ReviewStatus.DECLINED);
		}

		UpdateReviewDto updateReviewDto = new UpdateReviewDto();
		updateReviewDto.setId(createReviewDto.getReviewId());
		updateReviewDto.setStatus(createReviewDto.getStatus());

		rabbitTemplate.convertAndSend(RabbitConfig.REVIEW_UPDATED_QUEUE, updateReviewDto);
	}
}
