package com.db.hackathon.resource;

import com.db.hackathon.exception.CustomValidationException;
import com.db.hackathon.model.Interest;
import com.db.hackathon.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/interest")
public class InterestResource {

    @Autowired
    InterestService interestService;

    @PostMapping("/showInterest")
    public ResponseEntity<?> showInterest(@Valid @RequestBody Interest interest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new CustomValidationException(bindingResult);
        }
        return new ResponseEntity<>(interestService.saveInterest(interest), HttpStatus.CREATED);
    }

}
