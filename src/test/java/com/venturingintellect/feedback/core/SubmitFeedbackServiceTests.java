package com.venturingintellect.feedback.core;

import com.venturingintellect.feedback.domain.Feedback;
import com.venturingintellect.feedback.ports.FeedbackRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SubmitFeedbackServiceTests {

    @Mock
    private FeedbackRepositoryPort feedbackRepositoryPort;

    @InjectMocks
    private SubmitFeedbackService submitFeedbackService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSubmitFeedbackWithValidEmail() {
        Feedback feedback = new Feedback();
        feedback.setEmail("test@example.com");
        feedback.setFeedbackText("Great service!");

        submitFeedbackService.submitFeedback(feedback);

        verify(feedbackRepositoryPort, times(1)).saveFeedback(any(Feedback.class));
    }

    @Test
    public void testSubmitFeedbackWithInvalidEmail() {
        Feedback feedback = new Feedback();
        feedback.setEmail("invalid-email");
        feedback.setFeedbackText("Great service!");

        assertThrows(IllegalArgumentException.class, () -> {
            submitFeedbackService.submitFeedback(feedback);
        });

        verify(feedbackRepositoryPort, times(0)).saveFeedback(any(Feedback.class));
    }
}
