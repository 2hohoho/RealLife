package classes.Jobs;

import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import classes.main;
import classes.Quests.quests;

public class Jobs_Listener implements Listener {
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		try {
			Sign sign = (Sign) e.getClickedBlock().getState();
			if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {

				if (sign.getLine(0).equalsIgnoreCase("§8§l[§3Jobs§8§l]")) {
					Jobs_Methode.Invs(p);
				}
				if (sign.getLine(0).equalsIgnoreCase("§8§l[§3Quests§8§l]")) {
					quests.inv(p);
				}
				
				if (sign.getLine(0).equalsIgnoreCase("§8§l[§3Miner§8§l]")) {
					if(main.yaml.getString(p.getName() + ".Job").equalsIgnoreCase("Arbeitslos")) {
						main.yaml.set(p.getName() + ".Job", "Miner");
						main.yaml.save(main.file);
						p.sendMessage(main.prefix + "Du bist dem Job Miner beigetreten");
					} else {
						p.sendMessage(main.prefix + "Du hast bereits einen Job");
					}
				}
				
				if (sign.getLine(0).equalsIgnoreCase("§8§l[§3Holzfäller§8§l]")) {
					if(main.yaml.getString(p.getName() + ".Job").equalsIgnoreCase("Arbeitslos")) {
						main.yaml.set(p.getName() + ".Job", "Holzfaeller");
						main.yaml.save(main.file);
						p.sendMessage(main.prefix + "Du bist dem Job Holzfäller beigetreten");
					} else {
						p.sendMessage(main.prefix + "Du hast bereits einen Job");
					}
				}
				if (sign.getLine(0).equalsIgnoreCase("§8§l[§3Gräber§8§l]")) {
					if(main.yaml.getString(p.getName() + ".Job").equalsIgnoreCase("Arbeitslos")) {
						main.yaml.set(p.getName() + ".Job", "Graeber");
						main.yaml.save(main.file);
						p.sendMessage(main.prefix + "Du bist dem Job Gräber beigetreten");
					} else {
						p.sendMessage(main.prefix + "Du hast bereits einen Job");
					}
				}
			}
		} catch (Exception d) {
		}
	}

	@EventHandler
	public void SignChangeEvent(SignChangeEvent e) {
		if (e.getLine(0) != null && e.getLine(0) != "") {
			if (e.getLine(0).equalsIgnoreCase("[Jobs]")) {
				e.setLine(0, "§8§l[§3Jobs§8§l]");
				e.setLine(1, "");
				e.setLine(2, "");
				e.setLine(3, "");
			}
			
			if (e.getLine(0).equalsIgnoreCase("[Quests]")) {
				e.setLine(0, "§8§l[§3Quests§8§l]");
				e.setLine(1, "");
				e.setLine(2, "");
				e.setLine(3, "");
			}
			
			if (e.getLine(0).equalsIgnoreCase("[Miner]")) {
				e.setLine(0, "§8§l[§3Miner§8§l]");
				e.setLine(1, "");
				e.setLine(2, "");
				e.setLine(3, "");
			}
			
			if (e.getLine(0).equalsIgnoreCase("[Holzfäller]")) {
				e.setLine(0, "§8§l[§3Holzfäller§8§l]");
				e.setLine(1, "");
				e.setLine(2, "");
				e.setLine(3, "");
			}
			
			if (e.getLine(0).equalsIgnoreCase("[Gräber]")) {
				e.setLine(0, "§8§l[§3Gräber§8§l]");
				e.setLine(1, "");
				e.setLine(2, "");
				e.setLine(3, "");
			}
		}
	}
}
