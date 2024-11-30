package com.venturingintellect.feedback.adapters;

import com.venturingintellect.feedback.domain.Feedback;
import com.venturingintellect.feedback.ports.FeedbackRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FeedbackRepositoryAdapterTests {

    @Mock
    private FeedbackJpaRepository feedbackJpaRepository;
    
    @InjectMocks
    private FeedbackRepositoryAdapter feedbackRepositoryAdapter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveFeedback() {
        Feedback feedback = new Feedback();
        feedback.setEmail("test@example.com");
        feedback.setFeedbackText("Great service!");

        feedbackRepositoryAdapter.saveFeedback(feedback);

        verify(feedbackJpaRepository, times(1)).save(any(Feedback.class));
    }

    @Test
    public void testRetrieveFeedback() {
        Feedback feedback = new Feedback();
        feedback.setEmail("test@example.com");
        feedback.setFeedbackText("Great service!");

        when(feedbackJpaRepository.findByEmail("test@example.com")).thenReturn(feedback);

        Feedback retrievedFeedback = feedbackRepositoryAdapter.retrieveFeedback("test@example.com");

        assertEquals("test@example.com", retrievedFeedback.getEmail());
        assertEquals("Great service!", retrievedFeedback.getFeedbackText());
    }
}
