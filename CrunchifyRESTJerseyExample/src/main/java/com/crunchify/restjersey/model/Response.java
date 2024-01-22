package com.crunchify.restjersey.model;

// json b bindings (used by YASSON implementation of json-b API
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;


@JsonbPropertyOrder({"status", "message"})
public class Response {
	
	
	private boolean status;
	private String message;
	
	public Response(){ // needed for JSON-B
		super();
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}