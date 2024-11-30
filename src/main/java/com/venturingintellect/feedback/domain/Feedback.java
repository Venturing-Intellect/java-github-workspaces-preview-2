package com.venturingintellect.feedback.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Feedback {
    @Email
    private String email;

    @NotBlank
    private String feedbackText;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }
}
