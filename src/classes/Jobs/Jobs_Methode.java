package classes.Jobs;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import classes.Bank.Methoden;

public class Jobs_Methode {

	public static void Invs(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, "§3Jobs");
		ItemStack item = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 15, "§6Playcraft.de");
		ItemStack verdient = Methoden.createItem(Material.BOOK, 1, "§3Verdient");
		ItemStack leave = Methoden.createItem(Material.EMERALD, 1, "§3Kündigen");
		ItemStack abrechnen = Methoden.createItem(Material.PAPER, 1, "§3Abrechnung");
		ItemStack close = Methoden.createItem(Material.REDSTONE_BLOCK, 1, "§4§lClose");
		
		inv.setItem(0, close);
		inv.setItem(1, item);
		inv.setItem(2, verdient);
		inv.setItem(3, abrechnen);
		inv.setItem(4, item);
		inv.setItem(5, item);
		inv.setItem(6, leave);
		inv.setItem(7, item);
		inv.setItem(8, close);
		
		p.openInventory(inv);
	}
}
