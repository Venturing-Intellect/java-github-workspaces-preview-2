package com.venturingintellect.feedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.venturingintellect.feedback.adapters")
public class FeedbackApplication {

    private static final Logger logger = LoggerFactory.getLogger(FeedbackApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FeedbackApplication.class, args);
        logger.info("Feedback application started successfully.");
    }
}
