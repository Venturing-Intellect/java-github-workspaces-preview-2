package com.venturingintellect.feedback.controllers;

import com.venturingintellect.feedback.core.SubmitFeedbackService;
import com.venturingintellect.feedback.domain.Feedback;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

@WebMvcTest(FeedbackController.class)
public class FeedbackControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubmitFeedbackService submitFeedbackService;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext) {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testSubmitFeedback() throws Exception {
        Feedback feedback = new Feedback();
        feedback.setEmail("test@example.com");
        feedback.setFeedbackText("Great service!");

        doNothing().when(submitFeedbackService).submitFeedback(any(Feedback.class));

        mockMvc.perform(post("/feedback")
                .contentType("application/json")
                .content("{\"email\":\"test@example.com\",\"feedbackText\":\"Great service!\"}"))
                .andExpect(status().isOk());

        verify(submitFeedbackService, times(1)).submitFeedback(any(Feedback.class));
    }

    @Test
    public void testSubmitFeedbackWithInvalidEmail() throws Exception {
        Feedback feedback = new Feedback();
        feedback.setEmail("invalid-email");
        feedback.setFeedbackText("Great service!");

        doThrow(new IllegalArgumentException("Invalid email format")).when(submitFeedbackService).submitFeedback(any(Feedback.class));

        mockMvc.perform(post("/feedback")
                .contentType("application/json")
                .content("{\"email\":\"invalid-email\",\"feedbackText\":\"Great service!\"}"))
                .andExpect(status().isBadRequest());

        verify(submitFeedbackService, times(1)).submitFeedback(any(Feedback.class));
    }
}
