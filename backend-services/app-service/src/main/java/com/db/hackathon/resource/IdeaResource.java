package com.db.hackathon.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.hackathon.exception.CustomValidationException;
import com.db.hackathon.model.Idea;
import com.db.hackathon.model.User;
import com.db.hackathon.service.IdeaService;

@CrossOrigin
@RestController
@RequestMapping("/api/idea")
public class IdeaResource {
	
	@Autowired
	private IdeaService ideaService;
	
	@PostMapping("/pitch")
	public ResponseEntity<?> pitchIdea(@Valid @RequestBody Idea idea,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			throw new CustomValidationException(bindingResult);
		}
		User user = new User();
		user.setUserId(idea.getPitcherId());
		idea.setUser(user);
		Idea saveIdea = ideaService.saveIdea(idea);
		saveIdea.setPitcherId(idea.getPitcherId());
		return new ResponseEntity<Idea>(saveIdea, HttpStatus.CREATED);
	}
	
	@GetMapping("/allIdeas")
	public ResponseEntity<?> getAllIdeas(){
		return new ResponseEntity<List<Idea>>(ideaService.getAllideas(), HttpStatus.OK);
	}
	
	@GetMapping("/{ideaId}")
	public ResponseEntity<?> getIdeaById(@PathVariable String ideaId){
		return new ResponseEntity<Idea>(ideaService.getIdeaById(Long.valueOf(ideaId)).get(), HttpStatus.OK);
	}
	
}
