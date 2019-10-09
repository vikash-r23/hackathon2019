package com.db.hackathon.repository;

import com.db.hackathon.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Interest, Long> {
}
