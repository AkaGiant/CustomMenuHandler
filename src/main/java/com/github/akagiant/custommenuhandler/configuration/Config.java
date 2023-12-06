package com.github.akagiant.custommenuhandler.configuration;

import com.github.akagiant.custommenuhandler.CustomMenuHandler;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Config {

	private static Plugin plugin = CustomMenuHandler.getPlugin();
	private final String fileName;
	private FileConfiguration fileConfiguration;
	@Getter
	private File file;

	@SuppressWarnings("ConstantConditions")
	public Config(String fileName) {
		this.fileName = fileName;
		file = new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + fileName + ".yml");
		saveDefaultConfig();
		fileConfiguration = YamlConfiguration.loadConfiguration(file);
	}

	@SuppressWarnings("ConstantConditions")
	public Config(String fileName, String subFolder) {
		this.fileName = fileName;

		file = new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + subFolder + File.separator + fileName + ".yml");
		saveDefaultConfig(subFolder);
		fileConfiguration = YamlConfiguration.loadConfiguration(file);
	}


	public FileConfiguration getConfig() { return fileConfiguration; }

	public static Config get(String fileName) {
		File file = getFile(fileName);
		if (!file.exists()) return null;
		return new Config(file.getName().replace(".yml", ""));
	}

	public static Config get(String fileName, String directory) {
		File file = getFile(fileName, directory);
		if (!file.exists()) return null;
		return new Config(file.getName().replace(".yml", ""), directory);
	}

	public static FileConfiguration getConfig(String configName) throws NullPointerException {
		File file = getFile(configName);
		if (file == null) return null;
		return YamlConfiguration.loadConfiguration(file);
	}

	public static FileConfiguration getConfig(String configName, String subFolder) throws NullPointerException {
		File file = getFile(configName, subFolder);
		if (file == null) return null;
		return YamlConfiguration.loadConfiguration(file);
	}


	@SuppressWarnings("ConstantConditions")
	public static File getFile(String configName) throws NullPointerException {
		File file = new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + configName + ".yml");
		if (file.exists()) return file;
		return null;
	}

	public static List<Config> convertToConfigs(List<File> files, String directory) throws NullPointerException {
		List<Config> configList = new ArrayList<>();
		for (File file1 : files) {
			configList.add(new Config(file1.getName(), directory));
		}
		return configList;
	}

	@SuppressWarnings("ConstantConditions")
	public static File getFile(String configName, String subFolder) throws NullPointerException {
		File file = new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + subFolder + File.separator + configName + ".yml");
		if (file.exists()) return file;
		return null;
	}

	public boolean exists() { return file.exists(); }
	static boolean exists(File file) { return file.exists(); }

	public void saveConfig() {
		try {
			this.getConfig().save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("ConstantConditions")
	private void saveDefaultConfig() {
		if (file == null)
			file = new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + fileName + ".yml");

		if (!file.exists()) {
			plugin.saveResource(fileName + ".yml", false);
		}
	}

	@SuppressWarnings("ConstantConditions")
	public void saveDefaultConfig(String subDirectory) {
		if (file == null)
			file = new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + subDirectory + File.separator + fileName + ".yml");

		if (!file.exists()) {
			plugin.saveResource(subDirectory + File.separator + fileName + ".yml", false);
		}
	}


	public void reloadConfig() {
		if (!exists()) {
			String fileName2 = fileName.formatted("%s.yml does not exist!");
			Bukkit.getLogger().severe(fileName2);
			return;
		}
		fileConfiguration = YamlConfiguration.loadConfiguration(file);
		InputStream stream = plugin.getResource(fileName);
		if (stream != null) {
			YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(stream));
			fileConfiguration.setDefaults(defaultConfig);
		}
	}

	public static List<File> getAllConfigurationFiles() { return listf(plugin.getDataFolder().getAbsolutePath()); }

	private static List<File> listf(String directoryName) {
		File directory = new File(directoryName);

		List<File> resultList = new ArrayList<>();

		// get all the files from a directory
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isFile()) {
				resultList.add(file);
			} else if (file.isDirectory()) {
				resultList.addAll(listf(file.getAbsolutePath()));
			}
		}
		return resultList;
	}
	public static void reloadConfig(File file) {
		if (!exists(file)) {
			Bukkit.getLogger().severe(file.getName() + ".yml does not exists!");
			return;
		}
		YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		InputStream stream = plugin.getResource(file.getName());
		if (stream != null) {
			YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(stream));
			config.setDefaults(defaultConfig);
		}
	}

	public static Config create(String fileName) {

		File file = new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + fileName + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new Config(fileName);
	}

	public static Config create(String fileName, String subFolder) {

		File file = new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + subFolder + File.separator + fileName + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);

		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new Config(fileName, subFolder);
	}

	private static Config convertToConfig(File file) throws NullPointerException {
		return new Config(file.getName().replace(".yml", ""));
	}

	public static List<Config> getAll(@Nullable String directory) {
		List<File> files;
		if (directory == null) {
			files = Config.listf(CustomMenuHandler.getPlugin().getDataFolder().getAbsolutePath());
		} else {
			files = Config.listf(CustomMenuHandler.getPlugin().getDataFolder().getAbsolutePath() + File.separator + directory);
		}

		if (files.isEmpty()) {
			Bukkit.getLogger().severe("FILES ARE EMPTY");
			return new ArrayList<>();
		}

		List<Config> configList = new ArrayList<>();

		for (File file1 : files) {
			configList.add(new Config(file1.getName().replace(".yml", ""), directory));
		}
		return configList;
	}

	public static void createDirectory(String directory) {
		new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + directory).mkdirs();
	}
}


