package at.markus.soupTraining.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class LocationUtil {

	public static File file = new File("plugins/SoupTrainer/locations.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static void saveCfg() {
		try {
			cfg.save(file);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setLocation(String name, Location loc) {
		cfg.set(name+".world", loc.getWorld().getName());
		cfg.set(name+".x", loc.getX());
		cfg.set(name+".y", loc.getY());
		cfg.set(name+".z", loc.getZ());
		cfg.set(name+".yaw", loc.getYaw());
		cfg.set(name+".pitch", loc.getPitch());
		saveCfg();
		if(!file.exists()) {
			try {
			file.createNewFile();
			}catch(Exception e) {
				
			}
		}
	}
	
	public static Location getLocation(String name) {
		
		
		World world = Bukkit.getWorld(cfg.getString(name+".world"));
		double x = cfg.getDouble(name+".x");
		double y = cfg.getDouble(name+".y");
		double z = cfg.getDouble(name+".z");
		Location loc = new Location(world, x, y, z);
		loc.setYaw(cfg.getInt(name+".yaw"));
		loc.setPitch(cfg.getInt(name+".pitch"));
		

		return loc;
	}
	
}
