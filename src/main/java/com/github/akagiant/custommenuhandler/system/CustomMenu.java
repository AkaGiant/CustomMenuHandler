package com.github.akagiant.custommenuhandler.system;

import com.github.akagiant.custommenuhandler.CustomMenuHandler;
import com.github.akagiant.custommenuhandler.configuration.Config;
import com.github.akagiant.custommenuhandler.configuration.ConfigUtil;
import com.github.akagiant.custommenuhandler.system.exceptions.WonkyCustomMenuException;
import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.gui.type.util.Gui;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class CustomMenu {

	@Getter
	private final Config config;

	private int rows;
	private int columns;

	private String title;
	@Getter
	private String permissionToOpen;
	@Getter
	private boolean requiresPermissionToOpen;
	@Getter
	private String commandToOpen;

	public CustomMenu(Config config) {

		// Not all Menus require a Command to open it.
		Optional<String> commandToOpen = ConfigUtil.getString(config, "command-to-open");
		this.commandToOpen = commandToOpen.orElse(null);

		boolean permissionToOpenIsSet = ConfigUtil.isSet(config, "permission-to-open");
		this.requiresPermissionToOpen = permissionToOpenIsSet;
		if (this.requiresPermissionToOpen) {
			Optional<String> permissionToOpen = ConfigUtil.getString(config, "permission-to-open");
			this.permissionToOpen = permissionToOpen.orElse(null);
		}
		// Not all Menus require a permission to open.


		this.config = config;
	}

	public CustomMenu(@Nullable String commandToOpen, @Nullable String permission, @NotNull Config config) {

		this.commandToOpen = commandToOpen;

		if (permission == null) this.requiresPermissionToOpen = false;
		else this.permissionToOpen = permission;

		this.config = config;
	}

	public void open(Player player) {
		ChestGui chestGui = new ChestGui(3, "lol");
		chestGui.show(player);

	}
}
