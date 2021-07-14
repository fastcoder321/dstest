package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExistingEndpointsControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate template;
    
    @Test
    public void testGetUnregisteredUsers() throws Exception {
    	//Call the endpoint
    	URL url = new URL("http://localhost:" + port + "/unregistered");       
    	ResponseEntity<UnregisteredUsersListDTO> response = template.getForEntity(url.toString(), UnregisteredUsersListDTO.class);
     
    	//Assert
    	UnregisteredUsersListDTO responseDTO = response.getBody();
        assertThat(responseDTO).isNotNull();
        List<UnregisteredUsersDTO> usersList = responseDTO.getUnregisteredUsersList();
        assertThat(usersList).isNotNull();
        assertThat(usersList.size()).isEqualTo(15);
        //Assert first object in list
        UnregisteredUsersDTO user = usersList.get(0);        
        assertThat(user.getId()).isEqualTo("21");
        assertThat(user.getEmailAddress()).isEqualTo("email1@somewhere.com");
        assertThat(user.getLanguageCode()).isEqualTo("en");
        assertThat(user.getRegistrationId()).isEqualTo("jwsMJNOk3oM3hVM5bGcF1");
        assertThat(user.getRegistrationIdGeneratedTime()).isEqualTo("156165026851");        
    }
    
    @Test
    public void testGetRegisteredUsers() throws Exception {
    	//Call the endpoint
    	URL url = new URL("http://localhost:" + port + "/registered");       
    	ResponseEntity<RegisteredUsersListDTO> response = template.getForEntity(url.toString(), RegisteredUsersListDTO.class);
     
    	//Assert
        RegisteredUsersListDTO responseDTO = response.getBody();
           assertThat(responseDTO).isNotNull();
           List<RegisteredUsersDTO> usersList = responseDTO.getRegisteredUsersList();
           assertThat(usersList).isNotNull();
           assertThat(usersList.size()).isEqualTo(20);
           //Assert first object in list
           RegisteredUsersDTO user = usersList.get(0);        
           assertThat(user.getId()).isEqualTo("1");
           assertThat(user.getLanguageCode()).isEqualTo("en");
           assertThat(user.getEmailAddress()).isEqualTo("last1@mail.com");           
           assertThat(user.getCity()).isEqualTo("Jaydashire");
           assertThat(user.getCompany()).isEqualTo("Goyette - Renner");
           assertThat(user.getCountry()).isEqualTo("South Africa");
           assertThat(user.getFirstName()).isEqualTo("firstName 1");
           assertThat(user.getLastName()).isEqualTo("lastName 1");
           assertThat(user.getOrganizationType()).isEqualTo("organizationType 1");
           assertThat(user.getPhone()).isEqualTo("524.276.1570 x487");
           assertThat(user.getState()).isEqualTo("SD");
           assertThat(user.getZipCode()).isEqualTo("68048");
           assertThat(user.getDisclaimerAccepted()).isEqualTo("false");           
    }
   
    @Test
    public void testGetProjectMembershipsList() throws Exception {
    	//Call the endpoint
    	URL url = new URL("http://localhost:" + port + "/projectmemberships");       
    	ResponseEntity<ProjectMembershipsListDTO> response = template.getForEntity(url.toString(), ProjectMembershipsListDTO.class);
     
    	//Assert
    	ProjectMembershipsListDTO responseDTO = response.getBody();
        assertThat(responseDTO).isNotNull();
        List<ProjectMembershipsDTO> pmList = responseDTO.getProjectMembershipsList();
        assertThat(pmList).isNotNull();
        assertThat(pmList.size()).isEqualTo(37);
        //Assert first object in list
        ProjectMembershipsDTO pm = pmList.get(0);        
        assertThat(pm.getId()).isEqualTo("1");
        assertThat(pm.getProjectId()).isEqualTo("1");
        assertThat(pm.getUserId()).isEqualTo("1");
    }
    
}
