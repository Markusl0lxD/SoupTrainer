package at.markus.soupTraining.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import at.markus.soupTraining.commands.SoupCommand;
import at.markus.soupTraining.inventorys.SettingsInventory;
import at.markus.soupTraining.listeners.Listeners;
import at.markus.soupTraining.listeners.SoupListener;




public class Main extends JavaPlugin{

	public static Main plugin;
	

	
	public static String PREFIX = "§7-[§3§lSoupTrainer§7]- §d";
	public static String NO_PERMISSION = Main.PREFIX+"§cDazu hast du keine Rechte ;(";
	
	public static  Boolean IN_IDLE = false;
	public static  Boolean IN_GAME = false;
	
	PluginManager pluginManager = Bukkit.getPluginManager();
	
	public void onEnable() {
		plugin = this;
		PluginManager pluginManager = Bukkit.getPluginManager();
		
		
		getCommand("soup").setExecutor(new SoupCommand());
		
		pluginManager.registerEvents(new Listeners(), this);
		pluginManager.registerEvents(new SettingsInventory(), this);
		pluginManager.registerEvents(new SoupListener(), this);
		
		Bukkit.getConsoleSender().sendMessage("§c**********************");
		Bukkit.getConsoleSender().sendMessage("§6Name: §4SoupTrainer Plugin");
		Bukkit.getConsoleSender().sendMessage("§6Version: §4early-beta");
		Bukkit.getConsoleSender().sendMessage("§6Minecraft-Version: §41.16.2");
		Bukkit.getConsoleSender().sendMessage("§6Author: §4Markus");
		Bukkit.getConsoleSender().sendMessage("§c**********************");
		
		
	}
	
	
}
