package classes.PlayerRegion;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import classes.main;
import classes.Bank.Methoden;

public class Plot_Listener implements Listener {

	public static Map<Player, Location[]> locs = new HashMap<>();
	public static HashMap<String, Location> locs1 = new HashMap<>();
	public static HashMap<String, Location> locs2 = new HashMap<>();

	@EventHandler
	public void onIAct(PlayerInteractEvent e) {
		try {
			if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (e.getItem() != null && e.getItem().getType() == Material.GOLD_HOE) {
					Player p = e.getPlayer();
					Block b = e.getClickedBlock();
					World world = p.getWorld();
					if (world.getName().equalsIgnoreCase(main.plotworldName)) {
						if (!locs.containsKey(p))
							locs.put(p, new Location[2]);
						if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
							e.setCancelled(true);
							locs.get(p)[0] = b.getLocation();
							locs1.put(p.getName(), b.getLocation());
							p.sendMessage(main.prefix + "1 Position Gesetzt");
						}
						if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
							e.setCancelled(true);
							locs.get(p)[1] = b.getLocation();
							locs2.put(p.getName(), b.getLocation());
							p.sendMessage(main.prefix + "2. Position Gesetzt");
						}

						if (locs.get(p)[0] != null && locs.get(p)[1] != null) {

							int gesammt = Flaecheninhalt.Zusammen(p, Plot_Listener.locs.get(p)[0].getBlockX(),
									Plot_Listener.locs.get(p)[1].getBlockX(), Plot_Listener.locs.get(p)[0].getBlockZ(),
									Plot_Listener.locs.get(p)[1].getBlockZ());

							int BoughtDannach = main.yaml.getInt(p.getName() + ".Bought");

							if (!(BoughtDannach < gesammt)) {
								int menge = main.yaml.getInt(p.getName() + ".Bought");
								main.yaml.set(p.getName() + ".Bought", menge - gesammt);
								try {
									main.yaml.save(main.file);
								} catch (IOException e1) {
								}
								Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
										"pex user " + p.getName() + " remove " + p.getName() + ".claim");
								Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
										"pex user " + p.getName() + " add " + p.getName() + ".claim");
								Plot_Methoden.setPlot(p.getName(), p.getUniqueId(),
										Plot_Listener.locs.get(p)[0].getBlockX(),
										Plot_Listener.locs.get(p)[1].getBlockX(),
										Plot_Listener.locs.get(p)[0].getBlockZ(),
										Plot_Listener.locs.get(p)[1].getBlockZ());

								p.sendMessage("§5§l[]§3§l==========§5§l[Claim]§3§l==========§5§l[]");
								p.sendMessage(main.prefix + "Dein Grundstück wurde gesichert");
								p.sendMessage(main.prefix + "Pos1 X: " + Plot_Listener.locs.get(p)[0].getBlockX());
								p.sendMessage(main.prefix + "Pos1 Z: " + Plot_Listener.locs.get(p)[0].getBlockZ());
								p.sendMessage("");
								p.sendMessage(main.prefix + "Pos2 X: " + Plot_Listener.locs.get(p)[1].getBlockX());
								p.sendMessage(main.prefix + "Pos2 Z: " + Plot_Listener.locs.get(p)[1].getBlockZ());
								p.sendMessage(main.prefix + "Dein Grunstück ist " + gesammt + "blöcke² groß");
								p.sendMessage("§5§l[]§3§l==========§5§l[Claim]§3§l==========§5§l[]");
								Plot_Methoden.pfeiler(p, Plot_Listener.locs.get(p)[0].getBlockX(),
										Plot_Listener.locs.get(p)[1].getBlockX(),
										Plot_Listener.locs.get(p)[0].getBlockZ(),
										Plot_Listener.locs.get(p)[2].getBlockZ());
								Plot_Listener.locs.remove(p);
								Plot_Listener.locs1.remove(p);
								Plot_Listener.locs2.remove(p);
							} else {
								p.sendMessage(main.prefix
										+ "Du hast nicht Genug Blöcke² gekauft um dir das Grundstück in dieser Größe zu kaufen. Du brauchst "
										+ gesammt + " Blöcke²");
								Plot_Listener.locs.remove(p);
								Plot_Listener.locs1.remove(p);
								Plot_Listener.locs2.remove(p);
							}
						}
					} else {
						p.sendMessage(main.prefix + "Du kannst nur in der Bauwelt Grundstücke setzen");
					}
				}
			}
		} catch (Exception d) {

		}
	}

	@EventHandler
	public void BlockBreakOwner(BlockBreakEvent e) {
		Player p = e.getPlayer();
		try {
			String world = p.getWorld().getName();
			if (world.equalsIgnoreCase(main.plotworldName)) {
				UUID uuid = Plot_Methoden.getPlotHolderFrom(e.getBlock());
				OfflinePlayer name = Bukkit.getOfflinePlayer(uuid);
				if (uuid != null) {
					if (p.getUniqueId() == name.getUniqueId()) {
					} else if (!Plot_Methoden.cfg.getStringList(name.getName() + ".Spieler").contains(p.getName())) {
						e.setCancelled(true);
						p.sendMessage(main.prefix + "Du kannst nicht auf dem Grundstück von §6" + name.getName()
						+ " §2bauen!");
					}

				} else {
					e.setCancelled(true);
					p.sendMessage(main.prefix + "Du kannst hier nicht bauen!");
				}

			}
		} catch (Exception d) {
			e.setCancelled(true);
			if (p.isOp() == false) {
				e.setCancelled(true);
			} else {
				p.sendMessage(main.prefix + "Du kannst hier nicht bauen!");
			}
		}
	}


	@EventHandler
	public static void blockPlace(BlockPlaceEvent e) {
		try {
			Block b = e.getBlockPlaced();
			Player p = e.getPlayer();
			File perms = new File("plugins//RealLife//Region//permission.yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(perms);
			if (b.getType().equals(Material.FIRE)) {
				UUID uuid = Plot_Methoden.getPlotHolderFrom(e.getBlock());
				OfflinePlayer name = Bukkit.getOfflinePlayer(uuid);
				if (uuid != null) {
					if (p.getUniqueId() == name.getUniqueId()) {
					} else if (Plot_Methoden.cfg.getStringList(name.getName() + ".Spieler").contains(p.getName())) {
						if (yaml.getBoolean(name.getName() + "." + p.getName() + ".FlintAndSteel") == false) {
							e.setCancelled(true);
							p.sendMessage(main.prefix + "Du darfst dies nicht tun!");
						}
					} else {
						e.setCancelled(true);
					}
				}
			}
			UUID uuid = Plot_Methoden.getPlotHolderFrom(e.getBlock());
			OfflinePlayer name = Bukkit.getOfflinePlayer(uuid);
			if (p.getUniqueId() == name.getUniqueId()) {
			} else if (Plot_Methoden.cfg.getStringList(name.getName() + ".Spieler").contains(p.getName())) {
				if (yaml.getBoolean(name.getName() + "." + p.getName() + ".Animals") == false) {
					e.setCancelled(true);
					p.sendMessage(main.prefix + "Du darfst dies nicht tun!");
				}
			} else {
				e.setCancelled(true);
			}
		} catch (Exception d) {

		}
	}

	@EventHandler
	public static void BlockBreak(BlockBreakEvent e) {
		try {
			Player p = e.getPlayer();
			File perms = new File("plugins//RealLife//Region//permission.yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(perms);
			UUID uuid = Plot_Methoden.getPlotHolderFrom(e.getBlock());
			OfflinePlayer name = Bukkit.getOfflinePlayer(uuid);
			if (p.getUniqueId() == name.getUniqueId()) {
			} else if (Plot_Methoden.cfg.getStringList(name.getName() + ".Spieler").contains(p.getName())) {
				if (yaml.getBoolean(name.getName() + "." + p.getName() + ".Animals") == false) {
					e.setCancelled(true);
					p.sendMessage(main.prefix + "Du darfst dies nicht tun!");
				}
			} else {
				e.setCancelled(true);
			}
		} catch (Exception d) {

		}
	}
	
	
	@EventHandler
	public static void onRightClick(PlayerInteractEvent e) {
		File perms = new File("plugins//RealLife//Region//permission.yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(perms);
		try {
			Player p = e.getPlayer();
			if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (e.getClickedBlock().getType() == Material.BEACON) {
					UUID uuid = Plot_Methoden.getPlotHolderFrom(e.getClickedBlock());
					OfflinePlayer name = Bukkit.getOfflinePlayer(uuid);
					if (p.getUniqueId() == name.getUniqueId()) {
					} else if (Plot_Methoden.cfg.getStringList(name.getName() + ".Spieler").contains(p.getName())) {
						if (yaml.getBoolean(name.getName() + "." + p.getName() + ".Beacon") == false) {
							e.setCancelled(true);
							p.sendMessage(main.prefix + "Du darfst dies nicht tun!");
						}
					} else {
						e.setCancelled(true);
						p.sendMessage(main.prefix + "Du darfst dies nicht tun!");
					}
				}
				if (e.getClickedBlock().getType() == Material.ANVIL) {
					UUID uuid = Plot_Methoden.getPlotHolderFrom(e.getClickedBlock());
					OfflinePlayer name = Bukkit.getOfflinePlayer(uuid);
					if (p.getUniqueId() == name.getUniqueId()) {
					} else if (Plot_Methoden.cfg.getStringList(name.getName() + ".Spieler").contains(p.getName())) {
						if (yaml.getBoolean(name.getName() + "." + p.getName() + ".Anvil") == false) {
							e.setCancelled(true);
							p.sendMessage(main.prefix + "Du darfst dies nicht tun!");
						}
					} else {
						e.setCancelled(true);
					}
				}
				if (e.getClickedBlock().getType() == Material.FURNACE) {
					UUID uuid = Plot_Methoden.getPlotHolderFrom(e.getClickedBlock());
					OfflinePlayer name = Bukkit.getOfflinePlayer(uuid);
					if (p.getUniqueId() == name.getUniqueId()) {
					} else if (Plot_Methoden.cfg.getStringList(name.getName() + ".Spieler").contains(p.getName())) {
						if (yaml.getBoolean(name.getName() + "." + p.getName() + ".Furnace") == false) {
							e.setCancelled(true);
							p.sendMessage(main.prefix + "Du darfst dies nicht tun!");
						}
					} else {
						e.setCancelled(true);
					}
				}

				if (e.getClickedBlock().getType() == Material.HOPPER
						|| e.getClickedBlock().getType() == Material.DISPENSER
						|| e.getClickedBlock().getType() == Material.DROPPER) {
					UUID uuid = Plot_Methoden.getPlotHolderFrom(e.getClickedBlock());
					OfflinePlayer name = Bukkit.getOfflinePlayer(uuid);
					if (p.getUniqueId() == name.getUniqueId()) {
					} else if (Plot_Methoden.cfg.getStringList(name.getName() + ".Spieler").contains(p.getName())) {
						if (yaml.getBoolean(name.getName() + "." + p.getName() + ".Redstone") == false) {
							e.setCancelled(true);
							p.sendMessage(main.prefix + "Du darfst dies nicht tun!");
						}
					} else {
						e.setCancelled(true);
					}
				}

				if (e.getClickedBlock().getType() == Material.CHEST
						|| e.getClickedBlock().getType() == Material.TRAPPED_CHEST
						|| e.getClickedBlock().getType() == Material.ENDER_CHEST) {
					UUID uuid = Plot_Methoden.getPlotHolderFrom(e.getClickedBlock());
					OfflinePlayer name = Bukkit.getOfflinePlayer(uuid);
					if (p.getUniqueId() == name.getUniqueId()) {
					} else if (Plot_Methoden.cfg.getStringList(name.getName() + ".Spieler").contains(p.getName())) {
						if (yaml.getBoolean(name.getName() + "." + p.getName() + ".Chest") == false) {
							e.setCancelled(true);
							p.sendMessage(main.prefix + "Du darfst dies nicht tun!");
						}
					} else {
						e.setCancelled(true);
					}
				}
				if (e.getClickedBlock().getType() == Material.WOODEN_DOOR
						|| e.getClickedBlock().getType() == Material.SPRUCE_DOOR
						|| e.getClickedBlock().getType() == Material.BIRCH_DOOR
						|| e.getClickedBlock().getType() == Material.JUNGLE_DOOR
						|| e.getClickedBlock().getType() == Material.ACACIA_DOOR
						|| e.getClickedBlock().getType() == Material.DARK_OAK_DOOR
						|| e.getClickedBlock().getType() == Material.SPRUCE_FENCE_GATE
						|| e.getClickedBlock().getType() == Material.FENCE_GATE
						|| e.getClickedBlock().getType() == Material.ACACIA_FENCE_GATE
						|| e.getClickedBlock().getType() == Material.DARK_OAK_FENCE_GATE
						|| e.getClickedBlock().getType() == Material.JUNGLE_FENCE_GATE
						|| e.getClickedBlock().getType() == Material.BIRCH_FENCE_GATE
						|| e.getClickedBlock().getType() == Material.TRAP_DOOR) {

					UUID uuid = Plot_Methoden.getPlotHolderFrom(e.getClickedBlock());
					OfflinePlayer name = Bukkit.getOfflinePlayer(uuid);
					if (p.getUniqueId() == name.getUniqueId()) {
					} else if (Plot_Methoden.cfg.getStringList(name.getName() + ".Spieler").contains(p.getName())) {
						if (yaml.getBoolean(name.getName() + "." + p.getName() + ".Door") == false) {
							e.setCancelled(true);
							p.sendMessage(main.prefix + "Du darfst dies nicht tun!");
						}
					} else {
						e.setCancelled(true);
					}
				}
				if (e.getClickedBlock().getType() == Material.LEVER
						|| e.getClickedBlock().getType() == Material.WOOD_BUTTON
						|| e.getClickedBlock().getType() == Material.STONE_BUTTON) {
					UUID uuid = Plot_Methoden.getPlotHolderFrom(e.getClickedBlock());
					OfflinePlayer name = Bukkit.getOfflinePlayer(uuid);
					if (p.getUniqueId() == name.getUniqueId()) {
					} else if (Plot_Methoden.cfg.getStringList(name.getName() + ".Spieler").contains(p.getName())) {
						if (yaml.getBoolean(name.getName() + "." + p.getName() + ".Lever") == false) {
							e.setCancelled(true);
							p.sendMessage(main.prefix + "Du darfst dies nicht tun!");
						}
					} else {
						e.setCancelled(true);
					}
				}
			}

		} catch (Exception d) {
		}

	}

	@EventHandler
	public void onInteract(InventoryClickEvent e) {
		try {
			File perms = new File("plugins//RealLife//Region//permission.yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(perms);
			String player = e.getInventory().getName();
			Player p = (Player) e.getWhoClicked();
			for (String name : Plot_Methoden.cfg.getStringList(p.getName() + ".Spieler")) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(name)) {
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3")) {
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Beacon")) {
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Türen/Tore öffnen")) {
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Hebel/Knöpfe")) {
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Feuer")) {
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Bauen")) {
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Hopper öffnen")) {
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Ambos nutzbar")) {
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Truhen öffnen")) {
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Öfen öffnen")) {
					e.setCancelled(true);
				}

				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Verboten§1")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Beacon", true);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Verboten§2")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Door", true);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Verboten§3")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Lever", true);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Verboten§4")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".FlintAndSteel", true);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Verboten§5")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Animals", true);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Verboten§6")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Redstone", true);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Verboten§7")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Anvil", true);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Verboten§8")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Chest", true);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Verboten§a")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Furnace", true);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}

				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Erlaubt§1")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Beacon", false);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Erlaubt§2")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Door", false);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Erlaubt§3")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Lever", false);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Erlaubt§4")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".FlintAndSteel", false);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Erlaubt§5")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Animals", false);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Erlaubt§6")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Redstone", false);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Erlaubt§7")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Anvil", false);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Erlaubt§8")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Chest", false);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Erlaubt§a")) {
					e.setCancelled(true);
					yaml.set(p.getName() + "." + player + ".Furnace", false);
					yaml.save(perms);
					Plot_Methoden.updateInventory(p, player);
				}
				if (e.getInventory().getName().equalsIgnoreCase("§3Spieler Liste")) {
					if (e.getAction() == InventoryAction.PICKUP_HALF) {
						if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(name)) {
							removePlayer(p, name);
						}
					} else {
						if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(name)) {
							Plot_Methoden.updateInventory(p, name);
						}
					}

				}
				if (e.getInventory().getName().equalsIgnoreCase(name)) {
					if (e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase("§2Ja Ich möchte " + name + " entfernen.")) {
						e.setCancelled(true);
						p.sendMessage(main.prefix + "Du hast den Spieler " + name + " entfernt");
						List<String> list = Plot_Methoden.cfg.getStringList(p.getName() + ".Spieler");
						list.remove(name);
						Plot_Methoden.cfg.set(p.getName() + ".Spieler", list);
						Plot_Methoden.cfg.save(Plot_Methoden.file);
						p.closeInventory();
					}
					if (e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase("§4Nein ich möchte nicht " + name + " entfernen.")) {
						e.setCancelled(true);
						p.closeInventory();
						p.sendMessage(main.prefix + "§4Du hast den vorgang abgebrochen");
					}
				}
			}
		} catch (Exception e1) {
		}
	}

	public static void removePlayer(Player p, String name) {

		Inventory inv = Bukkit.createInventory(null, 9, name);

		ItemStack ja = Methoden.createMetaItem(Material.WOOL, 1, (short) 5, "§2Ja Ich möchte " + name + " entfernen.");
		ItemStack nein = Methoden.createMetaItem(Material.WOOL, 1, (short) 14,
				"§4Nein ich möchte nicht " + name + " entfernen.");

		inv.setItem(0, nein);
		inv.setItem(8, ja);

		p.openInventory(inv);
	}

	@EventHandler
	public void BlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		try {
			String world = p.getWorld().getName();
			if (world.equalsIgnoreCase(main.plotworldName)) {
				UUID uuid = Plot_Methoden.getPlotHolderFrom(e.getBlock());
				OfflinePlayer name = Bukkit.getOfflinePlayer(uuid);
				if (uuid != null) {
					if (p.getUniqueId() == name.getUniqueId()) {
					} else if (!Plot_Methoden.cfg.getStringList(name.getName() + ".Spieler").contains(p.getName())) {
						e.setCancelled(true);
						p.sendMessage(main.prefix + "Du kannst nicht auf dem Grundstück von §6" + name.getName()
								+ " §2bauen!");
					}

				} else {
					e.setCancelled(true);
					p.sendMessage(main.prefix + "Du kannst hier nicht bauen!");
				}

			}
		} catch (Exception d) {
			e.setCancelled(true);
			if (p.isOp() == false) {
				e.setCancelled(true);
			} else {
				p.sendMessage(main.prefix + "Du kannst hier nicht bauen!");
			}
		}
	}

}
