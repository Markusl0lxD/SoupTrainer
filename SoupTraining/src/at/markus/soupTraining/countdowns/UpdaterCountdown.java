package at.markus.soupTraining.countdowns;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import at.markus.soupTraining.main.Main;
import at.markus.soupTraining.utils.ItemBuilder;


public class UpdaterCountdown {

	public static int taskID;
	
	public static void start(Player player) {
		
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
			
			@Override
			public void run() {
				if(Main.IN_GAME) {
					
					double health = player.getHealth(); 
					
					player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1, 1);
					
					
					
					if(health <= 6) {
						Bukkit.getScheduler().cancelTask(taskID);
						player.getInventory().clear();
						
						player.setHealth(0);
						stop(player);
						
					}else {
						
					
					player.setHealth(health- 6);
					
					if(!player.getInventory().contains(Material.MUSHROOM_STEW)) {
						if(!player.getInventory().contains(Material.RED_MUSHROOM)) {
							if(!player.getInventory().contains(Material.BROWN_MUSHROOM)) {
								if(!player.getInventory().contains(Material.BOWL)) {
									for(int i = 0; i<36; i++) {
										player.getInventory().setItem(i, new ItemStack(Material.MUSHROOM_STEW));
									}
									player.playSound(player.getLocation(), Sound.BLOCK_DISPENSER_DISPENSE, 1, 1);
									player.getInventory().setItem(15, new ItemBuilder(Material.BROWN_MUSHROOM).setAmount(64).build());
									player.getInventory().setItem(16, new ItemBuilder(Material.RED_MUSHROOM).setAmount(64).build());
									player.getInventory().setItem(17, new ItemBuilder(Material.BOWL).setAmount(64).build());
									}
								}
								
							}
						}
					
					
					}
				}

			}
		}, 0, 20);
		
		
	}
	
	public static void stop(Player player) {
		Bukkit.getScheduler().cancelTask(taskID);
		Main.IN_GAME = false;
		Main.IN_IDLE = false;
		player.getInventory().clear();
		
	}
	
}
