package classes.PlayerRegion;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import classes.Bank.Methoden;

public class Plot_Methoden {

	public static File file = new File("plugins//RealLife//Region//Region.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static void setPlot(String plotName, UUID owner, int x1, int x2, int z1, int z2) {
		cfg.set(plotName + ".owner", owner.toString());
		
		cfg.set(plotName + ".x1", x1);
		cfg.set(plotName + ".x2", x2);
		
		cfg.set(plotName + ".z1", z1);
		cfg.set(plotName + ".z2", z2);		
		
		save();
	}
	
	public static UUID getPlotHolderFrom(Block b) {
		for(String name : cfg.getConfigurationSection("").getKeys(false)) {
			int x1 = cfg.getInt(name + ".x1");
			int x2 = cfg.getInt(name + ".x2");
			
			int z1 = cfg.getInt(name + ".z1");
			int z2 = cfg.getInt(name + ".z2");
			
			
			if(((x1 <= b.getX() && x2 >= b.getX() || (x1 >= b.getX() && x2 <= b.getX())) && ((z1 <= b.getZ() && z2 >= b.getZ() || (z1 >= b.getZ() && z2 <= b.getZ()))))) {
				String uuidString = cfg.getString(name + ".owner");
				return UUID.fromString(uuidString);
				
			}
		}
		
		return null;
		
	}
	
