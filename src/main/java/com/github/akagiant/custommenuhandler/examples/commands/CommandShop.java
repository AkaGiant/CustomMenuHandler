package com.github.akagiant.custommenuhandler.examples.commands;

import dev.jorel.commandapi.CommandAPICommand;

public class CommandShop {

	public CommandShop() {
		register();
	}

	public void register() {
		new CommandAPICommand("shop")
			.executesPlayer((player, commandArguments) -> {

			})
			.register();
	}

}
