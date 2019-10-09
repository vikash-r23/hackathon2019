package com.db.hackathon.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="interest")
public class Interest {

    @Id
    @GeneratedValue
    @Column(name="interest_id")
    private Long interestId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name="idea_id")
    private Long ideaId;

    @Column(name="comments")
    private String comments;

    public Long getInterestId() {
        return interestId;
    }

    public void setInterestId(Long interestId) {
        this.interestId = interestId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(Long ideaId) {
        this.ideaId = ideaId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

