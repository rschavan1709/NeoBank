package com.neosoft.utility;

import org.springframework.stereotype.Component;

@Component
public class BaseResponse<T> {
	private int statusCode;
	private String message;
	private T dataT;
	
	public BaseResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BaseResponse(int statusCode, String message, T dataT) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.dataT = dataT;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getDataT() {
		return dataT;
	}
	public void setDataT(T dataT) {
		this.dataT = dataT;
	}

	@Override
	public String toString() {
		return "BaseResponse [statusCode=" + statusCode + ", message=" + message + ", dataT=" + dataT + "]";
	}
	
	
}
