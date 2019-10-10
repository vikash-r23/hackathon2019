package com.db.hackathon.repository;

import com.db.hackathon.model.IdeaInvestmentBreakup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaInvestmentBreakupRepository extends JpaRepository<IdeaInvestmentBreakup,Long> {
}
