package com.example;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UnregisteredUsersListDTO {

	private List<UnregisteredUsersDTO> unregisteredUsersList;

	public List<UnregisteredUsersDTO> getUnregisteredUsersList() {
		return unregisteredUsersList;
	}

	public void setUnregisteredUsersList(List<UnregisteredUsersDTO> unregisteredUsersList) {
		this.unregisteredUsersList = unregisteredUsersList;
	}
	
}
