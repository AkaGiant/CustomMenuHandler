package com.github.akagiant.custommenuhandler.examples.commands;

import com.github.akagiant.custommenuhandler.system.CustomMenuManager;
import dev.jorel.commandapi.CommandAPICommand;

public class CommandReload {

	public CommandReload() {
		register();
	}

	public void register() {
		new CommandAPICommand("cmh")
			.executesPlayer((player, commandArguments) -> {
				CustomMenuManager.reloadAll();
			})
			.register();
	}

}
