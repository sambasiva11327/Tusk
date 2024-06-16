package com.ss.springboot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ResouceName;
	private String FieldName;
	private Object FieldValue;
	public ResourceNotFoundException(String resouceName, String fieldName, Object fieldValue) {
		super();
		ResouceName = resouceName;
		FieldName = fieldName;
		FieldValue = fieldValue;
	}
	public String getResouceName() {
		return ResouceName;
	}public String getFieldName() {
		return FieldName;
	}public Object getFieldValue() {
		return FieldValue;
	}
}
