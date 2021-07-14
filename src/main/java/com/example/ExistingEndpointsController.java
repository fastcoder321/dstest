package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Note: normally these endpont URI's would be more restful and would have common parent paths (eg /users vs projectmemberships)
 * but I just threw them in there since it's just an example.
 */
@RestController
public class ExistingEndpointsController {
	
	@Autowired
	private ApiClient apiClient;
	

	@RequestMapping("/unregistered")
	public UnregisteredUsersListDTO getUnregisteredUsers() {
		UnregisteredUsersListDTO listDTO = apiClient.getUnregisteredUsers();
		return listDTO;
	}
	
	@RequestMapping("/registered")
	public RegisteredUsersListDTO getRegisteredUsers() {
		RegisteredUsersListDTO listDTO = apiClient.getRegisteredUsers();
		return listDTO;
	}	

	@RequestMapping("/projectmemberships")
	public ProjectMembershipsListDTO getProjectMemberships() {
		ProjectMembershipsListDTO listDTO = apiClient.getProjectMembershipsList();
		return listDTO;
	}
	
}
