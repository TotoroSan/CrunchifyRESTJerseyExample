package com.crunchify.restjersey.model;

import javax.xml.bind.annotation.XmlRootElement;

// this class is an example java bean for storing application data
//(non persistent for now -> will be extended to use database server at some later point)

// this class should actually be in another package, since its not part of the actual service but the data model that lies behind the service

//this specifies that the data belonging to a person will be in an xml section with attribute name = "person"
// so if we get an xml payload, we know where to look for the data we process here
@XmlRootElement (name="person") 
public class Person {
	private String name;
	private String address;
	private String nationality;
	private String phonenumber;
	private int age;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	// this prints all information about a person to string
	@Override 
	public String toString(){
		return id+"::"+name+"::"+age;
	}

}