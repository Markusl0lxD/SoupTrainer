package at.markus.soupTraining.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class BooleanUtil {

	public static File file = new File("plugins/SoupTrainer/Bool.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static void saveCfg() {
		try {
			cfg.save(file);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setBoolean( String thema, Boolean bool) {
		
		cfg.set(thema, bool);
		
		saveCfg();
		
		if(!file.exists()) {
			try {
			file.createNewFile();
			}catch(Exception e) {
				
			}
		}
	}
	
	public static Boolean getBoolean(String thema) {
		
		Boolean bool = (Boolean) cfg.get(thema);
		
		return bool;
		
	}
	
}
