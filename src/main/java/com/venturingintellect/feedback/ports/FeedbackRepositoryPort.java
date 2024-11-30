package com.venturingintellect.feedback.ports;

import com.venturingintellect.feedback.domain.Feedback;

public interface FeedbackRepositoryPort {
    void saveFeedback(Feedback feedback);
    Feedback retrieveFeedback(String email);
}
