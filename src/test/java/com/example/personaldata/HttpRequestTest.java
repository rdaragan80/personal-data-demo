package com.example.personaldata;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.example.personaldata.model.Address;
import com.example.personaldata.model.Person;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
//		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
//				String.class)).contains("Hello, World");
	}
	
	private String getRootUrl() {
	    return "http://localhost:" + port;
    }
	
	public  double getRandomIntegerBetweenRange(double min, double max){
	    double x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	@Test
	public void testCreatePerson() {
		Person person = new Person();
		int randomNum = (int) getRandomIntegerBetweenRange(10L,100000L);
		person.setFirstName("Test-User-"+randomNum);
		person.setLastName("Duglas-"+randomNum);

		ResponseEntity<Person> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/persons", person, Person.class);
		assertThat(postResponse).isNotNull();
		assertThat(postResponse.getBody()).isNotNull();
	}
	
	@Test
	public void testCreateAddress() {
		Address address = new Address();
		int randomNum = (int) getRandomIntegerBetweenRange(10L,100000L);
		address.setAddressType("SINGLE OCCUPANCY RESIDENTIAL BUILDING-"+randomNum);
		address.setCity("San Francisco");
		address.setPhoneNumber("415-654-3245");
		address.setPostalCode("94321");
		address.setState("California");
		address.setStreet("1234 Lincoln Way");

		ResponseEntity<Address> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/address/person/1", address, Address.class);
		assertThat(postResponse).isNotNull();
		assertThat(postResponse.getBody()).isNotNull();
	}
	
	@Test
	public void testGetCountPersons() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/persons/count",
				HttpMethod.GET, entity, String.class);
		
		assertThat(response.getBody()).isNotNull();
	}
	
	@Test
	public void testUpdatePerson() {
		int id = 1;
		int randomNum = (int) getRandomIntegerBetweenRange(10L,100L);
		Person person = restTemplate.getForObject(getRootUrl() + "/api/v1/persons/" + id, Person.class);
		person.setFirstName("Name-"+randomNum);
		person.setLastName("Last-"+randomNum);

		restTemplate.put(getRootUrl() + "/api/v1/persons/" + id, person);

		Person updatedPerson = restTemplate.getForObject(getRootUrl() + "/api/v1/persons/" + id, Person.class);
		assertThat(updatedPerson).isNotNull();
	}

	@Test
	public void testDeletePerson() {
		int id = 2;
		Person person = restTemplate.getForObject(getRootUrl() + "/api/v1/persons/" + id, Person.class);
		assertThat(person).isNotNull();

		restTemplate.delete(getRootUrl() + "/api/v1/persons/" + id);

		try {
			person = restTemplate.getForObject(getRootUrl() + "/api/v1/persons/" + id, Person.class);
		} catch (final HttpClientErrorException e) {
			assertThat(e.getStatusCode().equals(HttpStatus.NOT_FOUND));
		}
	}
}
