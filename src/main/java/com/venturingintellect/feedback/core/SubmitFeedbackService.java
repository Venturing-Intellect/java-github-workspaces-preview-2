package com.venturingintellect.feedback.core;

import com.venturingintellect.feedback.domain.Feedback;
import com.venturingintellect.feedback.ports.FeedbackRepositoryPort;
import com.venturingintellect.feedback.ports.SubmitFeedbackUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class SubmitFeedbackService implements SubmitFeedbackUseCase {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    @Autowired
    private FeedbackRepositoryPort feedbackRepositoryPort;

    @Override
    public void submitFeedback(Feedback feedback) {
        if (!isValidEmail(feedback.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }
        feedbackRepositoryPort.saveFeedback(feedback);
    }

    private boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
