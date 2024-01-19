package com.crunchify.restjersey.personservice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.crunchify.restjersey.dataservice.DatabaseAgent;
import com.crunchify.restjersey.model.Person;
import com.crunchify.restjersey.model.Response;
import com.crunchify.restjersey.dataservice.DataManager;

import java.io.*;
//import javax.servlet.*;
// this class handles the logic behind the interface functions
// separating this from the actual data model class is important for being clean
// because this class creates and modifies persons, the other class just is the model to store data 
// otherwise we would need to create and delete persons directly from within the model class
// then we would also have the response logic in the model class which is shit 
// and we would need to store persons that exist in a data structure within a person object which also does not make sense

@Path("/person") //path identifier prefix for methods of this service/servlet
@Consumes(MediaType.APPLICATION_XML) // expects XML payload 
@Produces(MediaType.APPLICATION_XML) // sends XML payload of retreived data back
public class PersonServiceImpl implements PersonService {
	

	
	// the whole class is the servlet class => if not instantiated the app server will create an instance and initialize it (if there is an initializer)
	
	// setting this static makes it so that it is shared by all members of the class.
	// the class is never actually instantiated, members wihtin it are just called.
	// the static field will ALWAYS be part of the class and is created on compiling the whole code 
	// this serves as storage for our existing person objects => of course we would use a database as storage in a real scenario
	// it will persist as long as the server is up 
		
	@Override 
	@POST // this method will be triggered on the client posting something => a get request has no effect here and would not trigger a response
    @Path("/add") // path identifier for this method in the service 
	public Response addPerson(Person p) {
		
		// notice that the person object will already be passed here, so we don't instantiate a new object
		// for this the client needs to know the person class xml strucutre (right? is that good design?)
		// since we did not specify the parameter to be passed in the uri, 
		// the body of the http post request needs to contain xml that fits the format defined in the person bean
		// by defining the xml structure of a person payload, the xml file is equal to a person object and will be treated as such
		// since we do not have any constructors in the person bean, a minimal person xml object would be <person> </person> 
		// the body can also include elements with undefined names, which are ignored.
		// so the creation of the actual person object is done in the background and by interpreting the xml 
		// if we do not use path parameters but normal ones, the service always expects the argument to be in the payload. 
		//we just have to define the element name for it in the according class
		Response response = DataManager.addPerson(p, new Response());
		return response; // this sends the response back in http to the client (when exactly is handled by I/O thread of application server)
	}

	@Override
	@GET
    @Path("/{id}/delete")
	public Response deletePerson(@PathParam("id") int id) {
		Response response = DataManager.deletePerson(id, new Response());
		return response;

	}

	@Override
	@GET
	@Path("/{id}/get")
	public Person getPerson(@PathParam("id") int id) {
		// this will be transferred back via http to the client, no need to specify the payload structure, the application server handles putting the data into xml. so it can be whatever
		// of course we would need to refine this if the client expects a certain structure, so it would be necessary to furhter define it
		return DataManager.getPerson(id); 
	}
	
	@GET
	@Path("/{id}/getDummy")
	public Person getDummyPerson(@PathParam("id") int id) {
		Person p = new Person();
		p.setAge(99);
		p.setName("Dummy");
		p.setId(id);
		return p;
	}

	@Override
	@GET
	@Path("/getAll")
	public Person[] getAllPersons() {
		return DataManager.getAllPersons();
	}

}
