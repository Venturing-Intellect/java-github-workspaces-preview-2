package com.venturingintellect.feedback.ports;

import com.venturingintellect.feedback.domain.Feedback;

public interface SubmitFeedbackUseCase {
    void submitFeedback(Feedback feedback);
}
