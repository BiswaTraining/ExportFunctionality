package com.example.ExcelPOC.dto;

public class ExcelResponse {
	private String message;
	private int responseCode;
	public ExcelResponse() {
		super();
	}
	public ExcelResponse(String message, int responseCode) {
		super();
		this.message = message;
		this.responseCode = responseCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	@Override
	public String toString() {
		return "ExcelResponse [message=" + message + ", responseCode=" + responseCode + "]";
	}
}
