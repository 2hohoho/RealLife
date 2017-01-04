package classes.Bank;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import classes.main;

public class Listener_Bank implements org.bukkit.event.Listener {

	@EventHandler
	public static void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		try {
			
			//Geht
			if (main.yaml.getString(p.getName() + ".Job").equalsIgnoreCase("Miner")) {
				if (b.getType() == Material.IRON_ORE) {
					int vorher = main.yaml.getInt(p.getName() + ".KommaZahl");
					int gleich = 3 + vorher;
					main.yaml.set(p.getName() + ".KommaZahl", gleich);
					main.yaml.save(main.file);

					if (gleich > 10) {
						int komma = main.yaml.getInt(p.getName() + ".KommaZahl");
						int ganz = main.yaml.getInt(p.getName() + ".GanzZahl");
						int danach = komma - 10;
						int dann = ganz + 1;
						main.yaml.set(p.getName() + ".KommaZahl", danach);
						main.yaml.set(p.getName() + ".GanzZahl", dann);
						main.yaml.save(main.file);
					}
				}
				if (b.getType() == Material.COAL_ORE) {
					int vorher = main.yaml.getInt(p.getName() + ".KommaZahl");
					int gleich = 1 + vorher;
					main.yaml.set(p.getName() + ".KommaZahl", gleich);
					main.yaml.save(main.file);

					if (gleich > 10) {
						int komma = main.yaml.getInt(p.getName() + ".KommaZahl");
						int ganz = main.yaml.getInt(p.getName() + ".GanzZahl");
						int danach = komma - 10;
						int dann = ganz + 1;
						main.yaml.set(p.getName() + ".KommaZahl", danach);
						main.yaml.set(p.getName() + ".GanzZahl", dann);
						main.yaml.save(main.file);
					}
				}
				if (b.getType() == Material.DIAMOND_ORE) {
					int vorher = main.yaml.getInt(p.getName() + ".KommaZahl");
					int gleich = 8 + vorher;
					main.yaml.set(p.getName() + ".KommaZahl", gleich);
					main.yaml.save(main.file);

					if (gleich > 10) {
						int komma = main.yaml.getInt(p.getName() + ".KommaZahl");
						int ganz = main.yaml.getInt(p.getName() + ".GanzZahl");
						int danach = komma - 10;
						int dann = ganz + 1;
						main.yaml.set(p.getName() + ".KommaZahl", danach);
						main.yaml.set(p.getName() + ".GanzZahl", dann);
						main.yaml.save(main.file);
					}
				}
				if (b.getType() == Material.GOLD_ORE) {
					int vorher = main.yaml.getInt(p.getName() + ".KommaZahl");
					int gleich = 4 + vorher;
					main.yaml.set(p.getName() + ".KommaZahl", gleich);
					main.yaml.save(main.file);

					if (gleich > 10) {
						int komma = main.yaml.getInt(p.getName() + ".KommaZahl");
						int ganz = main.yaml.getInt(p.getName() + ".GanzZahl");
						int danach = komma - 10;
						int dann = ganz + 1;
						main.yaml.set(p.getName() + ".KommaZahl", danach);
						main.yaml.set(p.getName() + ".GanzZahl", dann);
						main.yaml.save(main.file);
					}
				}
				if (b.getType() == Material.EMERALD_ORE) {
					int vorher = main.yaml.getInt(p.getName() + ".KommaZahl");
					int gleich = 9 + vorher;
					main.yaml.set(p.getName() + ".KommaZahl", gleich);
					main.yaml.save(main.file);

					if (gleich > 10) {
						int komma = main.yaml.getInt(p.getName() + ".KommaZahl");
						int ganz = main.yaml.getInt(p.getName() + ".GanzZahl");
						int danach = komma - 10;
						int dann = ganz + 1;
						main.yaml.set(p.getName() + ".KommaZahl", danach);
						main.yaml.set(p.getName() + ".GanzZahl", dann);
						main.yaml.save(main.file);
					}
				}
				if (b.getType() == Material.REDSTONE_ORE) {
					int vorher = main.yaml.getInt(p.getName() + ".KommaZahl");
					int gleich = 1 + vorher;
					main.yaml.set(p.getName() + ".KommaZahl", gleich);
					main.yaml.save(main.file);

					if (gleich > 10) {
						int komma = main.yaml.getInt(p.getName() + ".KommaZahl");
						int ganz = main.yaml.getInt(p.getName() + ".GanzZahl");
						int danach = komma - 10;
						int dann = ganz + 1;
						main.yaml.set(p.getName() + ".KommaZahl", danach);
						main.yaml.set(p.getName() + ".GanzZahl", dann);
						main.yaml.save(main.file);
					}
				}
				if (b.getType() == Material.LAPIS_ORE) {
					int vorher = main.yaml.getInt(p.getName() + ".KommaZahl");
					int gleich = 2 + vorher;
					main.yaml.set(p.getName() + ".KommaZahl", gleich);
					main.yaml.save(main.file);

					if (gleich > 10) {
						int komma = main.yaml.getInt(p.getName() + ".KommaZahl");
						int ganz = main.yaml.getInt(p.getName() + ".GanzZahl");
						int danach = komma - 10;
						int dann = ganz + 1;
						main.yaml.set(p.getName() + ".KommaZahl", danach);
						main.yaml.set(p.getName() + ".GanzZahl", dann);
						main.yaml.save(main.file);
					}
				}
			} else if (main.yaml.getString(p.getName() + ".Job").equalsIgnoreCase("Holzfäller")) {
				if (b.getType() == Material.LOG) {
					int vorher = main.yaml.getInt(p.getName() + ".KommaZahl");
					int gleich = 1 + vorher;
					main.yaml.set(p.getName() + ".KommaZahl", gleich);
					main.yaml.save(main.file);

					if (gleich > 10) {
						int komma = main.yaml.getInt(p.getName() + ".KommaZahl");
						int ganz = main.yaml.getInt(p.getName() + ".GanzZahl");
						int danach = komma - 10;
						int dann = ganz + 1;
						main.yaml.set(p.getName() + ".KommaZahl", danach);
						main.yaml.set(p.getName() + ".GanzZahl", dann);
						main.yaml.save(main.file);
					}
				}
				if (b.getType() == Material.LOG_2) {
					int vorher = main.yaml.getInt(p.getName() + ".KommaZahl");
					int gleich = 1 + vorher;
					main.yaml.set(p.getName() + ".KommaZahl", gleich);
					main.yaml.save(main.file);

					if (gleich > 10) {
						int komma = main.yaml.getInt(p.getName() + ".KommaZahl");
						int ganz = main.yaml.getInt(p.getName() + ".GanzZahl");
						int danach = komma - 10;
						int dann = ganz + 1;
						main.yaml.set(p.getName() + ".KommaZahl", danach);
						main.yaml.set(p.getName() + ".GanzZahl", dann);
						main.yaml.save(main.file);
					}
				}
			} else if (main.yaml.getString(p.getName() + ".Job").equalsIgnoreCase("Gräber")) {
				if (b.getType() == Material.DIRT) {
					int vorher = main.yaml.getInt(p.getName() + ".KommaZahl");
					int gleich = 1 + vorher;
					main.yaml.set(p.getName() + ".KommaZahl", gleich);
					main.yaml.save(main.file);

					if (gleich > 10) {
						int komma = main.yaml.getInt(p.getName() + ".KommaZahl");
						int ganz = main.yaml.getInt(p.getName() + ".GanzZahl");
						int danach = komma - 10;
						int dann = ganz + 1;
						main.yaml.set(p.getName() + ".KommaZahl", danach);
						main.yaml.set(p.getName() + ".GanzZahl", dann);
						main.yaml.save(main.file);
					}
				}
				if (b.getType() == Material.GRASS) {
					int vorher = main.yaml.getInt(p.getName() + ".KommaZahl");
					int gleich = 1 + vorher;
					main.yaml.set(p.getName() + ".KommaZahl", gleich);
					main.yaml.save(main.file);

					if (gleich > 10) {
						int komma = main.yaml.getInt(p.getName() + ".KommaZahl");
						int ganz = main.yaml.getInt(p.getName() + ".GanzZahl");
						int danach = komma - 10;
						int dann = ganz + 1;
						main.yaml.set(p.getName() + ".KommaZahl", danach);
						main.yaml.set(p.getName() + ".GanzZahl", dann);
						main.yaml.save(main.file);
					}
				}
				if (b.getType() == Material.GRAVEL) {
					int vorher = main.yaml.getInt(p.getName() + ".KommaZahl");
					int gleich = 1 + vorher;
					main.yaml.set(p.getName() + ".KommaZahl", gleich);
					main.yaml.save(main.file);

					if (gleich > 10) {
						int komma = main.yaml.getInt(p.getName() + ".KommaZahl");
						int ganz = main.yaml.getInt(p.getName() + ".GanzZahl");
						int danach = komma - 10;
						int dann = ganz + 1;
						main.yaml.set(p.getName() + ".KommaZahl", danach);
						main.yaml.set(p.getName() + ".GanzZahl", dann);
						main.yaml.save(main.file);
					}
				}
				if (b.getType() == Material.SAND) {
					int vorher = main.yaml.getInt(p.getName() + ".KommaZahl");
					int gleich = 1 + vorher;
					main.yaml.set(p.getName() + ".KommaZahl", gleich);
					main.yaml.save(main.file);

					if (gleich > 10) {
						int komma = main.yaml.getInt(p.getName() + ".KommaZahl");
						int ganz = main.yaml.getInt(p.getName() + ".GanzZahl");
						int danach = komma - 10;
						int dann = ganz + 1;
						main.yaml.set(p.getName() + ".KommaZahl", danach);
						main.yaml.set(p.getName() + ".GanzZahl", dann);
						main.yaml.save(main.file);
					}
				}
			}

		} catch (Exception d) {

		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		try {
			Sign sign = (Sign) e.getClickedBlock().getState();
			if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {

				if (sign.getLine(0).equalsIgnoreCase("§8§l[§3Bank§8§l]")) {
					Methoden.Inventory(p);
				}
			}
		} catch (Exception d) {
		}
	}

