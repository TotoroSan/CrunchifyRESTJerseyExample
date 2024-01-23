package com.crunchify.restjersey.model;


import java.io.Serializable;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;





// property order that will be applied in the document. it does not specify mandatory properties.
@JsonbPropertyOrder({"name", "address", "nationality", "phonenumber", "age"}) 
@Entity(name="Person")
@Table(name="Person")
public class Person implements Serializable{
	//@Id // TODO ADD AUTO GENERATION OF ID LATER 
	@JsonbProperty("id") // this defines the name of an object in the document. if omitted, the attribute name is used.
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String address;
	private String nationality;
	private String phonenumber;
	private int age;

	
	public Person() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
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


	
	// this prints all information about a person to string
	@Override 
	public String toString(){
		return id+"::"+name+"::"+age;
	}

}