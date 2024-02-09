//package com.crunchify.restjersey.personservice;
//
//
// DEPRECEATED REPLACED BY RESOURCEBROKERSERVICEIMPL
//import jakarta.ws.rs.Produces;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.*;
//
//import com.crunchify.restjersey.dataservice.DataManager;
//import com.crunchify.restjersey.model.Person;
//import com.crunchify.restjersey.model.Response;
//
//
//@Path("/person") //path identifier prefix for methods of this service/servlet
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
//public class PersonServiceImpl{
//	
//	@POST @Path("/add") 
//	public Response addPerson(Person p) {
//		Response response = DataManager.addPerson(p, new Response());
//		return response; // this sends the response back in http to the client (when exactly is handled by I/O thread of application server)
//	}
//	
//	@GET @Path("/{id}/delete")
//	public Response deletePerson(@PathParam("id") int id) {
//		//Response response = DataManager.deletePerson(id, new Response());
//		Response response = DataManager.deletePerson(id, new Response());
//		
//		return response;
//
//	}
//
//	@GET @Path("/{id}/get")	
//	public Person getPerson(@PathParam("id") int id) {
//		// this will be transferred back via http to the client, no need to specify the payload structure, the application server handles putting the data into xml. so it can be whatever
//		// of course we would need to refine this if the client expects a certain structure, so it would be necessary to furhter define it
//		return DataManager.getPerson(id); 
//	}
//	
//	@GET @Path("/{id}/getDummy")
//	public Person getDummyPerson(@PathParam("id") int id) {
//		Person p = new Person();
//		p.setAge(99);
//		p.setName("Dummy");
//		p.setId(id);
//		return p;
//	}
////
//	
//	@GET @Path("/getAll")
//	public Person[] getAllPersons() {
//		return DataManager.getAllPersons();
//	}
//
//}
