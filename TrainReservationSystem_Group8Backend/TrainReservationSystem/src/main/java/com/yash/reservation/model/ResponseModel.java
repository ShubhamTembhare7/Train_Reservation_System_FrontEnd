package com.yash.reservation.model;

import org.springframework.stereotype.Component;

@Component
public class ResponseModel {

	private String responseCode;
	private String responseMessage;
	private String responseDisc;
	private Object responseObj;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseDisc() {
		return responseDisc;
	}

	public void setResponseDisc(String responseDisc) {
		this.responseDisc = responseDisc;
	}

	public Object getResponseObj() {
		return responseObj;
	}

	public void setResponseObj(Object responseObj) {
		this.responseObj = responseObj;
	}

}
