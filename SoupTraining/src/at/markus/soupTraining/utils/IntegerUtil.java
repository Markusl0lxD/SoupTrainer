package at.markus.soupTraining.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class IntegerUtil {

	public static File file = new File("plugins/SoupTrainer/Integers.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	
	public static void saveCfg() {
		try {
			cfg.save(file);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void setInteger(Player player, String thema, Integer integer) {
	
		cfg.set(player.getName()+" "+thema, integer);
		saveCfg();
		
		if(!file.exists()) {
			try {
			file.createNewFile();
			}catch(Exception e) {
				
			}
		}
	}
	
	public static Integer getInteger(String thema, Player player) {
	
		Integer integer = cfg.getInt(player.getName()+" "+thema);
		
		return integer;
		
	}
}
