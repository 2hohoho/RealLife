package classes.Chat;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

@SuppressWarnings("deprecation")
public class chat_Listener implements Listener {

	public static boolean rank(Player name) {
		List<String> spieler = Chat_Methoden.cfg.getStringList(".Spieler");
		List<String> supporter = Chat_Methoden.cfg.getStringList(".Supporter");
		List<String> Moderator = Chat_Methoden.cfg.getStringList(".Moderator");
		List<String> Builder = Chat_Methoden.cfg.getStringList(".Builder");
		List<String> Developer = Chat_Methoden.cfg.getStringList(".Developer");
		List<String> Admin = Chat_Methoden.cfg.getStringList(".Admin");
		List<String> Owner = Chat_Methoden.cfg.getStringList(".Owner");
		if (Owner.contains(name.getName())) {
		} else if (Admin.contains(name.getName())) {
			return true;
		} else if (Developer.contains(name.getName())) {
			return true;
		} else if (Builder.contains(name.getName())) {
			return true;
		} else if (Moderator.contains(name.getName())) {
			return true;
		} else if (supporter.contains(name.getName())) {
			return true;
		} else if (spieler.contains(name.getName())) {
			return false;
		}

		return false;
	}

	@EventHandler
	public void onChat(PlayerChatEvent e) {
		Player p = e.getPlayer();
		String naricht = e.getMessage();
		e.setCancelled(true);
		List<String> spieler = Chat_Methoden.cfg.getStringList(".Spieler");
		List<String> supporter = Chat_Methoden.cfg.getStringList(".Supporter");
		List<String> Moderator = Chat_Methoden.cfg.getStringList(".Moderator");
		List<String> Builder = Chat_Methoden.cfg.getStringList(".Builder");
		List<String> Developer = Chat_Methoden.cfg.getStringList(".Developer");
		List<String> Admin = Chat_Methoden.cfg.getStringList(".Admin");
		List<String> Owner = Chat_Methoden.cfg.getStringList(".Owner");
		String name = p.getName();

		for (Player player : Bukkit.getOnlinePlayers()) {
			if (naricht.startsWith("@")) {
				String prefix = "§8§l[§3Teamchat§8§l] ";
				if (Owner.contains(name)) {
					if (rank(player) == true) {
						player.sendMessage(prefix + "§4§lOwner §b" + name + "§7: " + naricht.replace("@", ""));
					}
				} else if (Admin.contains(name)) {
					if (rank(player) == true) {
						player.sendMessage(prefix + "§c§lAdmin §b" + name + "§7: " + naricht.replace("@", ""));
					}

				} else if (Developer.contains(name)) {
					if (rank(player) == true) {
						player.sendMessage(prefix + "§a§lDeveloper §b" + name + "§7: " + naricht.replace("@", ""));
					}

				} else if (Builder.contains(name)) {
					if (rank(player) == true) {
						player.sendMessage(prefix + "§e§lBuilder §b" + name + "§7: " + naricht.replace("@", ""));
					}

				} else if (Moderator.contains(name)) {
					if (rank(player) == true) {
						player.sendMessage(prefix + "§1§lModerator §b" + name + "§7 " + naricht.replace("@", ""));
					}

				} else if (supporter.contains(name)) {
					if (rank(player) == true) {
						player.sendMessage(prefix + "§9§lSupporter §b" + name + "§7: " + naricht.replace("@", ""));
					}
					if (Owner.contains(name)) {
						player.sendMessage("§4§lOwner §b" + name + "§7: " + naricht.replace("@", ""));
					} else if (Admin.contains(name)) {
						player.sendMessage("§c§lAdmin §b" + name + "§7: " + naricht.replace("@", ""));
					} else if (Developer.contains(name)) {
						player.sendMessage("§a§lDeveloper §b" + name + "§7: " + naricht.replace("@", ""));
					} else if (Builder.contains(name)) {
						player.sendMessage("§e§lBuilder §b" + name + "§7: " + naricht.replace("@", ""));
					} else if (Moderator.contains(name)) {
						player.sendMessage("§1§lModerator §b" + name + "§7 " + naricht.replace("@", ""));
					} else if (supporter.contains(name)) {
						player.sendMessage("§9§lSupporter §b" + name + "§7: " + naricht.replace("@", ""));
					} else if (spieler.contains(name)) {
						player.sendMessage("§7§lSpieler §b" + name + "§7: " + naricht.replace("@", ""));
					}
				}
			} else {
				if (Owner.contains(name)) {
					player.sendMessage("§4§lOwner §b" + name + "§7: " + naricht);
				} else if (Admin.contains(name)) {
					player.sendMessage("§c§lAdmin §b" + name + "§7: " + naricht);
				} else if (Developer.contains(name)) {
					player.sendMessage("§a§lDeveloper §b" + name + "§7: " + naricht);
				} else if (Builder.contains(name)) {
					player.sendMessage("§e§lBuilder §b" + name + "§7: " + naricht);
				} else if (Moderator.contains(name)) {
					player.sendMessage("§1§lModerator §b" + name + "§7 " + naricht);
				} else if (supporter.contains(name)) {
					player.sendMessage("§9§lSupporter §b" + name + "§7: " + naricht);
				} else if (spieler.contains(name)) {
					player.sendMessage("§7§lSpieler §b" + name + "§7: " + naricht);
				}
			}
		}
	}

	@EventHandler
	public static void onJoin(PlayerJoinEvent e) {
		Chat_Methoden.createrang();
		List<String> spieler = Chat_Methoden.cfg.getStringList(".Spieler");
		List<String> supporter = Chat_Methoden.cfg.getStringList(".Supporter");
		List<String> Moderator = Chat_Methoden.cfg.getStringList(".Moderator");
		List<String> Builder = Chat_Methoden.cfg.getStringList(".Builder");
		List<String> Developer = Chat_Methoden.cfg.getStringList(".Developer");
		List<String> Admin = Chat_Methoden.cfg.getStringList(".Admin");
		List<String> Owner = Chat_Methoden.cfg.getStringList(".Owner");
		Player p = e.getPlayer();
		String name = p.getName();
		if (Owner.contains(name)) {

		} else if (Admin.contains(name)) {

		} else if (Developer.contains(name)) {

		} else if (Builder.contains(name)) {

		} else if (Moderator.contains(name)) {

		} else if (supporter.contains(name)) {

		} else if (!spieler.contains(name)) {
			spieler.add(name);
			Chat_Methoden.cfg.set(".Spieler", spieler);
			Chat_Methoden.save();
		}
	}

}
