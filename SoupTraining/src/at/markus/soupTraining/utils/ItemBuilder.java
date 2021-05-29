package at.markus.soupTraining.utils;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ItemBuilder {

	private ItemStack item;
	private ItemMeta itemMeta;
	
	@SuppressWarnings("deprecation")
	public ItemBuilder(Material material, short i) {
		item = new ItemStack(material, 1, i);
		itemMeta = item.getItemMeta();
	}
	
	public ItemBuilder(Material material) {
		this(material, (short)0);
	}
	
	public ItemBuilder setName(String name) {
		itemMeta.setDisplayName(name);
		return this;
	}
	
	public ItemBuilder setLore(String... lore) {
		itemMeta.setLore(Arrays.asList(lore));
		return this;
	}
	
	public ItemBuilder setAmount(int amount) {
		item.setAmount(amount);
		return this;
	}
	public ItemBuilder setEnchantment(Enchantment enchantment, int level) {
		itemMeta.addEnchant(enchantment, level, true);
		return this;
	}
	
	
	public ItemStack build() {
		item.setItemMeta(itemMeta);
		return item;
	}

	
	
}
