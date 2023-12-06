package com.github.akagiant.custommenuhandler.utility;

import com.github.akagiant.custommenuhandler.CustomMenuHandler;
import org.bukkit.Bukkit;

public class Logger {

	private static final String PLUGIN_NAME = CustomMenuHandler.getPlugin().getName();

	private Logger() {
		//no instance
	}

	public static void warn(String msg) {
		Bukkit.getConsoleSender().sendMessage(
			ColorManager.formatColours("&8[&6" + PLUGIN_NAME + " &6&lWARN&8] " + msg)
		);
	}


	public static void severe(String msg) {
		Bukkit.getConsoleSender().sendMessage(
			ColorManager.formatColours("&8[&c" + PLUGIN_NAME + " &c&lSEVERE&8] &f" + msg)
		);
	}

	public static void debug(String msg) {
		Bukkit.getConsoleSender().sendMessage(
			ColorManager.formatColours("&8[&c" + PLUGIN_NAME + " &a&lDEBUG&8] &f" + msg)
		);
	}

	public static void toConsole(String msg) {
		Bukkit.getConsoleSender().sendMessage(
			ColorManager.formatColours("&8[&b" + PLUGIN_NAME + "&8] " + msg)
		);
	}
}

