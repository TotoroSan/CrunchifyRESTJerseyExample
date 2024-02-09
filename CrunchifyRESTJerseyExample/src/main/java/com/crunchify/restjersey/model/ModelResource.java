package com.crunchify.restjersey.model;


// superclass for all ressources / models(Person and Pet are resources / model entityies

// this serves as our parrent class that parents all ressources we  have. 

// NOTE FOR NOW THIS IS NOT AN ENTITY, I WILL JUST SEND AND RECEIVE SPECIFIC BEANS
// TODO once i switch to one API interface for all beans this needs to be an entity so i can unpack sent modelresources
// TODO implement id for this class
// TODO  Check what super does and how we best make subclass data known to the superclass. 
public class ModelResource{
	public ModelResource() {
		super();
	}
}

