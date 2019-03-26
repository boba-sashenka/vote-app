package com.boba.service.exception;

public class ThemeNotFoundException extends RuntimeException {

	public ThemeNotFoundException(String link) {

		super("There is no theme with such link = " + link);
	}
}