	public static boolean isIn(Location loc, Location locA, Location locB) {
		
		Double maxX = (locA.getX() > locB.getX() ? locA.getX() : locB.getX());
		Double minX = (locA.getX() < locB.getX() ? locA.getX() : locB.getX());
		
		Double maxY = (locA.getY() > locB.getY() ? locA.getY() : locB.getY());
		Double minY = (locA.getY() < locB.getY() ? locA.getY() : locB.getY());
		
		Double maxZ = (locA.getZ() > locB.getZ() ? locA.getZ() : locB.getZ());
		Double minZ = (locA.getZ() < locB.getZ() ? locA.getZ() : locB.getZ());
		
		if(loc.getX() <= maxX && loc.getX() >= minX) {
			if(loc.getY() <= maxY && loc.getY() >= minY) {
				if(loc.getZ() <= maxZ && loc.getZ() >= minZ) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public static void pfeiler(Player p, int x1, int x2, int z1, int z2) {
		

		
		for (int loop = 1; loop <= 256; loop++) {
			
			Location loc = p.getLocation();
			Block b1 = p.getLocation().add(0.0D, loop, 0.0D).getBlock();
	          Block b5 = b1.getLocation().add(0.0D, 1.0D, 0.0D).getBlock();
	          if ((b5.getTypeId() == 0))
	          {
	        	  
	        	  Block b4 = b1.getLocation().add(0.0D, 2.0D, 0.0D).getBlock();
	              loc.setY(b4.getLocation().getY());
	              loc.setX(x2);
	              loc.setZ(z2);
	              loc.setY(loop);
	              loc.setWorld(p.getWorld());
	              loc.getBlock().setType(Material.GOLD_BLOCK);
	          }
			
			
			
		}
		
		
		for (int loop = 1; loop <= 256; loop++) {
			
			Location loc = p.getLocation();
			Block b1 = p.getLocation().add(0.0D, loop, 0.0D).getBlock();
	          Block b5 = b1.getLocation().add(0.0D, 1.0D, 0.0D).getBlock();
	          if ((b5.getTypeId() == 0))
	          {
	        	  
	        	  Block b4 = b1.getLocation().add(0.0D, 2.0D, 0.0D).getBlock();
	              loc.setY(b4.getLocation().getY());
	              loc.setX(x1);
	              loc.setZ(z1);
	              loc.setY(loop);
	              loc.setWorld(p.getWorld());
	              loc.getBlock().setType(Material.GOLD_BLOCK);
	          }
			
			
			
		}
		
	}
	
	public static void SpielerInv(Player p) {
		Inventory inv = Bukkit.createInventory(null, 27, "§3Spieler Liste");
		for(String player : cfg.getStringList(p.getName() + ".Spieler")) {
			ItemStack zocker = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
			SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
			meta.setOwner(player);
			meta.setDisplayName(player);
			zocker.setItemMeta(meta);			
			inv.addItem(zocker);
			
		}
		p.openInventory(inv);
	}

	
	public static void updateInventory(Player p, String player) {
		String name = player;
		File perms = new File("plugins//RealLife//Region//permission.yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(perms);
		
		Inventory inv = Bukkit.createInventory(null, 27, name);
		p.openInventory(inv);

			for (int i = 0; i <= 8; i++) {
				ItemStack zocker = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
				SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
				meta.setOwner(name);
				meta.setDisplayName(name);
				zocker.setItemMeta(meta);

				p.getOpenInventory().setItem(i, zocker);
				p.updateInventory();
			}
			
			ItemStack beacon = Methoden.createItem(Material.BEACON, 1, "§5Beacon");
			ItemStack door = Methoden.createItem(Material.WOOD_DOOR, 1, "§5Türen/Tore öffnen");
			ItemStack lever = Methoden.createItem(Material.LEVER, 1, "§5Hebel/Knöpfe");
			ItemStack flintandsteel = Methoden.createItem(Material.FLINT_AND_STEEL, 1, "§5Feuer");
			ItemStack animal = Methoden.createItem(Material.GRASS, 1, "§5Bauen");
			ItemStack hopper = Methoden.createItem(Material.HOPPER, 1, "§5Hopper öffnen");
			ItemStack anvil = Methoden.createItem(Material.ANVIL, 1, "§5Ambos Nutzbar");
			ItemStack chest = Methoden.createItem(Material.CHEST, 1, "§5Truhen öffnen");
			ItemStack furnace = Methoden.createItem(Material.FURNACE, 1, "§5Öfen öffnen");
			
			
			ItemStack red1 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§4Verboten§1");
			ItemStack red2 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§4Verboten§2");
			ItemStack red3 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§4Verboten§3");
			ItemStack red4 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§4Verboten§4");
			ItemStack red5 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§4Verboten§5");
			ItemStack red6 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§4Verboten§6");
			ItemStack red7 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§4Verboten§7");
			ItemStack red8 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§4Verboten§8");
			ItemStack red9 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 14, "§4Verboten§a");
			
			
			ItemStack green1 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 5, "§2Erlaubt§1");
			ItemStack green2 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 5, "§2Erlaubt§2");
			ItemStack green3 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 5, "§2Erlaubt§3");
			ItemStack green4 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 5, "§2Erlaubt§4");
			ItemStack green5 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 5, "§2Erlaubt§5");
			ItemStack green6 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 5, "§2Erlaubt§6");
			ItemStack green7 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 5, "§2Erlaubt§7");
			ItemStack green8 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 5, "§2Erlaubt§8");
			ItemStack green9 = Methoden.createMetaItem(Material.STAINED_GLASS_PANE, 1, (short) 5, "§2Erlaubt§a");
			
			p.getOpenInventory().setItem(9, beacon);
			p.getOpenInventory().setItem(10, door);
			p.getOpenInventory().setItem(11, lever);
			p.getOpenInventory().setItem(12, flintandsteel);
			p.getOpenInventory().setItem(13, animal);
			p.getOpenInventory().setItem(14, hopper);
			p.getOpenInventory().setItem(15, anvil);
			p.getOpenInventory().setItem(16, chest);
			p.getOpenInventory().setItem(17, furnace);
			
			if(yaml.getBoolean(p.getName() + "." + player + ".Beacon") == false) {
				p.getOpenInventory().setItem(18, red1);
			} else {
				p.getOpenInventory().setItem(18, green1);
			}
			
			if(yaml.getBoolean(p.getName() + "." + player + ".Door") == false) {
				p.getOpenInventory().setItem(19, red2);
			} else {
				p.getOpenInventory().setItem(19, green2);
			}
			if(yaml.getBoolean(p.getName() + "." + player + ".Lever") == false) {
				p.getOpenInventory().setItem(20, red3);
			} else {
				p.getOpenInventory().setItem(20, green3);
			}
			if(yaml.getBoolean(p.getName() + "." + player + ".FlintAndSteel") == false) {
				p.getOpenInventory().setItem(21, red4);
			} else {
				p.getOpenInventory().setItem(21, green4);
			}
			if(yaml.getBoolean(p.getName() + "." + player + ".Animals") == false) {
				p.getOpenInventory().setItem(22, red5);
			} else {
				p.getOpenInventory().setItem(22, green5);
			}
			if(yaml.getBoolean(p.getName() + "." + player + ".Redstone") == false) {
				p.getOpenInventory().setItem(23, red6);
			} else {
				p.getOpenInventory().setItem(23, green6);
			}
			if(yaml.getBoolean(p.getName() + "." + player + ".Anvil") == false) {
				p.getOpenInventory().setItem(24, red7);
			} else {
				p.getOpenInventory().setItem(24, green7);
			}
			if(yaml.getBoolean(p.getName() + "." + player + ".Chest") == false) {
				p.getOpenInventory().setItem(25, red8);
			} else {
				p.getOpenInventory().setItem(25, green8);
			}
			if(yaml.getBoolean(p.getName() + "." + player + ".Furnace") == false) {
				p.getOpenInventory().setItem(26, red9);
			} else {
				p.getOpenInventory().setItem(26, green9);
			}
			p.updateInventory();
		
	}
	public static void resetPerms(Player p, Player d) {
		File perms = new File("plugins//RealLife//Region//permission.yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(perms);
		
		yaml.set(p.getName() + "." + d.getName() + ".Name", d.getName());
		yaml.set(p.getName() + "." + d.getName() + ".Beacon", false);
		yaml.set(p.getName() + "." + d.getName() + ".Door", false);
		yaml.set(p.getName() + "." + d.getName() + ".Lever", false);
		yaml.set(p.getName() + "." + d.getName() + ".FlintAndSteel", false);
		yaml.set(p.getName() + "." + d.getName() + ".Animals", false);
		yaml.set(p.getName() + "." + d.getName() + ".Redstone", false);
		yaml.set(p.getName() + "." + d.getName() + ".Anvil", false);
		yaml.set(p.getName() + "." + d.getName() + ".Chest", false);
		yaml.set(p.getName() + "." + d.getName() + ".Furnace", false);
		try {
			yaml.save(perms);
		} catch (IOException e) {
		}
		
	}
	public static void spawnBlock(Player p, int x1, int x2, int z1, int z2) {
		
		Location loc = p.getLocation();
		loc.setX(x1);
		loc.setZ(z1);
		loc.getBlock().setType(Material.STANDING_BANNER);
		
		loc.setX(x2);
		loc.setZ(z2);
		loc.getBlock().setType(Material.STANDING_BANNER);
		
	}
	
	public static void setPlayers(Player p) {
		
		List<String> list = cfg.getStringList(p.getName() + ".Spieler");
		list.clear();
		list.add(p.getName());
		cfg.set(p.getName() + ".Spieler", list);
		try {
			cfg.save(file);
		} catch (IOException e) {
		}
		
	}
	
	public static void save() {
		try {
			cfg.save(file);
		} catch (IOException e) {
		}
	}
}
