package com.boba.service.exception;

public class NoInstanceException extends RuntimeException {

	public NoInstanceException(Class clazz) {

		super("You can not create instancxe of " + clazz.getName());
	}
}
