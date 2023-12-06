package com.github.akagiant.custommenuhandler.system.exceptions;

public class DuplicateMenuException extends RuntimeException {

	public DuplicateMenuException(String id) {
		super("Duplicate Menu Found: " + id);
	}

}
