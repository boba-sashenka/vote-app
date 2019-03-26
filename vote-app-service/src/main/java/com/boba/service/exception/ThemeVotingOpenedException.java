package com.boba.service.exception;

public class ThemeVotingOpenedException extends RuntimeException {

	public ThemeVotingOpenedException(long themeId) {

		super("The voting on theme with id = " + themeId + " is opened now.");
	}
}
