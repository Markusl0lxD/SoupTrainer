package at.markus.soupTraining.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import at.markus.soupTraining.main.Main;

public class Listeners implements Listener{
	
	
	@EventHandler
	public static void onDrop(PlayerDropItemEvent event) {
		
		if(Main.IN_GAME) {
			event.getItemDrop().remove();
			
		}
		
	}
	
}
