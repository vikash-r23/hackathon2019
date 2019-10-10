package com.db.hackathon.repository;

import com.db.hackathon.model.Interested;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestedRepository extends JpaRepository<Interested, Long> {

}
