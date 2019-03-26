package com.boba.service.exception;

public class EntityNotFoundException extends RuntimeException {

	public EntityNotFoundException(String message) {

		super(message);
	}

	public EntityNotFoundException(Class clazz, long id) {

		super("There is no " + clazz.getName() + " with such id = " + id);
	}
}
