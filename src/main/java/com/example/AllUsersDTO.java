package com.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllUsersDTO extends AbstractUsersDTO {

	//common fields (need to be on this level so we can copy them to other classes using reflection)
	private String id;	
	private String emailAddress;	
	private String languageCode;
	
	//fields from RegisteredUsersDTO
	private String city;
	private String company;
	private String country;
	private String firstName;
	private String lastName;
	private String organizationType;
	private String phone;
	private String state;
	private String zipCode;
	private String disclaimerAccepted;
	
	//fields from UnregisteredUsersDTO
	private String registrationId;			
	private String registrationIdGeneratedTime;
	
	//new fields in this 'combined' DTO
	private String[] projectIds = {};
	
	
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
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getDisclaimerAccepted() {
		return disclaimerAccepted;
	}

	public void setDisclaimerAccepted(String disclaimerAccepted) {
		this.disclaimerAccepted = disclaimerAccepted;
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

	public String[] getProjectIds() {
		return projectIds;
	}

	public void setProjectIds(String[] projectIds) {
		this.projectIds = projectIds;
	}
	
}
