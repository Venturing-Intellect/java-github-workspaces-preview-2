package com.venturingintellect.feedback.controllers;

import com.venturingintellect.feedback.domain.Feedback;
import com.venturingintellect.feedback.ports.SubmitFeedbackUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private SubmitFeedbackUseCase submitFeedbackUseCase;

    @PostMapping
    public void submitFeedback(@RequestBody Feedback feedback) {
        submitFeedbackUseCase.submitFeedback(feedback);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleInvalidEmailException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
