package com.nebula.reviewconsumer.producer;

import com.nebula.reviewconsumer.config.RabbitConfig;
import com.nebula.reviewconsumer.model.CreateReviewDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReviewConsumer {

	@RabbitListener(queues=RabbitConfig.REVIEW_CREATED_QUEUE)
	public void recievedMessage(CreateReviewDto dto) {
		log.info("Recieved Message: " + dto);
	}
}
