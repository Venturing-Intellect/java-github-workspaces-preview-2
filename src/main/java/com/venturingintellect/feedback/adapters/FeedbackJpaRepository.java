package com.venturingintellect.feedback.adapters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackJpaRepository extends JpaRepository<FeedbackEntity, Long> {
    FeedbackEntity findByEmail(String email);
}
