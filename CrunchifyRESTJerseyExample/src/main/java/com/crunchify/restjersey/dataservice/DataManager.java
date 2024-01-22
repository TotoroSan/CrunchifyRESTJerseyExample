package com.crunchify.restjersey.dataservice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//
import com.crunchify.restjersey.model.Person;
import com.crunchify.restjersey.model.Response;
//// TODO change to handle complete data management => cache as interface for all data operations
//// read through / write through
// is this a singleton?
public class DataManager {

	// temporarily store person data
	private static Map<Integer,Person> personCache = new HashMap<Integer,Person>();


	public static Response addPerson(Person person, Response response) {
		if(personCache.get(person.getId()) != null){
			response.setStatus(false);
			response.setMessage("Person Already Exists");
			return response;
		}

		personCache.put(person.getId(), person);
		response.setStatus(true);
		response.setMessage("Person created successfully");
		return response;
	}

	public static Response deletePerson(int id, Response response) {
		if(personCache.get(id) == null){
			response.setStatus(false);
			response.setMessage("Person Doesn't Exist");
			return response;
		}
		personCache.remove(id);
		response.setStatus(true);
		response.setMessage("Person deleted successfully");
		return response;
	}

	public static Person getPerson(int id) {
		return personCache.get(id); // if it is null, return val is null => will return http 404
	}

	public static Person[] getAllPersons() {
		Set<Integer> ids = personCache.keySet();
		Person[] p = new Person[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = personCache.get(id);
			i++;
		}
		return p;
	}
}






// check cache for hit or miss and return / initiate database actions
// the data manager will manage all operations concerning data of all functions

// could also implement logic to be executed here by passing the called function
//=> but i think its better to keep function logic directly in servlet function