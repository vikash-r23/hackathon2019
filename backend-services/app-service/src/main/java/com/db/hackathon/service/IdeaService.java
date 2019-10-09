package com.db.hackathon.service;

import java.util.List;
import java.util.Optional;

import com.db.hackathon.model.Idea;

public interface IdeaService {

	public abstract Optional<Idea> getIdeaById(Long id);

	public abstract Idea saveIdea(Idea idea);

	public abstract Idea updateIdea(Idea idea);

	public abstract List<Idea> getAllideas();
	
}
