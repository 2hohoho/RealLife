package classes.Online;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import classes.Bank.Methoden;

public class Methode {
	
	public static void createOnlineInv(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, "§3Team");
		ItemStack platzhalter = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 15, "§3");
		
		ItemStack Owner = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Owner");
		ItemStack Admin = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Admin");
		ItemStack BuilderDev = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Builder/Developer");
		ItemStack Moderator = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Moderator");
		ItemStack Supporter = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Supporter");
		
		
		inv.setItem(0, platzhalter);
		inv.setItem(1, platzhalter);
		inv.setItem(2, Owner);
		inv.setItem(3, Admin);
		inv.setItem(4, BuilderDev);
		inv.setItem(5, Moderator);
		inv.setItem(6, Supporter);
		inv.setItem(7, platzhalter);
		inv.setItem(8, platzhalter);
		inv.setItem(9, platzhalter);
		inv.setItem(10, platzhalter);
		inv.setItem(11, platzhalter);
		inv.setItem(12, platzhalter);
		inv.setItem(13, platzhalter);
		inv.setItem(14, platzhalter);
		inv.setItem(15, platzhalter);
		inv.setItem(16, platzhalter);
		inv.setItem(17, platzhalter);
		// 3 Reihe
		inv.setItem(9, platzhalter);
		inv.setItem(10, platzhalter);
		inv.setItem(11, platzhalter);
		inv.setItem(12, platzhalter);
		inv.setItem(13, platzhalter);
		inv.setItem(14, platzhalter);
		inv.setItem(15, platzhalter);
		inv.setItem(16, platzhalter);
		inv.setItem(17, platzhalter);
		// 4 Reihe
		inv.setItem(9, platzhalter);
		inv.setItem(10, platzhalter);
		inv.setItem(11, platzhalter);
		inv.setItem(12, platzhalter);
		inv.setItem(13, platzhalter);
		inv.setItem(14, platzhalter);
		inv.setItem(15, platzhalter);
		inv.setItem(16, platzhalter);
		inv.setItem(17, platzhalter);
		// 5 Reihe
		inv.setItem(9, platzhalter);
		inv.setItem(10, platzhalter);
		inv.setItem(11, platzhalter);
		inv.setItem(12, platzhalter);
		inv.setItem(13, platzhalter);
		inv.setItem(14, platzhalter);
		inv.setItem(15, platzhalter);
		inv.setItem(16, platzhalter);
		inv.setItem(17, platzhalter);
		// 6 Reihe
		inv.setItem(9, platzhalter);
		inv.setItem(10, platzhalter);
		inv.setItem(11, platzhalter);
		inv.setItem(12, platzhalter);
		inv.setItem(13, platzhalter);
		inv.setItem(14, platzhalter);
		inv.setItem(15, platzhalter);
		inv.setItem(16, platzhalter);
		inv.setItem(17, platzhalter);
		
		
		p.openInventory(inv);
		
	}
	
	
}
