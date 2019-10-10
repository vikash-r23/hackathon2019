package com.db.hackathon.service;

import com.db.hackathon.model.Idea;
import com.db.hackathon.model.Interest;
import com.db.hackathon.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestServiceImpl implements InterestService {

    @Autowired
    InterestRepository interestRepository;

    @Override
    public Interest saveInterest(Interest interest) {
        return interestRepository.save(interest);
    }

    @Override
    public List<Idea> getAllInterestedIdeas(long userId) {
        return interestRepository.getAllInterestedIdeas(userId);
    }
}
