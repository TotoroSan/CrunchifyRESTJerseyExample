//package com.crunchify.restjersey.dataservice;
//

// THIS CLASS IS INACTIVE - DELETE ONCE ALL IS GOOD

//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
////
//import com.crunchify.restjersey.model.Person;
//import com.crunchify.restjersey.model.Response;
//
//import jakarta.persistence.EntityManager;
//
//import com.crunchify.restjersey.model.ModelResourceRepository;
////// TODO change to handle complete data management => cache as interface for all data operations
////// read through / write through
//// is this a singleton?
//public class DataManager {
//
//
//	public static Response addPerson(Person person, Response response) {
//
//		ModelResourceRepository.create(person); // ideally i would do this at the end i think TODO
//
//		response.setStatus(true);
//		response.setMessage("Person created successfully");
//		return response;
//	}
//
//	public static Response deletePerson(int id, Response response) {
//		ModelResourceRepository.delete(id);
//		response.setStatus(true);
//		response.setMessage("Person deleted successfully");
//		return response;
//	}
//
//	public static Person getPerson(int id) {
//		return ModelResourceRepository.findById(id); // if it is null, return val is null => will return http 404
//	}
//
//	public static Person[] getAllPersons() {
//			
//		List<Person> personList = ModelResourceRepository.findAll();	
//		Person[] p = new Person[personList.size()];
//		personList.toArray(p);
//
//		return p;
//	}
//	// todo update person 
//}
//
//
//
//
//
//
//// check cache for hit or miss and return / initiate database actions
//// the data manager will manage all operations concerning data of all functions
//
//// could also implement logic to be executed here by passing the called function
////=> but i think its better to keep function logic directly in servlet function