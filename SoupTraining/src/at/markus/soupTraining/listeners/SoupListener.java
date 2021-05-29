package at.markus.soupTraining.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import at.markus.soupTraining.main.Main;

public class SoupListener implements Listener{

	Main plugin;
	
	public void SoupListener(Main plugin) {
		this.plugin = plugin;
	}
	
	
	@EventHandler
	public void onPlayerSoup(PlayerInteractEvent event) {
		if(Main.IN_GAME) {
		try {
	if(event.getItem().getType() != Material.MUSHROOM_STEW) return; 
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
			Player player = event.getPlayer();
			double health = player.getHealth();
			ItemStack bowl = new ItemStack(Material.BOWL);
		
			if(health != 20) {
				if(health > 13) {
					player.setHealth(20);
					player.setItemInHand(bowl);
					player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);
				}else {
					player.setHealth(health + 7);
					player.setItemInHand(bowl);
					player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);
				}
			}
				
			double hunger = player.getFoodLevel();
			if(hunger != 20) {
				if(hunger > 17) {
					player.setItemInHand(bowl);
					player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);
					player.setFoodLevel(20);
				}else
					player.setItemInHand(bowl);
				player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);
					player.setFoodLevel((int) (hunger + 3));
				}
			}
		
			}catch(Exception e1) {}
		}
	}
	
}
