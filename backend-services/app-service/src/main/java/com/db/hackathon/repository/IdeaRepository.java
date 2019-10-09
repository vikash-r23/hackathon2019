package com.db.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.hackathon.model.Idea;

@Repository
public interface IdeaRepository extends JpaRepository<Idea, Long> {
}
