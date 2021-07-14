package com.example;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllUsersListDTO {

	private List<AllUsersDTO> allUsersList;

	public List<AllUsersDTO> getAllUsersList() {
		return allUsersList;
	}

	public void setAllUsersList(List<AllUsersDTO> allUsersList) {
		this.allUsersList = allUsersList;
	}

}
