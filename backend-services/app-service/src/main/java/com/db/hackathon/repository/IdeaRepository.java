package com.db.hackathon.repository;

import com.db.hackathon.model.MonthBreakDownData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.db.hackathon.model.Idea;

import java.util.List;
import java.util.Map;

@Repository
public interface IdeaRepository extends JpaRepository<Idea, Long> {

}
