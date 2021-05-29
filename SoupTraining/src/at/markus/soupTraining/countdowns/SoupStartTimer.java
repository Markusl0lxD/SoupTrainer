package at.markus.soupTraining.countdowns;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import at.markus.soupTraining.main.Main;
import at.markus.soupTraining.utils.ItemBuilder;

public class SoupStartTimer {

	private static int taskID;
	public static int timer = 6;
	
	public static void start(Player player) {
		
		 taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
			
			@Override
			public void run() {
				switch(timer) {
				case 5: case 4: case 3: case 2: 
					player.sendMessage(Main.PREFIX +"§bDas Soupen beginnt in §6"+timer+"§b Sekunden :)");
					break;
				case 1: 
					player.sendMessage(Main.PREFIX +"§bDas Soupen beginnt in §6einer §bSekunde:)");
					break;
				case 0: stop();
				player.playSound(player.getLocation(), Sound.BLOCK_GLASS_PLACE, 2, 2);
				for(int i = 0; i<36; i++) {
					player.getInventory().setItem(i, new ItemStack(Material.MUSHROOM_STEW));
				}
				player.getInventory().setItem(15, new ItemBuilder(Material.BROWN_MUSHROOM).setAmount(64).build());
				player.getInventory().setItem(16, new ItemBuilder(Material.RED_MUSHROOM).setAmount(64).build());
				player.getInventory().setItem(17, new ItemBuilder(Material.BOWL).setAmount(64).build());
				player.getInventory().clear();
				player.setGameMode(GameMode.ADVENTURE);
				Main.IN_GAME=true;
				UpdaterCountdown.start(player);
				break;
				}
				
				timer--;
			}
		}, 0, 20);
		
	}
	
	public static void stop() {
		
		Bukkit.getScheduler().cancelTask(taskID);
		timer=6;
	}
	
}
