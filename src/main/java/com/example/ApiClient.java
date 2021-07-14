package com.example;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 

/*
 * Note: In a real application this client may need to return a paginated list.
 */
@Component
public class ApiClient {
	
	public static final String BASE_URI = "https://5c3ce12c29429300143fe570.mockapi.io/api/";
	public static final String REGISTERED_USERS_URI = BASE_URI + "registeredusers";
	public static final String UNREGISTERED_USERS_URI = BASE_URI + "unregisteredusers";
	public static final String PROJECTMEMBERSHIPS_URI = BASE_URI + "projectmemberships";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public UnregisteredUsersListDTO getUnregisteredUsers()
	{
		UnregisteredUsersDTO[] array = restTemplate.getForObject(
				UNREGISTERED_USERS_URI, UnregisteredUsersDTO[].class);			
		List<UnregisteredUsersDTO> unregisteredUsersList = Arrays.stream(array).collect(Collectors.toList());
		UnregisteredUsersListDTO listDTO = new UnregisteredUsersListDTO();
		listDTO.setUnregisteredUsersList(unregisteredUsersList);
		return listDTO;
	}
	
	public RegisteredUsersListDTO getRegisteredUsers()
	{
		RegisteredUsersDTO[] array = restTemplate.getForObject(
				REGISTERED_USERS_URI, RegisteredUsersDTO[].class);				
		List<RegisteredUsersDTO> registeredUsersList = Arrays.stream(array).collect(Collectors.toList());		
		RegisteredUsersListDTO listDTO = new RegisteredUsersListDTO();
		listDTO.setRegisteredUsersList(registeredUsersList);
		return listDTO;
	}
	
	public ProjectMembershipsListDTO getProjectMembershipsList()
	{
		ProjectMembershipsDTO[] array = restTemplate.getForObject(
				PROJECTMEMBERSHIPS_URI, ProjectMembershipsDTO[].class);		
		List<ProjectMembershipsDTO> projectMembershipsList = Arrays.stream(array).collect(Collectors.toList());
		ProjectMembershipsListDTO listDTO = new ProjectMembershipsListDTO();
		listDTO.setProjectMembershipsList(projectMembershipsList);
		return listDTO;
	}
	
}
