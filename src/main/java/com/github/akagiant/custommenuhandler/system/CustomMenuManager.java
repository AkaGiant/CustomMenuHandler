package com.github.akagiant.custommenuhandler.system;

import com.github.akagiant.custommenuhandler.CustomMenuHandler;
import com.github.akagiant.custommenuhandler.configuration.Config;
import com.github.akagiant.custommenuhandler.utility.Logger;
import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.PlayerArgument;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomMenuManager {

	public static List<String> registeredCommands = new ArrayList<>();

	public static void registerCustomMenus() {
		List<Config> configList = Config.getAll(CustomMenuHandler.MENU_FOLDER_NAME);
		if (configList.isEmpty()) {
			Bukkit.getLogger().severe("No Menus Found");
			return;
		}

		Logger.debug("Registering New Commands");
		for (Config config : configList) {
			CustomMenu menu = new CustomMenu(config);
			if (menu.getCommandToOpen() ==  null) continue;

			boolean requiresPermission = menu.isRequiresPermissionToOpen();


			new CommandAPICommand(menu.getCommandToOpen())
				.withPermission(requiresPermission
					? CommandPermission.fromString(menu.getPermissionToOpen())
					: CommandPermission.NONE)
				.withOptionalArguments(new PlayerArgument("target"))
				.executesPlayer((player, commandArguments) -> {
					Player target = (Player) commandArguments.get("target");
					if (target == null) target = player;

					menu.open(target);

				})
					.register();


			Logger.debug("Adding Command to List");
			registeredCommands.add(menu.getCommandToOpen());
			Logger.debug("New Custom Menu Registered: " + menu.getCommandToOpen());
		}

	}

	public static void reloadAll() {
		Logger.debug("Unregistering Commands");
		for (String registeredCommand : registeredCommands) {
			Logger.debug("Unregistering: " + registeredCommand);
			CommandAPI.unregister(registeredCommand);
		}

		Logger.debug("Registering New Commands");
		registerCustomMenus();
	}

}