	@EventHandler
	public void SignChangeEvent(SignChangeEvent e) {
		if (e.getLine(0) != null && e.getLine(0) != "") {
			if (e.getLine(0).equalsIgnoreCase("[Bank]")) {
				e.setLine(0, "§8§l[§3Bank§8§l]");
				e.setLine(1, "");
				e.setLine(2, "");
				e.setLine(3, "");
			}
		}
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		try {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Kündigen")) {
				e.setCancelled(true);
				p.closeInventory();
				if (main.yaml.getString(p.getName() + ".Job").equalsIgnoreCase("Arbeitslos")) {
					p.sendMessage(main.prefix + "Du hast kein Job den du Kündigen kanst");
				} else {
					main.yaml.set(p.getName() + ".Job", "Arbeitslos");
					main.yaml.set(p.getName() + ".KommaZahl", 0);
					main.yaml.set(p.getName() + ".GanzZahl", 0);
					main.yaml.save(main.file);
					p.sendMessage(main.prefix + "Du hast dein Job gekündigt");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Verdient")) {
				e.setCancelled(true);
				p.closeInventory();
				if (main.yaml.getString(p.getName() + ".Job").equalsIgnoreCase("Arbeitslos")) {
					p.sendMessage(main.prefix + "Nimm zuerst ein Job an");
				} else {
					p.sendMessage(main.prefix + "Verdient hast du " + main.yaml.getInt(p.getName() + ".GanzZahl"));
				}
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Claim Blöcke")) {
				e.setCancelled(true);
				Methoden.BoughtClaimBlöcke(p);
			}

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Abrechnung")) {
				e.setCancelled(true);
				p.closeInventory();
				if (main.yaml.getString(p.getName() + ".Job").equalsIgnoreCase("Arbeitslos")) {
					p.sendMessage(main.prefix + "Nimm zuerst ein Job an");
				} else {
					p.sendMessage(main.prefix + "Du hast dein Lohn abgeholt");
					int Coins = main.yaml.getInt(p.getName() + ".Coins");
					int verdient = main.yaml.getInt(p.getName() + ".GanzZahl");
					int gesammt = Coins + verdient;
					main.yaml.set(p.getName() + ".Coins", gesammt);
					main.yaml.set(p.getName() + ".GanzZahl", 0);
					main.yaml.save(main.file);
				}
			}

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Playcraft.de")) {
				e.setCancelled(true);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4§lClose")) {
				e.setCancelled(true);
				p.closeInventory();
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Kontostand")) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage(
						main.prefix + "Auf deinem Konto hast du " + main.yaml.getInt(p.getName() + ".Bank") + " Coins");
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Einzahlen")) {
				e.setCancelled(true);
				Methoden.addMoney(p);
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§31 Block² (2 Coins)")) {
				e.setCancelled(true);
				int Bank = main.yaml.getInt(p.getName() + ".Bank");
				int gesammt = Bank - 2;
				if(gesammt < 0) {
					p.sendMessage(main.prefix + "Du hast nicht Genug Geld auf der Bank um das zu Kaufen");
				} else {
					main.yaml.set(p.getName() + ".Bank", gesammt);
					int Bought = main.yaml.getInt(p.getName() + ".Bought");
					int gleich = Bought + 1;
					main.yaml.set(p.getName() + ".Bought", gleich);
					p.sendMessage(main.prefix + "Du hast 1 Block² gekauft und du hast nun " + gleich + " Blöcke²");
					main.yaml.save(main.file);
				}
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§325 Blöcke² (50 Coins)")) {
				e.setCancelled(true);
				int Bank = main.yaml.getInt(p.getName() + ".Bank");
				int gesammt = Bank - 50;
				if(gesammt < 0) {
					p.sendMessage(main.prefix + "Du hast nicht Genug Geld auf der Bank um das zu Kaufen");
				} else {
					main.yaml.set(p.getName() + ".Bank", gesammt);
					int Bought = main.yaml.getInt(p.getName() + ".Bought");
					int gleich = Bought + 25;
					main.yaml.set(p.getName() + ".Bought", gleich);
					p.sendMessage(main.prefix + "Du hast 25 Block² gekauft und du hast nun " + gleich + " Blöcke²");
					main.yaml.save(main.file);
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3100 Blöcke² (200 Coins)")) {
				e.setCancelled(true);
				int Bank = main.yaml.getInt(p.getName() + ".Bank");
				int gesammt = Bank - 200;
				if(gesammt < 0) {
					p.sendMessage(main.prefix + "Du hast nicht Genug Geld auf der Bank um das zu Kaufen");
				} else {
					main.yaml.set(p.getName() + ".Bank", gesammt);
					int Bought = main.yaml.getInt(p.getName() + ".Bought");
					int gleich = Bought + 100;
					main.yaml.set(p.getName() + ".Bought", gleich);
					p.sendMessage(main.prefix + "Du hast 100 Block² gekauft und du hast nun " + gleich + " Blöcke²");
					main.yaml.save(main.file);
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3225 Blöcke² (450 Coins)")) {
				e.setCancelled(true);
				int Bank = main.yaml.getInt(p.getName() + ".Bank");
				int gesammt = Bank - 450;
				if(gesammt < 0) {
					p.sendMessage(main.prefix + "Du hast nicht Genug Geld auf der Bank um das zu Kaufen");
				} else {
					main.yaml.set(p.getName() + ".Bank", gesammt);
					int Bought = main.yaml.getInt(p.getName() + ".Bought");
					int gleich = Bought + 225;
					main.yaml.set(p.getName() + ".Bought", gleich);
					p.sendMessage(main.prefix + "Du hast 225 Block² gekauft und du hast nun " + gleich + " Blöcke²");
					main.yaml.save(main.file);
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3400 Blöcke² (800 Coins)")) {
				e.setCancelled(true);
				int Bank = main.yaml.getInt(p.getName() + ".Bank");
				int gesammt = Bank - 800;
				if(gesammt < 0) {
					p.sendMessage(main.prefix + "Du hast nicht Genug Geld auf der Bank um das zu Kaufen");
				} else {
					main.yaml.set(p.getName() + ".Bank", gesammt);
					int Bought = main.yaml.getInt(p.getName() + ".Bought");
					int gleich = Bought + 400;
					main.yaml.set(p.getName() + ".Bought", gleich);
					p.sendMessage(main.prefix + "Du hast 400 Block² gekauft und du hast nun " + gleich + " Blöcke²");
					main.yaml.save(main.file);
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Auszahlen")) {
				e.setCancelled(true);
				Methoden.removeMoney(p);
			}

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§310 Coins")) {
				e.setCancelled(true);
				int coinsPlayer = main.yaml.getInt(p.getName() + ".Coins");
				int gleich = coinsPlayer - 10;
				if (gleich < 0) {
					p.closeInventory();
					p.sendMessage(main.prefix + "Du kannst nich mehr als du hast einzahlen");
				} else {
					main.yaml.set(p.getName() + ".Coins", gleich);
					int BankPlayer = main.yaml.getInt(p.getName() + ".Bank") + 10;
					main.yaml.set(p.getName() + ".Bank", BankPlayer);
					main.yaml.save(main.file);
					p.sendMessage(main.prefix + "Du hast 10 Coins auf dein Konto eingezahlt");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§320 Coins")) {
				e.setCancelled(true);
				int coinsPlayer = main.yaml.getInt(p.getName() + ".Coins");
				int gleich = coinsPlayer - 20;
				if (gleich < 0) {
					p.closeInventory();
					p.sendMessage(main.prefix + "Du kannst nich mehr als du hast einzahlen");
				} else {
					main.yaml.set(p.getName() + ".Coins", gleich);
					int BankPlayer = main.yaml.getInt(p.getName() + ".Bank") + 20;
					main.yaml.set(p.getName() + ".Bank", BankPlayer);
					main.yaml.save(main.file);
					p.sendMessage(main.prefix + "Du hast 20 Coins auf dein Konto eingezahlt");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§350 Coins")) {
				e.setCancelled(true);
				int coinsPlayer = main.yaml.getInt(p.getName() + ".Coins");
				int gleich = coinsPlayer - 50;
				if (gleich < 0) {
					p.closeInventory();
					p.sendMessage(main.prefix + "Du kannst nich mehr als du hast einzahlen");
				} else {
					main.yaml.set(p.getName() + ".Coins", gleich);
					int BankPlayer = main.yaml.getInt(p.getName() + ".Bank") + 50;
					main.yaml.set(p.getName() + ".Bank", BankPlayer);
					main.yaml.save(main.file);
					p.sendMessage(main.prefix + "Du hast 50 Coins auf dein Konto eingezahlt");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3100 Coins")) {
				e.setCancelled(true);
				int coinsPlayer = main.yaml.getInt(p.getName() + ".Coins");
				int gleich = coinsPlayer - 100;
				if (gleich < 0) {
					p.closeInventory();
					p.sendMessage(main.prefix + "Du kannst nich mehr als du hast einzahlen");
				} else {
					main.yaml.set(p.getName() + ".Coins", gleich);
					int BankPlayer = main.yaml.getInt(p.getName() + ".Bank") + 100;
					main.yaml.set(p.getName() + ".Bank", BankPlayer);
					main.yaml.save(main.file);
					p.sendMessage(main.prefix + "Du hast 100 Coins auf dein Konto eingezahlt");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3500 Coins")) {
				e.setCancelled(true);
				int coinsPlayer = main.yaml.getInt(p.getName() + ".Coins");
				int gleich = coinsPlayer - 500;
				if (gleich < 0) {
					p.closeInventory();
					p.sendMessage(main.prefix + "Du kannst nich mehr als du hast einzahlen");
				} else {
					main.yaml.set(p.getName() + ".Coins", gleich);
					int BankPlayer = main.yaml.getInt(p.getName() + ".Bank") + 500;
					main.yaml.set(p.getName() + ".Bank", BankPlayer);
					main.yaml.save(main.file);
					p.sendMessage(main.prefix + "Du hast 500 Coins auf dein Konto eingezahlt");
				}
			}

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3-10 Coins")) {
				e.setCancelled(true);
				int coinsPlayer = main.yaml.getInt(p.getName() + ".Bank");
				int gleich = coinsPlayer - 10;
				if (gleich < 0) {
					p.closeInventory();
					p.sendMessage(main.prefix + "Du kannst nich mehr als du hast auszahlen");
				} else {
					main.yaml.set(p.getName() + ".Bank", gleich);
					int BankPlayer = main.yaml.getInt(p.getName() + ".Coins") + 10;
					main.yaml.set(p.getName() + ".Coins", BankPlayer);
					main.yaml.save(main.file);
					p.sendMessage(main.prefix + "Du hast 10 Coins abgehoben");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3-20 Coins")) {
				e.setCancelled(true);
				int coinsPlayer = main.yaml.getInt(p.getName() + ".Bank");
				int gleich = coinsPlayer - 20;
				if (gleich < 0) {
					p.closeInventory();
					p.sendMessage(main.prefix + "Du kannst nich mehr als du hast auszahlen");
				} else {
					main.yaml.set(p.getName() + ".Bank", gleich);
					int BankPlayer = main.yaml.getInt(p.getName() + ".Coins") + 20;
					main.yaml.set(p.getName() + ".Coins", BankPlayer);
					main.yaml.save(main.file);
					p.sendMessage(main.prefix + "Du hast 10 Coins abgehoben");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3-50 Coins")) {
				e.setCancelled(true);
				int coinsPlayer = main.yaml.getInt(p.getName() + ".Bank");
				int gleich = coinsPlayer - 50;
				if (gleich < 0) {
					p.closeInventory();
					p.sendMessage(main.prefix + "Du kannst nich mehr als du hast auszahlen");
				} else {
					main.yaml.set(p.getName() + ".Bank", gleich);
					int BankPlayer = main.yaml.getInt(p.getName() + ".Coins") + 50;
					main.yaml.set(p.getName() + ".Coins", BankPlayer);
					main.yaml.save(main.file);
					p.sendMessage(main.prefix + "Du hast 10 Coins abgehoben");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3-100 Coins")) {
				e.setCancelled(true);
				int coinsPlayer = main.yaml.getInt(p.getName() + ".Bank");
				int gleich = coinsPlayer - 100;
				if (gleich < 0) {
					p.closeInventory();
					p.sendMessage(main.prefix + "Du kannst nich mehr als du hast auszahlen");
				} else {
					main.yaml.set(p.getName() + ".Bank", gleich);
					int BankPlayer = main.yaml.getInt(p.getName() + ".Coins") + 100;
					main.yaml.set(p.getName() + ".Coins", BankPlayer);
					main.yaml.save(main.file);
					p.sendMessage(main.prefix + "Du hast 10 Coins abgehoben");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3-500 Coins")) {
				e.setCancelled(true);
				int coinsPlayer = main.yaml.getInt(p.getName() + ".Bank");
				int gleich = coinsPlayer - 500;
				if (gleich < 0) {
					p.closeInventory();
					p.sendMessage(main.prefix + "Du kannst nich mehr als du hast auszahlen");
				} else {
					main.yaml.set(p.getName() + ".Bank", gleich);
					int BankPlayer = main.yaml.getInt(p.getName() + ".Coins") + 500;
					main.yaml.set(p.getName() + ".Coins", BankPlayer);
					main.yaml.save(main.file);
					p.sendMessage(main.prefix + "Du hast 10 Coins abgehoben");
				}
			}
		} catch (Exception d) {

		}

	}

}
