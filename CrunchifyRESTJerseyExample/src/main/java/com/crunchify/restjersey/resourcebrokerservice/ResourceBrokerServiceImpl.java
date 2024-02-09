package com.crunchify.restjersey.resourcebrokerservice;

import java.util.List;

import com.crunchify.restjersey.model.ModelResource;
import com.crunchify.restjersey.model.ModelResourceRepository;
import com.crunchify.restjersey.model.Person;
import com.crunchify.restjersey.model.Pet;
import com.crunchify.restjersey.model.Response;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("") // TODO check how i can remove this -> without it doesnt work but it should
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ResourceBrokerServiceImpl implements ResourceBrokerService {
	
	// PERSON SERVICE
	
	@Override
	@POST @Path("/person/add") 
	public Response addPerson(Person p) {
		ModelResourceRepository.create(p);
		Response response = new Response();
		response.setMessage("Person created successfully");
		return response; // this sends the response back in http to the client (when exactly is handled by I/O thread of application server)
	}
	
	@Override
	@GET @Path("/person/{id}/delete")
	public Response deletePerson(@PathParam("id") int id) {
		ModelResourceRepository.delete(id, new Person()); // TODO new person is placeholder fix and go away from person 
		Response response = new Response();
		response.setStatus(true);
		response.setMessage("Person deleted successfully");
		return response;

	}
	
	@Override
	@GET @Path("/person/{id}/get")	
	public ModelResource getPerson(@PathParam("id") int id) {
		// this will be transferred back via http to the client, no need to specify the payload structure, the application server handles putting the data into xml. so it can be whatever
		// of course we would need to refine this if the client expects a certain structure, so it would be necessary to furhter define it
		//Person p = (Person) ModelResourceRepository.findById(id, new Person());
		return ModelResourceRepository.findById(id, new Person());
	}
	
	// TODO streamline return values. i can cast resource to the according type. can this cause any problems? if yes just always return modelresource
	@Override
	@GET @Path("/person/getAll")
	public Person[] getAllPersons() {
		List<ModelResource> personList = ModelResourceRepository.findAll(new Person());	
		Person[] p = new Person[personList.size()];
		personList.toArray(p);

		return p;
	}
	
	//--------------------------------------------------------------------------------------------------------------
	
	// PET SERVICE
	
	@Override
	@POST @Path("/pet/add") 
	public Response addPet(Pet p) {
		ModelResourceRepository.create(p);
		Response response = new Response();
		response.setMessage("Person created successfully");
		return response; // this sends the response back in http to the client (when exactly is handled by I/O thread of application server)
	}

	@Override
	@GET @Path("/pet/{id}/delete")
	public Response deletePet(@PathParam("id") int id) {
		ModelResourceRepository.delete(id, new Pet()); // TODO new person is placeholder fix and go away from person 
		Response response = new Response();
		response.setStatus(true);
		response.setMessage("Pet deleted successfully");
		return response;
	}

	@Override
	@GET @Path("/pet/{id}/get")	
	public ModelResource getPet(@PathParam("id") int id) {
		// this will be transferred back via http to the client, no need to specify the payload structure, the application server handles putting the data into xml. so it can be whatever
		// of course we would need to refine this if the client expects a certain structure, so it would be necessary to furhter define it
		//Person p = (Person) ModelResourceRepository.findById(id, new Person());
		return ModelResourceRepository.findById(id, new Pet()); 
	}

	@Override
	@GET @Path("/pet/getAll")
	public Pet[] getAllPets() {
		List<ModelResource> petList = ModelResourceRepository.findAll(new Pet());	
		Pet[] p = new Pet[petList.size()];
		petList.toArray(p);

		return p;
	}

}
