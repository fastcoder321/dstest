package com.example;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisteredUsersListDTO {

	private List<RegisteredUsersDTO> registeredUsersList;

	public List<RegisteredUsersDTO> getRegisteredUsersList() {
		return registeredUsersList;
	}

	public void setRegisteredUsersList(List<RegisteredUsersDTO> registeredUsersList) {
		this.registeredUsersList = registeredUsersList;
	}	

}
