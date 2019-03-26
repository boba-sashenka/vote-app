package com.boba.service.exception;

public class ThemeVotingClosedException extends RuntimeException {

	public ThemeVotingClosedException(long themeId) {

		super("The voting on theme with id = " + themeId + " is closed now.");
	}
}
