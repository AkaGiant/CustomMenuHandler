package com.github.akagiant.custommenuhandler.configuration.paths;

import lombok.Getter;

@Getter
public enum ConfigPaths {

	// Instead of having to put "my.really.deep.probably.going.to.change.soon.ish.value" you just put "MessagePaths.TEST.path()".
	TEST("my.really.deep.probably.going.to.change.soon.ish.value");

	private final String path;

	ConfigPaths(String path) { this.path = path; }

}

