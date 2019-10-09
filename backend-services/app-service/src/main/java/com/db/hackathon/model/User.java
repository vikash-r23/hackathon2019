package com.db.hackathon.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.db.hackathon.constants.AppConstants;
import com.db.hackathon.constants.UserStatus;
import com.db.hackathon.constants.UserType;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "username", nullable = false, unique = true)
	@NotBlank(message = "Please provide a username")
	@Email(message = "User name must be an email")
	private String userName;

	@Column(name = "first_name",nullable = false)
	@NotBlank(message = "Please provide your first name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "password", nullable = false)
	@NotEmpty(message = "Please provide a password")
	private String password;

	@Transient
	@NotBlank
	private String confirmPassword;

	@Column(name = "mobile_num", nullable = false)
	@NotBlank(message = "Please provide your mobile number")
	@Pattern(regexp=AppConstants.MOBILE_NUM_PATTERN,message = "Please enter a valid 10 digit mobile number")
	private String mobileNumber;

	@Column(name = "user_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private UserType userType;

	@Column(name = "is_active")
	@Enumerated(EnumType.STRING)
	private UserStatus enabled;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false)
	@CreationTimestamp
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_on", nullable = false)
	@UpdateTimestamp
	private Date updated;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Idea> ideas;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public UserStatus getEnabled() {
		return enabled;
	}

	public void setEnabled(UserStatus enabled) {
		this.enabled = enabled;
	}

	public Set<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(Set<Idea> ideas) {
		this.ideas = ideas;
	}
	
}