package com.db.hackathon.resource;

import com.db.hackathon.exception.CustomValidationException;
import com.db.hackathon.model.Idea;
import com.db.hackathon.model.Interest;
import com.db.hackathon.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/interest")
public class InterestResource {

    @Autowired
    InterestService interestService;

    @PostMapping("/show/interest")
    public ResponseEntity<?> showInterest(@Valid @RequestBody Interest interest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new CustomValidationException(bindingResult);
        }
        return new ResponseEntity<>(interestService.saveInterest(interest), HttpStatus.CREATED);
    }

    @GetMapping("/get/interested/ideas/{userId}")
    public ResponseEntity<?> getInterestIdeas(@PathVariable Long userId){
        return  new ResponseEntity<List<Idea>>(interestService.getAllInterestedIdeas(userId), HttpStatus.OK);
    }

}
