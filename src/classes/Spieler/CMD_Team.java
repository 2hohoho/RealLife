package classes.Spieler;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import classes.Bank.Methoden;

public class CMD_Team implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		start(p);

		return false;
	}

	public static void reset(Player p) {

		for (int i = 0; i < 54; i++) {
			final ItemStack platzhalter = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 15, "§3");
			p.getOpenInventory().setItem(i, platzhalter);
		}

	}

	public void start(final Player p) {

		Inventory inv = Bukkit.createInventory(null, 54, "§2Team");

		final ItemStack owner = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 1, "§3Owner");
		final ItemStack admin = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Admin");
		final ItemStack team = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Team Leiter");
		final ItemStack dev = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Dev");
		final ItemStack builder = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Builder");
		final ItemStack moderator = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Moderator");
		final ItemStack supporter = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Supporter");

		final ItemStack offline = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Offline");
		final ItemStack online = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 5, "§3Online");

		ItemStack zocker = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		meta.setOwner("Zocker_KingHD");
		meta.setDisplayName("§3Zocker_KingHD");
		zocker.setItemMeta(meta);

		ItemStack iflouHD = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta iflou = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		iflou.setOwner("iFlouHD");
		iflou.setDisplayName("§3iFlouHD");
		iflouHD.setItemMeta(iflou);

		p.openInventory(inv);
		reset(p);

		p.getOpenInventory().setItem(1, owner);
		p.getOpenInventory().setItem(2, admin);
		p.getOpenInventory().setItem(3, team);
		p.getOpenInventory().setItem(4, dev);
		p.getOpenInventory().setItem(5, builder);
		p.getOpenInventory().setItem(6, moderator);
		p.getOpenInventory().setItem(7, supporter);

		p.getOpenInventory().setItem(30, zocker);
		p.getOpenInventory().setItem(32, iflouHD);

		if (Bukkit.getPlayer("Zocker_KingHD") != null || Bukkit.getPlayer("Zocker_King_HD") != null) {

			p.getOpenInventory().setItem(39, online);

		} else {

			p.getOpenInventory().setItem(39, offline);

		}

		if (Bukkit.getPlayer("iFlouHD") != null) {

			p.getOpenInventory().setItem(41, online);

		} else {

			p.getOpenInventory().setItem(41, offline);

		}

	}

	public void owner(final Player p) {

		final ItemStack owner = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 1, "§3Owner");
		final ItemStack admin = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Admin");
		final ItemStack team = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Team Leiter");
		final ItemStack dev = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Dev");
		final ItemStack builder = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Builder");
		final ItemStack moderator = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Moderator");
		final ItemStack supporter = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Supporter");

		final ItemStack offline = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Offline");
		final ItemStack online = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 5, "§3Online");

		ItemStack zocker = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		meta.setOwner("Zocker_KingHD");
		meta.setDisplayName("§3Zocker_KingHD");
		zocker.setItemMeta(meta);

		ItemStack iflouHD = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta iflou = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		iflou.setOwner("iFlouHD");
		iflou.setDisplayName("§3iFlouHD");
		iflouHD.setItemMeta(iflou);

		reset(p);
		p.getOpenInventory().setItem(1, owner);
		p.getOpenInventory().setItem(2, admin);
		p.getOpenInventory().setItem(3, team);
		p.getOpenInventory().setItem(4, dev);
		p.getOpenInventory().setItem(5, builder);
		p.getOpenInventory().setItem(6, moderator);
		p.getOpenInventory().setItem(7, supporter);

		p.getOpenInventory().setItem(30, zocker);
		p.getOpenInventory().setItem(32, iflouHD);

		if (Bukkit.getPlayer("Zocker_KingHD") != null || Bukkit.getPlayer("Zocker_King_HD") != null) {

			p.getOpenInventory().setItem(39, online);

		} else {

			p.getOpenInventory().setItem(39, offline);

		}

		if (Bukkit.getPlayer("iFlouHD") != null) {

			p.getOpenInventory().setItem(41, online);

		} else {

			p.getOpenInventory().setItem(41, offline);

		}

	}

	public static void admin(Player p) {

		final ItemStack owner = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Owner");
		final ItemStack admin = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 1, "§3Admin");
		final ItemStack team = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Team Leiter");
		final ItemStack dev = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Dev");
		final ItemStack builder = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Builder");
		final ItemStack moderator = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Moderator");
		final ItemStack supporter = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Supporter");

		final ItemStack offline = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Offline");
		final ItemStack online = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 5, "§3Online");

		ItemStack zocker = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		meta.setOwner("ZeldaFreak02");
		meta.setDisplayName("§3ZeldaFreak02");
		zocker.setItemMeta(meta);

		ItemStack iflouHD = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta iflou = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		iflou.setOwner("VetoFox_AD4M");
		iflou.setDisplayName("§3VetoFox_AD4M");
		iflouHD.setItemMeta(iflou);

		reset(p);

		p.getOpenInventory().setItem(1, owner);
		p.getOpenInventory().setItem(2, admin);
		p.getOpenInventory().setItem(3, team);
		p.getOpenInventory().setItem(4, dev);
		p.getOpenInventory().setItem(5, builder);
		p.getOpenInventory().setItem(6, moderator);
		p.getOpenInventory().setItem(7, supporter);

		p.getOpenInventory().setItem(30, zocker);
		p.getOpenInventory().setItem(32, iflouHD);

		if (Bukkit.getPlayer("VetoFox_AD4M") != null) {

			p.getOpenInventory().setItem(41, online);
		} else {

			p.getOpenInventory().setItem(41, offline);

		}
		if (Bukkit.getPlayer("ZeldaFreak02") != null) {

			p.getOpenInventory().setItem(39, online);

		} else {

			p.getOpenInventory().setItem(39, offline);

		}

	}

	public static void TeamLeiter(Player p) {

		final ItemStack owner = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Owner");
		final ItemStack admin = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Admin");
		final ItemStack team = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 1, "§3Team Leiter");
		final ItemStack dev = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Dev");
		final ItemStack builder = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Builder");
		final ItemStack moderator = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Moderator");
		final ItemStack supporter = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Supporter");

		final ItemStack offline = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Offline");
		final ItemStack online = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 5, "§3Online");

		ItemStack zocker = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		meta.setOwner("ZeldaFreak02");
		meta.setDisplayName("§3ZeldaFreak02");
		zocker.setItemMeta(meta);

		ItemStack iflouHD = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta iflou = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		iflou.setOwner("2hohoho");
		iflou.setDisplayName("§32hohoho");
		iflouHD.setItemMeta(iflou);

		reset(p);

		p.getOpenInventory().setItem(1, owner);
		p.getOpenInventory().setItem(2, admin);
		p.getOpenInventory().setItem(3, team);
		p.getOpenInventory().setItem(4, dev);
		p.getOpenInventory().setItem(5, builder);
		p.getOpenInventory().setItem(6, moderator);
		p.getOpenInventory().setItem(7, supporter);

		p.getOpenInventory().setItem(30, zocker);
		p.getOpenInventory().setItem(32, iflouHD);

		if (Bukkit.getPlayer("ZeldaFreak02") != null) {

			p.getOpenInventory().setItem(39, online);
		} else {

			p.getOpenInventory().setItem(39, offline);

		}
		if (Bukkit.getPlayer("2hohoho") != null) {

			p.getOpenInventory().setItem(41, online);

		} else {

			p.getOpenInventory().setItem(41, offline);

		}

	}

	public static void Dev(Player p) {

		final ItemStack owner = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Owner");
		final ItemStack admin = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Admin");
		final ItemStack team = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Team Leiter");
		final ItemStack dev = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 1, "§3Dev");
		final ItemStack builder = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Builder");
		final ItemStack moderator = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Moderator");
		final ItemStack supporter = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Supporter");

		final ItemStack offline = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Offline");
		final ItemStack online = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 5, "§3Online");

		ItemStack iflouHD = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta iflou = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		iflou.setOwner("2hohoho");
		iflou.setDisplayName("§32hohoho");
		iflouHD.setItemMeta(iflou);

		reset(p);

		p.getOpenInventory().setItem(1, owner);
		p.getOpenInventory().setItem(2, admin);
		p.getOpenInventory().setItem(3, team);
		p.getOpenInventory().setItem(4, dev);
		p.getOpenInventory().setItem(5, builder);
		p.getOpenInventory().setItem(6, moderator);
		p.getOpenInventory().setItem(7, supporter);

		p.getOpenInventory().setItem(31, iflouHD);

		if (Bukkit.getPlayer("2hohoho") != null) {

			p.getOpenInventory().setItem(40, online);

		} else {

			p.getOpenInventory().setItem(40, offline);

		}

	}

	public static void Builder(Player p) {

		final ItemStack owner = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Owner");
		final ItemStack admin = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Admin");
		final ItemStack team = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Team Leiter");
		final ItemStack dev = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Dev");
		final ItemStack builder = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 1, "§3Builder");
		final ItemStack moderator = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Moderator");
		final ItemStack supporter = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Supporter");

		final ItemStack offline = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Offline");
		final ItemStack online = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 5, "§3Online");

		ItemStack iflouHD = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta iflou = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		iflou.setOwner("Anna_Ally");
		iflou.setDisplayName("§3Anna_Ally");
		iflouHD.setItemMeta(iflou);
		
		ItemStack zelda = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta zeld = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		zeld.setOwner("ZeldaFreak02");
		zeld.setDisplayName("§3ZeldaFreak02");
		zelda.setItemMeta(zeld);

		
		ItemStack DavF = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta Dav = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		Dav.setOwner("DavF");
		Dav.setDisplayName("§3DavF");
		DavF.setItemMeta(Dav);

		reset(p);

		p.getOpenInventory().setItem(1, owner);
		p.getOpenInventory().setItem(2, admin);
		p.getOpenInventory().setItem(3, team);
		p.getOpenInventory().setItem(4, dev);
		p.getOpenInventory().setItem(5, builder);
		p.getOpenInventory().setItem(6, moderator);
		p.getOpenInventory().setItem(7, supporter);

		p.getOpenInventory().setItem(29, iflouHD);
		p.getOpenInventory().setItem(31, zelda);
		p.getOpenInventory().setItem(33, DavF);

		if (Bukkit.getPlayer("Anna_Ally") != null) {

			p.getOpenInventory().setItem(38, online);

		} else {

			p.getOpenInventory().setItem(38, offline);

		}
		if (Bukkit.getPlayer("ZeldaFreak02") != null) {

			p.getOpenInventory().setItem(40, online);

		} else {

			p.getOpenInventory().setItem(40, offline);

		}
		if (Bukkit.getPlayer("DavF") != null) {

			p.getOpenInventory().setItem(42, online);

		} else {

			p.getOpenInventory().setItem(42, offline);

		}

	}
	
	public static void Supporter(Player p) {

		final ItemStack owner = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Owner");
		final ItemStack admin = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Admin");
		final ItemStack team = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Team Leiter");
		final ItemStack dev = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Dev");
		final ItemStack builder = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Builder");
		final ItemStack moderator = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Moderator");
		final ItemStack supporter = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 1, "§3Supporter");

		reset(p);

		p.getOpenInventory().setItem(1, owner);
		p.getOpenInventory().setItem(2, admin);
		p.getOpenInventory().setItem(3, team);
		p.getOpenInventory().setItem(4, dev);
		p.getOpenInventory().setItem(5, builder);
		p.getOpenInventory().setItem(6, moderator);
		p.getOpenInventory().setItem(7, supporter);

	}
	public static void Moderator(Player p) {

		final ItemStack owner = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Owner");
		final ItemStack admin = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Admin");
		final ItemStack team = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Team Leiter");
		final ItemStack dev = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Dev");
		final ItemStack builder = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Builder");
		final ItemStack moderator = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 1, "§3Moderator");
		final ItemStack supporter = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§3Supporter");

		reset(p);

		p.getOpenInventory().setItem(1, owner);
		p.getOpenInventory().setItem(2, admin);
		p.getOpenInventory().setItem(3, team);
		p.getOpenInventory().setItem(4, dev);
		p.getOpenInventory().setItem(5, builder);
		p.getOpenInventory().setItem(6, moderator);
		p.getOpenInventory().setItem(7, supporter);

	}

	@EventHandler
	public void envent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		try {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3")) {

				e.setCancelled(true);

			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Offline")) {

				e.setCancelled(true);

			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Online")) {

				e.setCancelled(true);

			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Owner")) {

				e.setCancelled(true);
				owner(p);

			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Admin")) {

				e.setCancelled(true);
				admin(p);

			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Team Leiter")) {

				e.setCancelled(true);
				TeamLeiter(p);

			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Dev")) {

				e.setCancelled(true);
				Dev(p);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Builder")) {

				e.setCancelled(true);
				Builder(p);

			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Supporter")) {

				e.setCancelled(true);
				Supporter(p);

			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Moderator")) {

				e.setCancelled(true);
				Moderator(p);

			}
			/*
			 * 
			 * Teams
			 * 
			 * 
			 */
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Zocker_KingHD")) {

				e.setCancelled(true);

			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3iFlouHD")) {

				e.setCancelled(true);

			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§32hohoho")) {

				e.setCancelled(true);

			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3ZeldaFreak02")) {

				e.setCancelled(true);

			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3VetoFox_AD4M")) {

				e.setCancelled(true);

			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Anna_Ally")) {

				e.setCancelled(true);

			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3DavF")) {

				e.setCancelled(true);

			}

		} catch (Exception d) {

		}
	}
}
