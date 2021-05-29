package at.markus.soupTraining.commands;

import java.awt.Desktop;
import java.net.URI;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.markus.soupTraining.countdowns.SoupStartTimer;
import at.markus.soupTraining.inventorys.SettingsInventory;
import at.markus.soupTraining.main.Main;
import at.markus.soupTraining.utils.BooleanUtil;
import at.markus.soupTraining.utils.LocationUtil;

public class SoupCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
				if(args.length==0) {
				
					if(!Main.IN_IDLE) {
						Main.IN_IDLE= true;
					if(BooleanUtil.cfg.contains("LocationTeleport")) {		
						Boolean bool = BooleanUtil.getBoolean("LocationTeleport");
						Location loc = LocationUtil.getLocation("SoupSpawn");
						if(bool)
						player.teleport(loc);
						SoupStartTimer.start(player);
						
					}else {				
						BooleanUtil.setBoolean("LocationTeleport", false);		
					}	
							
				}else {
					player.sendMessage(Main.PREFIX+"§bEs spielt gerade ein Spieler. Bitte warten Sie oder Kaufen Sie sich §6§lPremium §bfür unlimitiertes spielen. §6§6/soup Premium! ");	
					player.playSound(player.getLocation(), Sound.AMBIENT_CAVE, 1, 2);
				}
					
					
				}else if(args.length==1) {
					
						
						
						if(args[0].equalsIgnoreCase("help")) {
							helpOP(player);
							
							
						}else if(args[0].equalsIgnoreCase("premium")) {	
							try{
			                    Desktop d = Desktop.getDesktop();
			                    d.browse(new URI("https://discord.gg/QdqyhKsdwu"));
			                } catch (Exception e){
			                    e.printStackTrace();
			                }
						}else 

								if(args[0].equalsIgnoreCase("setSpawn")) {
							
								if(player.hasPermission("soup.config")) {
							LocationUtil.setLocation("SoupSpawn", player.getLocation());
							player.sendMessage(Main.PREFIX+"§bDer Spawn wurde gesetzt!");
								}else helpOP(player);
	
							
						}else if(args[0].equalsIgnoreCase("config")) {
							if(player.hasPermission("soup.config")) {
							SettingsInventory.SettingsInventory(player);
							
							}else player.sendMessage(Main.NO_PERMISSION);
							
							}else helpOP(player);

					
				}else helpOP(player);
					
					
		}else Bukkit.getConsoleSender().sendMessage(Main.PREFIX + "§DDieser Command steht nur den Spielern zur verfügung :=(");
		
		
		return true;
	}

	public static void helpOP(Player player) {
		
		if(player.hasPermission("soup.settings")) {
			
			player.sendMessage("§8--------------()--------------");
			player.sendMessage("§cCommands!");
			player.sendMessage("§c");
			player.sendMessage("§6/soup help: §bZeigt alle Commands an!");
			player.sendMessage("§6/soup: §bDamit startet man das Training.");
			player.sendMessage("§6/soup premium: §bDamit kommen Sie auf unserem Discord Server und können die Premium Version kaufen.");
			player.sendMessage("§6/soup setSpawn §bDamit wird der Spawn erstellt.");
			player.sendMessage("§6/soup config: §bDamit stellt man die Einstellungen ein.");
			player.sendMessage("§8--------------()--------------");
			
		}else {
			
			player.sendMessage("§8--------------()--------------");
			player.sendMessage("§cCommands!");
			player.sendMessage("§c");
			player.sendMessage("§6/soup help: §bZeigt alle Commands an!");
			player.sendMessage("§6/soup: §bDamit startet man das Training.");
			player.sendMessage("§6/soup premium: §bDamit kommen Sie auf unserem Discord Server und können die Premium version kaufen.");
			player.sendMessage("§8--------------()--------------");
			
			
		}
		
		
	}
	
	
}
