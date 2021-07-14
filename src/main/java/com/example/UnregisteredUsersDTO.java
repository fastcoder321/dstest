package com.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UnregisteredUsersDTO extends AbstractUsersDTO {

	//common fields (need to be on this level so we can copy them to other classes using reflection)
	private String id;	
	private String emailAddress;	
	private String languageCode;
	
	//fields specific to this dto
	private String registrationId;	
	private String registrationIdGeneratedTime;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	
	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getRegistrationIdGeneratedTime() {
		return registrationIdGeneratedTime;
	}

	public void setRegistrationIdGeneratedTime(String registrationIdGeneratedTime) {
		this.registrationIdGeneratedTime = registrationIdGeneratedTime;
	}
	
	
}
