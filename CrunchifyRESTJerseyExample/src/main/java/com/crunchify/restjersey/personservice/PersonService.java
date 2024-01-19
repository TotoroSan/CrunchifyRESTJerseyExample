package com.crunchify.restjersey.personservice;

import com.crunchify.restjersey.model.Person;
import com.crunchify.restjersey.model.Response;

// this is the API interface that is exposed to the client
// the client can call any of these functions, setting off according processes
public interface PersonService {
	
	// this method will return a response on being successful
	public Response addPerson(Person p);
	
	public Response deletePerson(int id);
	
	// this method will return the person object
	public Person getPerson(int id);
	
	// this method will return an array of all persons
	public Person[] getAllPersons();

}
