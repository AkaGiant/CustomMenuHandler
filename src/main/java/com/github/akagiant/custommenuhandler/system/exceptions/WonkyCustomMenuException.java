package com.github.akagiant.custommenuhandler.system.exceptions;

public class WonkyCustomMenuException extends RuntimeException {

	public WonkyCustomMenuException(String mineId, String message) {
		super("Menu ID: " + mineId + " " + message);
	}

}

