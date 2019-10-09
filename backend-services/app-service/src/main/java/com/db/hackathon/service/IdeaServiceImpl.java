package com.db.hackathon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.hackathon.model.Idea;
import com.db.hackathon.repository.IdeaRepository;

@Service
public class IdeaServiceImpl implements IdeaService {
	
	@Autowired
	private IdeaRepository ideaRepository;

	@Override
	public List<Idea> getAllideas() {
		return ideaRepository.findAll();
	}

	@Override
	public Idea saveIdea(Idea idea) {
		return ideaRepository.saveAndFlush(idea);
	}

	@Override
	public Optional<Idea> getIdeaById(Long id) {
		return ideaRepository.findById(id);
	}

	@Override
	public Idea updateIdea(Idea idea) {
		return ideaRepository.saveAndFlush(idea);
	}

}
