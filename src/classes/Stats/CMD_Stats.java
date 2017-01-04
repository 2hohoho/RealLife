package classes.Stats;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import classes.main;

public class CMD_Stats implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("Stats")) {
			p.sendMessage("§5§l[]§3§l==========§5§l[" + p.getName() + "]§3§l==========§5§l[]");
			p.sendMessage(main.prefix + "Name: " + p.getName());
			p.sendMessage(main.prefix + "Job: " + main.yaml.getString(p.getName() + ".Job"));
			p.sendMessage(main.prefix + "Coins: " + main.yaml.getInt(p.getName() + ".Coins"));
			p.sendMessage(main.prefix + "Bank: " + main.yaml.getInt(p.getName() + ".Konto"));
			p.sendMessage(main.prefix + "Spielzeit: " + main.yaml.getInt(p.getName() + ".stunde") + "h "
					+ main.yaml.getInt(p.getName() + ".minuten") + "min");
			p.sendMessage(main.prefix + "Online Link: https://playcraft.de/stats.php?Name=" + p.getName());
			p.sendMessage("§5§l[]§3§l==========§5§l[" + p.getName() + "]§3§l==========§5§l[]");
		}

		return false;
	}

}
