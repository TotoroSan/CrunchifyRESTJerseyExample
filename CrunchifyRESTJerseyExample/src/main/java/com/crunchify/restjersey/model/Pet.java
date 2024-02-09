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
@JsonbPropertyOrder({"name", "type", "sex", "age", "ownerid"}) 
@Entity(name="Pet")
@Table(name="Pet")
public class Pet extends ModelResource implements Serializable{
	// TODO ADD AUTO GENERATION OF ID LATER 
	@JsonbProperty("id") // this defines the name of an object in the document. if omitted, the attribute name is used.
	@Id
	@GeneratedValue // TODO generation does not work i think 
	private int id;
	
	private String name;
	private String type;
	private String sex;
	private int age;
	private int ownerid;
	
	
	
	public Pet() {
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




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getSex() {
		return sex;
	}




	public void setSex(String sex) {
		this.sex = sex;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public int getOwnerid() {
		return ownerid;
	}




	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}




	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", sex=" + sex + ", age=" + age + ", ownerid="
				+ ownerid + "]";
	}

}