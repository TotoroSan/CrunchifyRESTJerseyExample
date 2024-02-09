package com.crunchify.restjersey.resourcebrokerservice;

import com.crunchify.restjersey.model.ModelResource;
import com.crunchify.restjersey.model.Person;
import com.crunchify.restjersey.model.Pet;
import com.crunchify.restjersey.model.Response;

//this is the API interface that is exposed to the client
//the client can call any of these functions, setting off the service logic
// everything we want to do in paralell / asynchronously is triggered by event listeners
public interface ResourceBrokerService {
	// this method will return a response on being successful
	public Response addPerson(Person p);
	
	public Response deletePerson(int id);
	
	// this method will return the person object
	public ModelResource getPerson(int id);
	
	// this method will return an array of all persons
	public ModelResource[] getAllPersons();
	
	public Response addPet(Pet p);
	
	public Response deletePet(int id);
	
	public ModelResource getPet(int id);
	
	public ModelResource[] getAllPets();	

}
