package com.db.hackathon.repository;

import com.db.hackathon.model.Investments;
import com.db.hackathon.model.MonthBreakDownData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestmentsRepository extends JpaRepository<Investments,Long> {

}
