package com.example;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller has a single endpoint that will return all the users,
 * registered and unregistered, including the project ids the users belong to.
 * If users do not belong to a project, project ids attribute would contain an
 * empty array in the response payload.
 */
@RestController
public class UserController {
	
	private static final Map<String, Field> REGISTERED_USER_DTO_FIELDS = new HashMap<>();
	static {
		for (Field field : RegisteredUsersDTO.class.getDeclaredFields())
		{
			REGISTERED_USER_DTO_FIELDS.put(field.getName(), field);
		}
	}
			
	private static final Map<String, Field> UNREGISTERED_USER_DTO_FIELDS = new HashMap<>();
	static {
		for (Field field : UnregisteredUsersDTO.class.getDeclaredFields())
		{
			UNREGISTERED_USER_DTO_FIELDS.put(field.getName(), field);
		}
	}
	
	private static final Map<String, Field> ALL_USER_DTO_FIELDS = new HashMap<>();
	static {
		for (Field field : AllUsersDTO.class.getDeclaredFields())
		{
			ALL_USER_DTO_FIELDS.put(field.getName(), field);
		}
	}
	
	@Autowired
	private ApiClient apiClient;
	

	@RequestMapping("/allusers")
	public AllUsersListDTO getUnregisteredUsers() throws IllegalArgumentException, IllegalAccessException 
	{
		RegisteredUsersListDTO registeredUsersListDTO = apiClient.getRegisteredUsers();
		UnregisteredUsersListDTO unregisteredUsersListDTO = apiClient.getUnregisteredUsers();
		ProjectMembershipsListDTO projectMembershipsListDTO = apiClient.getProjectMembershipsList();
				
		//Build Map that has List of projectIds for each userId
		Map<String, List<String>> projectIdsByUserIdsMap = new HashMap<>();
		
		List<ProjectMembershipsDTO> pmList = projectMembershipsListDTO.getProjectMembershipsList();		
		for (ProjectMembershipsDTO pmDTO : pmList)
		{
			String projectid = pmDTO.getProjectId();
			String userId = pmDTO.getUserId();
			
			List<String> projectIdsForUser = projectIdsByUserIdsMap.get(userId);
			if (projectIdsForUser == null) {
				projectIdsForUser = new ArrayList<>();
				projectIdsByUserIdsMap.put(userId, projectIdsForUser);
			}			
			projectIdsForUser.add(projectid);
		}
		
		//Build all users list (registers users, then unregistered users)
		List<AllUsersDTO> allUsersList = new ArrayList<>();		
		
		//add registered users
		List<? extends AbstractUsersDTO> registeredUsersList = registeredUsersListDTO.getRegisteredUsersList();
		addUsers(allUsersList, registeredUsersList, REGISTERED_USER_DTO_FIELDS, projectIdsByUserIdsMap);
		
		//add unregistered users
		List<? extends AbstractUsersDTO> unregisteredUsersList = unregisteredUsersListDTO.getUnregisteredUsersList();
		addUsers(allUsersList, unregisteredUsersList, UNREGISTERED_USER_DTO_FIELDS, projectIdsByUserIdsMap);
		
		
		AllUsersListDTO allUsersListDTO = new AllUsersListDTO();
		allUsersListDTO.setAllUsersList(allUsersList);
		
		return allUsersListDTO;
	}
	
	private void addUsers(List<AllUsersDTO> allUsersList, 
			List<? extends AbstractUsersDTO> usersDtoList, 
			Map<String, Field> sourceDtoFields, 
			Map<String, List<String>> projectIdsByUserIdsMap) throws IllegalArgumentException, IllegalAccessException
	{		
		for (AbstractUsersDTO usersDTO : usersDtoList)
		{
			AllUsersDTO allUsersDTO = new AllUsersDTO();
			allUsersList.add(allUsersDTO);
			
			//We need to copy field values from RegisteredUsersDTO to AllUsersDTO (normally we'd use something more
			// graceful for this like an annotation on each field).
			for (String fieldName : sourceDtoFields.keySet()) {				
				Field sourceField = sourceDtoFields.get(fieldName);				
				Field targetField = ALL_USER_DTO_FIELDS.get(fieldName);
				if (targetField != null) {
					sourceField.setAccessible(true);
					targetField.setAccessible(true);
			        Object sourceValue = sourceField.get(usersDTO);
			        targetField.set(allUsersDTO, sourceValue);		  	
				}
			}
						
			//set projectIds
			List<String> projectIds = projectIdsByUserIdsMap.get(allUsersDTO.getId());
			if (projectIds != null && !projectIds.isEmpty())
			{
				allUsersDTO.setProjectIds(projectIds.toArray(new String[projectIds.size()]));	
			}			
		}
	}
	
}
