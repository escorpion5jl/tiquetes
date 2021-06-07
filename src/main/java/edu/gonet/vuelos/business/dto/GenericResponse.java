package edu.gonet.vuelos.business.dto;

public class GenericResponse<T> {
	
	private Integer responseCode;
	
	private String message;
	
	private T data;
	
	public GenericResponse() { }
	
	public GenericResponse(T data) { 
		this.data = data;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
