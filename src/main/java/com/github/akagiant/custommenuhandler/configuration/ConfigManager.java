package com.github.akagiant.custommenuhandler.configuration;

public class ConfigManager {

	private ConfigManager() {
		//no instance
	}


	public static Config exampleMenu;

	public static void registerConfigurations() {
		exampleMenu = new Config("example", "customMenus");

	}

}
