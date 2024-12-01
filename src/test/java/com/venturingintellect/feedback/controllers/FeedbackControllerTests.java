package com.venturingintellect.feedback.controllers;

import com.venturingintellect.feedback.domain.Feedback;
import com.venturingintellect.feedback.ports.SubmitFeedbackUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FeedbackControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private SubmitFeedbackUseCase submitFeedbackUseCase;

    @InjectMocks
    private FeedbackController feedbackController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(feedbackController).build();
    }

    @Test
    public void testSubmitFeedback() throws Exception {
        Feedback feedback = new Feedback();
        feedback.setEmail("test@example.com");
        feedback.setFeedbackText("Great service!");
        feedback.setName("John Doe");

        doNothing().when(submitFeedbackUseCase).submitFeedback(any(Feedback.class));

        mockMvc.perform(post("/feedback")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"test@example.com\",\"feedbackText\":\"Great service!\",\"name\":\"John Doe\"}"))
                .andExpect(status().isOk());

        verify(submitFeedbackUseCase, times(1)).submitFeedback(any(Feedback.class));
    }

    @Test
    public void testSubmitFeedbackWithInvalidEmail() throws Exception {
        Feedback feedback = new Feedback();
        feedback.setEmail("invalid-email");
        feedback.setFeedbackText("Great service!");
        feedback.setName("John Doe");

        doThrow(new IllegalArgumentException("Invalid email format")).when(submitFeedbackUseCase).submitFeedback(any(Feedback.class));

        mockMvc.perform(post("/feedback")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"invalid-email\",\"feedbackText\":\"Great service!\",\"name\":\"John Doe\"}"))
                .andExpect(status().isBadRequest());

        verify(submitFeedbackUseCase, times(1)).submitFeedback(any(Feedback.class));
    }
}
