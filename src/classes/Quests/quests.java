package classes.Quests;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import classes.Bank.Methoden;

public class quests implements Listener {

	public static File file = new File("plugins//RealLife//Quests.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	public static String aufgabe1 = "Netherman";

	public static void inv(Player p) {
		Inventory inv = Bukkit.createInventory(null, 27, "§3Quests");
		ItemStack item = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1,(short) 15, "§2");
		p.openInventory(inv);
		Inventory invOpen = (Inventory) p.getOpenInventory();
		for(int i = 0; i <= 26; i++) {
			
			invOpen.setItem(i, item);
			
		}

	}

	public static void save() {

		try {
			cfg.save(file);
		} catch (IOException e) {
		}

	}

	public static boolean checkItems(Player p) {

		return false;
	}

	@SuppressWarnings("null")
	public static boolean contains(Inventory inv, Material type, byte data, int menge, Player p) {
		for (ItemStack is : inv.getContents()) {
			if (is == null) {
				if (type == Material.AIR) {
				} else if (is.getType() == type) {
					if (data < 0) {
					} else if (is.getData() != null) {
						if (is.getAmount() > (menge - 1)) {
							test(inv, type, menge, p);
							return true;
						} else if (is.getAmount() == menge) {
							test(inv, type, menge, p);
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public static void test(Inventory inv, Material material, int menge, Player p) {

		for (ItemStack item : inv.getContents()) {
			if (item.getType() == material) {
				item.setAmount(item.getAmount() - menge);
				p.updateInventory();
			}
		}
	}


}
