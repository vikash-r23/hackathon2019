package com.db.hackathon.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class Idea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	@JsonIgnore
	private User user;
	
	@NotNull
	private Long pitcherId;
	
	@NotBlank
	@Column(name = "ideaName", nullable = false, unique = true)
	private String ideaName;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private String usp;
	
	@NotBlank
	private String roi;
	
	private long likes;
	
	@ElementCollection  
	private List<String> promoUrls;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false)
	@CreationTimestamp
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_on", nullable = false)
	@UpdateTimestamp
	private Date updated;
	
	public String getIdeaName() {
		return ideaName;
	}
	public void setIdeaName(String ideaName) {
		this.ideaName = ideaName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUsp() {
		return usp;
	}
	public void setUsp(String usp) {
		this.usp = usp;
	}
	public String getRoi() {
		return roi;
	}
	public void setRoi(String roi) {
		this.roi = roi;
	}
	public long getLikes() {
		return likes;
	}
	public void setLikes(long likes) {
		this.likes = likes;
	}
	public List<String> getPromoUrls() {
		return promoUrls;
	}
	public void setPromoUrls(List<String> promoUrls) {
		this.promoUrls = promoUrls;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public Date getUpdated() {
		return updated;
	}
	
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	public Long getPitcherId() {
		return pitcherId;
	}
	
	public void setPitcherId(Long pitcherId) {
		this.pitcherId = pitcherId;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !obj.getClass().getName().equals(Idea.class.getName())) {
			return false;
		}
		return this.id== ((Idea)obj).getId();
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

}
