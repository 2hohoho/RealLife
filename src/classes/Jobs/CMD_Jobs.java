package classes.Jobs;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import classes.main;
import classes.Jobs.Jobs;

public class CMD_Jobs implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (args.length == 0) {
			p.sendMessage("§5§l[]§3§l==========§5§l[Job]§3§l==========§5§l[]");
			p.sendMessage(main.prefix + "/Jobs Join Miner/Holzfäller/Gräber");
			p.sendMessage(main.prefix + "/Jobs Verdint");
			p.sendMessage(main.prefix + "/Jobs Abrechnung");
			p.sendMessage("§5§l[]§3§l==========§5§l[Job]§3§l==========§5§l[]");
		} else if (args[0].equalsIgnoreCase("Join")) {
			if (args.length == 2) {
				if (args[1].equalsIgnoreCase("Miner")) {
					Jobs.Miner(p);
				} else if (args[1].equalsIgnoreCase("Holzfäller")) {
					Jobs.Holzfaeller(p);
				} else if (args[1].equalsIgnoreCase("Gräber")) {
					Jobs.Graeber(p);
				} else {
					p.sendMessage(main.prefix + "Diesen Job gibt es nicht");
				}
			} else {
				p.sendMessage(main.prefix + "Falscher Befel nutze /Jobs");
			}
		} else if (args[0].equalsIgnoreCase("leave")) {
			if (args.length == 1) {
				if (main.yaml.getString(p.getName() + ".Job").equalsIgnoreCase("Miner")
						|| main.yaml.getString(p.getName() + ".Job").equalsIgnoreCase("Holzfäller")
						|| main.yaml.getString(p.getName() + ".Job").equalsIgnoreCase("Gräber")) {
					main.yaml.set(p.getName() + ".Job", "Arbeitslos");
					try {
						main.yaml.save(main.file);
					} catch (IOException e) {
					}
					p.sendMessage(main.prefix + "Du hast Deinen Job gekündigt");
				} else {
					p.sendMessage(main.prefix + "Du hast kein Job den du Kündigen kanst");
				}
			} else {
				p.sendMessage(main.prefix + "Falscher Befel nutze /Jobs");
			}
		}
		return false;
	}

}
