package classes.Coins;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import classes.main;
import classes.Online.Methode;

public class CMD_Coins implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(p.hasPermission("playcraft.team.coins")) {
			if(args.length == 0) {
				p.sendMessage("§5§l[]§3§l==========§5§l[Coins]§3§l==========§5§l[]");
				p.sendMessage(main.prefix + "/Coins add <Player> <Menge>");
				p.sendMessage(main.prefix + "/Coins remove <Player> <Menge>");
				p.sendMessage(main.prefix + "/Coins set <Player> <Menge>");
				p.sendMessage(main.prefix + "/Coins get <Player>");
				p.sendMessage("§5§l[]§3§l==========§5§l[Coins]§3§l==========§5§l[]");
			} else if(args[0].equalsIgnoreCase("add")) {
				if(args.length == 3) {
					Player d = Bukkit.getPlayer(args[1]);
					int menge = Integer.valueOf(args[2]);
					try {
						Methoden.addMoney(d, menge, p);
					} catch(Exception g) {
						p.sendMessage(main.prefix + "Dieser Spieler ist nicht Online oder");
						p.sendMessage(main.prefix + "Die Menge ist/sind kein Zahl/Zahlen");
					}
				} else {
					p.sendMessage(main.prefix + "Falscher Befel mache /Coins");
				}
				
				
			} else if(args[0].equalsIgnoreCase("remove")) {
				if(args.length == 3) {
					Player d = Bukkit.getPlayer(args[1]);
					int menge = Integer.valueOf(args[2]);
					try {
						Methoden.removeMoney(d, menge, p);
					} catch(Exception g) {
						p.sendMessage(main.prefix + "Dieser Spieler ist nicht Online oder");
						p.sendMessage(main.prefix + "Die Menge ist/sind kein Zahl/Zahlen");
					}
					
					
				} else {
					p.sendMessage(main.prefix + "Falscher Befel mache /Coins");
				}
				
				
			} else if(args[0].equalsIgnoreCase("set")) {
				if(args.length == 3) {
					Player d = Bukkit.getPlayer(args[1]);
					int menge = Integer.valueOf(args[2]);
					try {
						Methoden.setMoney(d, menge, p);
					} catch(Exception g) {
						p.sendMessage(main.prefix + "Dieser Spieler ist nicht Online oder");
						p.sendMessage(main.prefix + "Die Menge ist/sind kein Zahl/Zahlen");
					}
				} else {
					p.sendMessage(main.prefix + "Falscher Befel mache /Coins");
				}
				
				
			} else if(args[0].equalsIgnoreCase("get")) {
				if(args.length == 2) {
					Player d = Bukkit.getPlayer(args[1]);
					try {
						Methoden.getMoney(d, p);
					} catch(Exception g) {
						p.sendMessage(main.prefix + "Dieser Spieler ist nicht Online oder");
					}
				} else {
					p.sendMessage(main.prefix + "Falscher Befel mache /Coins");
				}
				
				
			} else if(args[0].equalsIgnoreCase("open")) {
				Methode.createOnlineInv(p);
			}
		} else {
			p.sendMessage(main.prefix + "Du hast keine Berechtigung dafür!");
		}
		return false;
	}

}
