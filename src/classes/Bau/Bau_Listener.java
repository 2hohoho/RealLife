package classes.Bau;

import java.util.ArrayList;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import classes.main;

public class Bau_Listener implements Listener {

	public static ArrayList<String> bauen = new ArrayList<>();

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		try {
			Player p = e.getPlayer();
			World world = p.getWorld();
			if (world.getName().equalsIgnoreCase(main.spawnworldName)) {
				if (!bauen.contains(p.getName())) {
					e.setCancelled(true);
					p.sendMessage(main.prefix + "Du kannst in dieser Welt nichts abbauen!");
				} else {

				}
			}
		} catch (Exception d) {

		}
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		try {
			Player p = e.getPlayer();
			World world = p.getWorld();
			if (world.getName().equalsIgnoreCase(main.spawnworldName)) {
				if (!bauen.contains(p.getName())) {
					e.setCancelled(true);
					p.sendMessage(main.prefix + "Du kannst in dieser Welt nicht bauen!");
				} else {

				}
			}
		} catch (Exception d) {

		}
	}

}
