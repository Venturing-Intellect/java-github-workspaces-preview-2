package com.venturingintellect.feedback.adapters;

import com.venturingintellect.feedback.adapters.FeedbackEntity;
import com.venturingintellect.feedback.domain.Feedback;
import com.venturingintellect.feedback.ports.FeedbackRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
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

        FeedbackEntity feedbackEntity = new FeedbackEntity();
        feedbackEntity.setEmail(feedback.getEmail());
        feedbackEntity.setFeedbackText(feedback.getFeedbackText());

        feedbackRepositoryAdapter.saveFeedback(feedback);

        verify(feedbackJpaRepository, times(1)).save(any(FeedbackEntity.class));
    }

    @Test
    public void testRetrieveFeedback() {
        FeedbackEntity feedbackEntity = new FeedbackEntity();
        feedbackEntity.setEmail("test@example.com");
        feedbackEntity.setFeedbackText("Great service!");

        when(feedbackJpaRepository.findByEmail("test@example.com")).thenReturn(feedbackEntity);

        Feedback retrievedFeedback = feedbackRepositoryAdapter.retrieveFeedback("test@example.com");

        assertEquals("test@example.com", retrievedFeedback.getEmail());
        assertEquals("Great service!", retrievedFeedback.getFeedbackText());
    }
}
