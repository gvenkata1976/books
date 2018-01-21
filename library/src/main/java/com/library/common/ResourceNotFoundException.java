package com.library.common;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 6611128955106934835L;
	private String code;

	public ResourceNotFoundException(Exception ex) {
		super(ex);
	}

	public ResourceNotFoundException(String code) {
		super(code);
		this.setCode(code);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
