package classes.Bank;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Methoden {
	
	public static ItemStack createItem(Material m, int anzahl, String name) {
		ItemStack item = new ItemStack(m, anzahl);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack createMetaItem(Material mat, int anzahl, short id, String name) {
		ItemStack item = new ItemStack(mat, anzahl, (short) id);
		ItemMeta mitem = item.getItemMeta();
		mitem.setDisplayName(name);
		item.setItemMeta(mitem);
		return item;

	}
	

	public static void Inventory(Player p) {
		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, 9, "§3Bank");
		
		ItemStack platzhalter = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 15, "§6Playcraft.de");
		ItemStack Kontostand = createItem(Material.BOOK, 1, "§3Kontostand");
		ItemStack einzahlen = createItem(Material.EMERALD, 1, "§3Einzahlen");
		ItemStack auszahlen = createItem(Material.DIAMOND, 1 , "§3Auszahlen");
		ItemStack BoughtPlaceBlocks = createItem(Material.GOLD_BLOCK, 1 , "§3Claim Blöcke");
		ItemStack close = Methoden.createItem(Material.REDSTONE_BLOCK, 1, "§4§lClose");
		
		inv.setItem(0, close);
		inv.setItem(1, platzhalter);
		inv.setItem(2, einzahlen);
		inv.setItem(3, Kontostand);
		inv.setItem(4, auszahlen);
		inv.setItem(5, platzhalter);
		inv.setItem(6, BoughtPlaceBlocks);
		inv.setItem(7, platzhalter);
		inv.setItem(8, close);
		p.openInventory(inv);
	}
	
	public static void addMoney(Player p) {
		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, 9, "§3Bank - Einzahlen");
		
		ItemStack platzhalter = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 15, "§6Playcraft.de");
		ItemStack m10 = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§310 Coins");
		ItemStack m20 = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§320 Coins");
		ItemStack m50 = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§350 Coins");
		ItemStack m100 = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3100 Coins");
		ItemStack m500 = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3500 Coins");
		ItemStack close = Methoden.createItem(Material.REDSTONE_BLOCK, 1, "§4§lClose");
		
		inv.setItem(0, close);
		inv.setItem(1, platzhalter);
		inv.setItem(2, m10);
		inv.setItem(3, m20);
		inv.setItem(4, m50);
		inv.setItem(5, m100);
		inv.setItem(6, m500);
		inv.setItem(7, platzhalter);
		inv.setItem(8, close);
		p.openInventory(inv);
	}
	
	public static void removeMoney(Player p) {
		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, 9, "§3Bank - Abheben");
		
		ItemStack platzhalter = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 15, "§6Playcraft.de");
		ItemStack m10 = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3-10 Coins");
		ItemStack m20 = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3-20 Coins");
		ItemStack m50 = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3-50 Coins");
		ItemStack m100 = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3-100 Coins");
		ItemStack m500 = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3-500 Coins");
		ItemStack close = Methoden.createItem(Material.REDSTONE_BLOCK, 1, "§4§lClose");
		
		inv.setItem(0, close);
		inv.setItem(1, platzhalter);
		inv.setItem(2, m10);
		inv.setItem(3, m20);
		inv.setItem(4, m50);
		inv.setItem(5, m100);
		inv.setItem(6, m500);
		inv.setItem(7, platzhalter);
		inv.setItem(8, close);
		p.openInventory(inv);
	}
	
	
	
	public static void BoughtClaimBlöcke(Player p) {
		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, 9, "§3Bank - Claim Blöcke");
		
		ItemStack platzhalter = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 15, "§6Playcraft.de");
		ItemStack m1 = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§31 Block² (2 Coins)");
		ItemMeta meta1 = m1.getItemMeta();
		ArrayList<String> lore = new ArrayList<>();
		lore.add("§21x1");
		meta1.setLore(lore);
		m1.setItemMeta(meta1);
		lore.clear();
		
		ItemStack m5 = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§325 Blöcke² (50 Coins)");
		ItemMeta meta5 = m5.getItemMeta();
		lore.add("§25x5");
		meta5.setLore(lore);
		m5.setItemMeta(meta5);
		lore.clear();
		
		ItemStack m10 = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3100 Blöcke² (200 Coins)");
		ItemMeta meta10 = m10.getItemMeta();
		lore.add("§210x10");
		meta10.setLore(lore);
		m10.setItemMeta(meta10);
		lore.clear();
		
		ItemStack m15 = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3225 Blöcke² (450 Coins)");
		ItemMeta meta15 = m15.getItemMeta();
		lore.add("§215x15");
		meta15.setLore(lore);
		m15.setItemMeta(meta15);
		lore.clear();
		
		ItemStack m20 = createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3400 Blöcke² (800 Coins)");
		ItemMeta meta20 = m20.getItemMeta();
		lore.add("§220x20");
		meta20.setLore(lore);
		m20.setItemMeta(meta20);
		lore.clear();
		
		ItemStack close = Methoden.createItem(Material.REDSTONE_BLOCK, 1, "§4§lClose");
		
		inv.setItem(0, close);
		inv.setItem(1, platzhalter);
		inv.setItem(2, m1);
		inv.setItem(3, m5);
		inv.setItem(4, m10);
		inv.setItem(5, m15);
		inv.setItem(6, m20);
		inv.setItem(7, platzhalter);
		inv.setItem(8, close);
		p.openInventory(inv);
	}
}
