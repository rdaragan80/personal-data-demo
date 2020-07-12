package com.example.personaldata.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.personaldata.exception.ResourceNotFoundException;
import com.example.personaldata.model.Address;
import com.example.personaldata.model.Person;
import com.example.personaldata.repository.AddressRepository;
import com.example.personaldata.repository.PersonRepository;
import com.example.personaldata.service.PersonalDataService;

/*
 Provide help
1. ---Add Person (id, firstName, lastName)
2. ----Edit Person (firstName, lastName)
3. ----Delete Person (id)
4. ---Add Address to person [multiple required] (id, street, city, state, postalCode)
5. ---Edit Address (street, city, state, postalCode)
6.---- Delete Address (id)
7. --Count Number of Persons
8. ---List Persons
 */

@RestController
@RequestMapping("/api/v1")
public class PersonalDataController {
	
	 @Autowired
	 private PersonalDataService personalDataService;
	
	 private static final Logger LOGGER  = LogManager.getLogger(PersonalDataController.class);

	/**
	 * List all Persons information
	 * @return List with all persons
	 */
	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("in getAllPersons() method.");
		}
		return personalDataService.getAllPersons();
	}
	
	/**
	 * List all Persons information
	 * @return String message with count info
	 */
	@GetMapping("/persons/count")
	public String countAllPersons() {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("in countAllPersons() method.");
		}
		return personalDataService.countAllPersons();
	}

	/**
	 * View person info by person id.
	 * @param long id
	 * @return ResponseEntity<Person> that exists for id
	 * @throws ResourceNotFoundException (if person not found)
	 */
	@GetMapping("/persons/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long personId)
			throws ResourceNotFoundException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("in getPersonById() method.");
		}
		return personalDataService.getPersonById(personId);
	}

	/**
	 * Create new person
	 * @param Person object
	 * @return ResponseEntity<Person> - Person object created.
	 */
	@PostMapping("/persons")
	public ResponseEntity<Person>  createPerson(@Valid @RequestBody Person person) {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("in createPerson() method.");
		}
		return personalDataService.createPerson(person);
	}

	/**
	 * Updates person
	 * @param long personId
	 * @param Person personDetails
	 * @return Person object updated
	 * @throws ResourceNotFoundException  (if person not found)
	 */
	@PutMapping("/persons/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId,
			                                   @RequestBody Person personDetails) 
			                                   throws ResourceNotFoundException {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("in updatePerson() method.");
		}
		return personalDataService.updatePerson(personId,personDetails);
	}
	
	
	/**
	 * Delete person by id
	 * @param long personId
	 * @return Map<String, Boolean> ex: {"deleted", true}
	 * @throws ResourceNotFoundException (if person not found)
	 */
	@DeleteMapping("/persons/{id}")
	public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long personId)
			throws ResourceNotFoundException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("in deletePerson() method.");
		}
		return personalDataService.deletePerson(personId);
	}
	
	/**
	 * Create new address and link with person
	 * @param long personId ( to whom this address )
	 * @param Address object
	 * @return ResponseEntity<Address> - Address object created.
	 */
	@PostMapping("/address/person/{id}")
	public ResponseEntity<Address>  createAddress(@PathVariable(value = "id") Long personId, 
			                                      @Valid @RequestBody Address address) 
			                                      throws ResourceNotFoundException{
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("in createAddress() method.");
		}		
		return personalDataService.createAddress(personId, address);  
	}
	
	/**
	 * Updates person's address
	 * @param long personId
	 * @param long addressId
	 * @param Address addressDetails
	 * @return Address updated
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/persons/{id}/address/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable(value = "id") Long personId,
			@PathVariable(value = "id") Long addressId,
			@RequestBody Address addressDetails) throws ResourceNotFoundException {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("in updateAddress() method.");
		}
		return personalDataService.updateAddress(personId,addressId,addressDetails);
	}
	
	/**
	 * Delete address that is associated with person
	 * @param long personId
	 * @param long addressId
	 * @return Map with status of operation
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/persons/{id}/address/{id}")
	public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") Long personId,
			                                 @PathVariable(value = "id") Long addressId)
			                                 throws ResourceNotFoundException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("in deleteAddress() method.");
		}
		return personalDataService.deleteAddress(personId,addressId);		
	}
}
