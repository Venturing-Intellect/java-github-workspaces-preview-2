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
        feedbackJpaRepository.save(feedback);
    }

    @Override
    public Feedback retrieveFeedback(String email) {
        return feedbackJpaRepository.findByEmail(email);
    }
}
