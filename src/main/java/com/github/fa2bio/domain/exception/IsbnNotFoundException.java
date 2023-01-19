package com.github.fa2bio.domain.exception;

public class IsbnNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public IsbnNotFoundException(String message) {
		super(message);
	}
}
