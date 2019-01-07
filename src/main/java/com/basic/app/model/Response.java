package com.basic.app.model;

public class Response<T> {
	
	Status response;
	
	T output;

	public Status getResponse() {
		return response;
	}

	public void setResponse(Status response) {
		this.response = response;
	}

	public T getOutput() {
		return output;
	}

	public void setOutput(T output) {
		this.output = output;
	}
	
	

}
