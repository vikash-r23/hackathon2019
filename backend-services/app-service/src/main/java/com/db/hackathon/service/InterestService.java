package com.db.hackathon.service;

import com.db.hackathon.model.Idea;
import com.db.hackathon.model.Interest;

import java.util.List;

public interface InterestService {

    public abstract Interest saveInterest(Interest interest);
    public abstract List<Idea> getAllInterestedIdeas(long userId);
}
