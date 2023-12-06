package com.github.akagiant.custommenuhandler;

import com.github.akagiant.custommenuhandler.configuration.Config;
import com.github.akagiant.custommenuhandler.configuration.ConfigManager;
import com.github.akagiant.custommenuhandler.examples.commands.CommandReload;
import com.github.akagiant.custommenuhandler.examples.commands.CommandShop;
import com.github.akagiant.custommenuhandler.system.CustomMenuManager;
import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import lombok.Getter;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomMenuHandler extends JavaPlugin {

	// Anything marked as "not required" is not required to use the CustomMenu System.
	// It's only used as a helping hand to demonstrate the usage of the system.
	// CommandAPI Information - https://commandapi.jorel.dev

	public static final String MENU_FOLDER_NAME = "customMenus";

	@Getter
	private static Plugin plugin;

	// NOT REQUIRED
	@Override
	public void onLoad() {
		CommandAPI.onLoad(new CommandAPIBukkitConfig(this).silentLogs(true));
	}

    @Override
    public void onEnable() {
        // Plugin startup logic
		plugin = this;

		// Not Required
		CommandAPI.onEnable();

		ConfigManager.registerConfigurations();

		Config.createDirectory(MENU_FOLDER_NAME);

		new CommandShop();
		new CommandReload();

		CustomMenuManager.registerCustomMenus();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

		// Not Required
		CommandAPI.onDisable();
    }


}
