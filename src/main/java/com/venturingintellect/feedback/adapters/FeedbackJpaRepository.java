package com.venturingintellect.feedback.adapters;

import com.venturingintellect.feedback.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackJpaRepository extends JpaRepository<Feedback, Long> {
    Feedback findByEmail(String email);
}