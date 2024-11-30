package com.venturingintellect.feedback.integration;

import com.venturingintellect.feedback.domain.Feedback;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FeedbackIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSubmitFeedback() throws Exception {
        mockMvc.perform(post("/feedback")
                .contentType("application/json")
                .content("{\"email\":\"test@example.com\",\"feedbackText\":\"Great service!\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSubmitFeedbackWithInvalidEmail() throws Exception {
        mockMvc.perform(post("/feedback")
                .contentType("application/json")
                .content("{\"email\":\"invalid-email\",\"feedbackText\":\"Great service!\"}"))
                .andExpect(status().isBadRequest());
    }
}
