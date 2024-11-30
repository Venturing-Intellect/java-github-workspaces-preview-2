package com.venturingintellect.feedback.controllers;

import com.venturingintellect.feedback.core.SubmitFeedbackService;
import com.venturingintellect.feedback.domain.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private SubmitFeedbackService submitFeedbackService;

    @PostMapping
    public void submitFeedback(@RequestBody Feedback feedback) {
        submitFeedbackService.submitFeedback(feedback);
    }
}
