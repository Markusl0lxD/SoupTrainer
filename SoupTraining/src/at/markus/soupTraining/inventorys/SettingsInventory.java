package at.markus.soupTraining.inventorys;

import java.awt.Desktop;
import java.net.URI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import at.markus.soupTraining.main.Main;
import at.markus.soupTraining.utils.BooleanUtil;
import at.markus.soupTraining.utils.ItemBuilder;
import at.markus.soupTraining.utils.LocationUtil;

public class SettingsInventory implements Listener{

	public static Inventory inv;
	
	public static void SettingsInventory(Player player) {
		
		 inv = Bukkit.createInventory(null, 9*3, "§4§lSettings");
		inv.setItem(11, new ItemBuilder(Material.PAPER).setName("§c§lTeleportation").setLore("§6",
																							 "§5Description:",
																							 "§bLässt beim Starten den",
																							 "§bSpieler zu einer bestimmten Position",
																							 "§bteleportieren.",
																							 "§b",
																							 "§8[Linksklicken/Rechtsklicken]").build());
		
		inv.setItem(15, new ItemBuilder(Material.GOLDEN_APPLE).setName("§c§lPREMIUM EDITION").setLore("§6",
				 "§bKaufen Sie sich die Premium",
				 "§bEdition auf unserem Discord",
				 "§bServer und schauen Sie sich",
				 "§bdie Vorteile an die enthalten",
				 "§bsind. Bei Interesse kommen Sie ",
				 "§bauf unserem Discord Server" , 
				 "§b ",
				 "§8[Linksklicken/Rechtsklicken]").build());
		
		for(int i=0; i<=10; i++) {
			inv.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore(" ").build());
			
		}
		for(int i=12; i<=14; i++) {
			inv.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore(" ").build());
			
		}
		for(int i=16; i<=26; i++) {
			inv.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore(" ").build());
			
		}
		
		
		
		if(BooleanUtil.cfg.contains("LocationTeleport")) {
		Boolean bool = BooleanUtil.getBoolean("LocationTeleport");
	
			if(bool) {
					
						inv.setItem(20, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setName("§a§lAktiviert!").build());
						
					}else {
						inv.setItem(20, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§a§lDeaktiviert").build());
					}
			}else {
				BooleanUtil.setBoolean("LocationTeleport", false);	
				inv.setItem(20, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§a§lDeaktiviert").build());
			
			}
		
		player.openInventory(inv);
	}
	
	@EventHandler
	public void onKlickInventory(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if(event.getView().getTitle().equalsIgnoreCase("§4§lSettings")) {
			try {
			if(event.getCurrentItem().getType() == Material.PAPER) {
				
				
				if(LocationUtil.cfg.contains("SoupSpawn")) {
					Boolean bool = BooleanUtil.getBoolean("LocationTeleport");
					if(bool) {
					
						BooleanUtil.setBoolean("LocationTeleport", false);
					}else
						BooleanUtil.setBoolean("LocationTeleport", true);
					player.closeInventory();
					SettingsInventory.SettingsInventory(player);
					player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
					
				}else { 
					player.sendMessage(Main.PREFIX+"§cSetze zuerst die Location §6/soup setspawn");
					player.closeInventory();
					player.playSound(player.getLocation(), Sound.ENTITY_PARROT_IMITATE_ZOMBIE, 1, 1);
					
					}	
				}else {
					event.setCancelled(true);
				}
				}catch (NullPointerException e ){ }
			
			try {
			
			if(event.getCurrentItem().getType() == Material.GOLDEN_APPLE) {
				
				try{
                    Desktop d = Desktop.getDesktop();
                    d.browse(new URI("https://discord.gg/QdqyhKsdwu"));
                } catch (Exception e){
                    e.printStackTrace();
                }
				
				}
				
			}catch(NullPointerException e) {}
			
			
			}
		
		
	}
	
}
