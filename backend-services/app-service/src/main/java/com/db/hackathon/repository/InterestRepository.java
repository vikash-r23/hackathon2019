package com.db.hackathon.repository;

import com.db.hackathon.model.Idea;
import com.db.hackathon.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {

    @Query(value="select I.id, I.pitcherId, I.ideaName from Idea I LEFT JOIN Interest INT ON I.id = INT.ideaId where INT.userId=?1")
    public List<Idea> getAllInterestedIdeas(Long userId);
}
