package com.db.hackathon.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.db.hackathon.model.Idea;
import com.db.hackathon.model.MonthBreakDownData;

public interface IdeaService {

	public abstract Optional<Idea> getIdeaById(Long id);

	public abstract Idea saveIdea(Idea idea);

	public abstract Idea updateIdea(Idea idea);

	public abstract List<Idea> getAllideas();

	//public abstract List<MonthBreakDownData> getBreakDownByMonth(Long pitcherId);

	//public abstract Map<String, Integer> getBreakDownByInvestor(Long pitcherId);

}
