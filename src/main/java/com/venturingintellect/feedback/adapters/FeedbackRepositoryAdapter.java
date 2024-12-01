package com.venturingintellect.feedback.adapters;

import com.venturingintellect.feedback.domain.Feedback;
import com.venturingintellect.feedback.ports.FeedbackRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackRepositoryAdapter implements FeedbackRepositoryPort {

    @Autowired
    private FeedbackJpaRepository feedbackJpaRepository;

    @Override
    public void saveFeedback(Feedback feedback) {
        FeedbackEntity feedbackEntity = new FeedbackEntity();
        feedbackEntity.setEmail(feedback.getEmail());
        feedbackEntity.setFeedbackText(feedback.getFeedbackText());
        feedbackEntity.setName(feedback.getName());
        feedbackJpaRepository.save(feedbackEntity);
    }

    @Override
    public Feedback retrieveFeedback(String email) {
        FeedbackEntity feedbackEntity = feedbackJpaRepository.findByEmail(email);
        Feedback feedback = new Feedback();
        feedback.setEmail(feedbackEntity.getEmail());
        feedback.setFeedbackText(feedbackEntity.getFeedbackText());
        feedback.setName(feedbackEntity.getName());
        return feedback;
    }
}
