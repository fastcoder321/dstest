package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerRestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate template;
    
    @Test
    public void testGetAllUsers() throws Exception {
    	//Call the endpoint
    	URL url = new URL("http://localhost:" + port + "/allusers");       
    	ResponseEntity<AllUsersListDTO> response = template.getForEntity(url.toString(), AllUsersListDTO.class);
     
    	//Assert
    	AllUsersListDTO responseDTO = response.getBody();
        assertThat(responseDTO).isNotNull();
        List<AllUsersDTO> usersList = responseDTO.getAllUsersList();
        assertThat(usersList).isNotEmpty();        

        //Load users into a Map so we can fetch them by id (we could have returned them in a map however it's usually custom
        // to return them in a list so that paginated retrievals can be sorted)
        Map<String, AllUsersDTO> allUserDtoById = usersList.stream()
        	      .collect(Collectors.toMap(AllUsersDTO::getId, Function.identity()));
        
        //Assert user with id=1 in list (registered user)
        AllUsersDTO user = allUserDtoById.get("1");               
        assertThat(user.getId()).isEqualTo("1");
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
        assertThat(user.getLanguageCode()).isEqualTo("en");
        assertThat(user.getEmailAddress()).isEqualTo("last1@mail.com");       
        //assert projectIds
        assertThat(user.getProjectIds().length).isEqualTo(2);
        assertThat(user.getProjectIds()[0]).isEqualTo("1");
        assertThat(user.getProjectIds()[1]).isEqualTo("2");
        
        //Assert user with id=2 in list (registered user with no project association)
        user = allUserDtoById.get("2");               
        assertThat(user.getId()).isEqualTo("2");
        assertThat(user.getCity()).isEqualTo("Adolfofort");
        assertThat(user.getCompany()).isEqualTo("Fisher - Bartoletti");
        assertThat(user.getCountry()).isEqualTo("China");
        assertThat(user.getFirstName()).isEqualTo("firstName 2");
        assertThat(user.getLastName()).isEqualTo("lastName 2");
        assertThat(user.getOrganizationType()).isEqualTo("organizationType 2");
        assertThat(user.getPhone()).isEqualTo("(308) 197-9774 x339");
        assertThat(user.getState()).isEqualTo("CO");
        assertThat(user.getZipCode()).isEqualTo("78569");
        assertThat(user.getDisclaimerAccepted()).isEqualTo("false");
        assertThat(user.getLanguageCode()).isEqualTo("en");
        assertThat(user.getEmailAddress()).isEqualTo("last2@mail.com");       
        //assert projectIds
        assertThat(user.getProjectIds().length).isEqualTo(0);
        
        //Assert user with id=21 in list (unregistered user with project association)
        user = allUserDtoById.get("21");               
        assertThat(user.getId()).isEqualTo("21");
        assertThat(user.getEmailAddress()).isEqualTo("email1@somewhere.com");
        assertThat(user.getLanguageCode()).isEqualTo("en");
        assertThat(user.getRegistrationId()).isEqualTo("jwsMJNOk3oM3hVM5bGcF1");
        assertThat(user.getRegistrationIdGeneratedTime()).isEqualTo("156165026851");   
        //assert projectIds
        assertThat(user.getProjectIds().length).isEqualTo(1);
        assertThat(user.getProjectIds()[0]).isEqualTo("21");
    }
        
}
