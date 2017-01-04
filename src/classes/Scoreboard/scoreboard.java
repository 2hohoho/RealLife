package classes.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import classes.main;

public class scoreboard {
	public static void createScoreboard(Player p) {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();

		Objective obj = board.registerNewObjective("aaa", "bbb");

		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("§3Playcraft.de §6- §aRealLife");

		/*
		 * 
		 * 
		 * 
		 */
		Team line1 = board.registerNewTeam("line1");
		line1.setPrefix("§6▃▃▃▃§1"); //
		line1.setSuffix("§6▃▃▃▃§2");
		line1.addEntry(ChatColor.AQUA.toString());

		obj.getScore(ChatColor.AQUA.toString()).setScore(13);

		/*
		 * 
		 * Coins
		 * 
		 */

		Team Coins = board.registerNewTeam("Coins");
		Coins.setPrefix("§3Coins");
		Coins.addEntry(ChatColor.DARK_AQUA.toString());

		obj.getScore(ChatColor.DARK_AQUA.toString()).setScore(12);

		Team Coins1 = board.registerNewTeam("Coins1");
		Coins1.setPrefix("§a" + main.yaml.getInt(p.getName() + ".Coins") + "§a");
		Coins1.addEntry(ChatColor.DARK_BLUE.toString());

		obj.getScore(ChatColor.DARK_BLUE.toString()).setScore(11);

		/*
		 * 
		 * 
		 * 
		 */
		Team line2 = board.registerNewTeam("line2");
		line2.setPrefix("§6▃▃▃▃§e"); //
		line2.setSuffix("§6▃▃▃▃§f");
		line2.addEntry(ChatColor.BLACK.toString());

		obj.getScore(ChatColor.BLACK.toString()).setScore(10);

		Team Bank = board.registerNewTeam("Bank");
		Bank.setPrefix("§3Bank");
		Bank.addEntry(ChatColor.DARK_PURPLE.toString());

		obj.getScore(ChatColor.DARK_PURPLE.toString()).setScore(9);

		Team Bank1 = board.registerNewTeam("Bank1");
		Bank1.setPrefix("§a" + main.yaml.getInt(p.getName() + ".Bank") + "§a");
		Bank1.addEntry(ChatColor.WHITE.toString());

		obj.getScore(ChatColor.WHITE.toString()).setScore(8);

		Team line3 = board.registerNewTeam("line3");
		line3.setPrefix("§6▃▃▃▃§e"); //
		line3.setSuffix("§6▃▃▃▃§f");
		line3.addEntry(ChatColor.DARK_RED.toString());

		obj.getScore(ChatColor.DARK_RED.toString()).setScore(7);

		Team Jobs = board.registerNewTeam("Jobs");
		Jobs.setPrefix("§3Job");
		Jobs.addEntry(ChatColor.DARK_GRAY.toString());

		obj.getScore(ChatColor.DARK_GRAY.toString()).setScore(6);


		Team Jobs1 = board.registerNewTeam("Jobs1");
		if (main.yaml.getString(p.getName() + ".Job") != null) {
			Jobs1.setPrefix("§a" + main.yaml.getString(p.getName() + ".Job") + "§a");
		} else {
			Jobs1.setPrefix("§aArbeitslos§a");
		}
		Jobs1.addEntry(ChatColor.DARK_GREEN.toString());

		obj.getScore(ChatColor.DARK_GREEN.toString()).setScore(5);

		Team line4 = board.registerNewTeam("line4");
		line4.setPrefix("§6▃▃▃▃§e"); //
		line4.setSuffix("§6▃▃▃▃§f");
		line4.addEntry(ChatColor.UNDERLINE.toString());

		obj.getScore(ChatColor.UNDERLINE.toString()).setScore(4);
		
		
		Team Claim = board.registerNewTeam("Claim");
		Claim.setPrefix("§3Blöcke²");
		Claim.addEntry(ChatColor.STRIKETHROUGH.toString());

		obj.getScore(ChatColor.STRIKETHROUGH.toString()).setScore(3);
		
		
		Team Size = board.registerNewTeam("Blöcke²");
		Size.setPrefix("§a" + main.yaml.getInt(p.getName() + ".Bought" + "§9"));
		Size.addEntry(ChatColor.ITALIC.toString());
		obj.getScore(ChatColor.ITALIC.toString()).setScore(2);

		Team line5 = board.registerNewTeam("line5");
		line5.setPrefix("§6▃▃▃▃§e"); //
		line5.setSuffix("§6▃▃▃▃§f");
		line5.addEntry(ChatColor.YELLOW.toString());

		obj.getScore(ChatColor.YELLOW.toString()).setScore(1);

		main.boards.put(board, p);

		p.setScoreboard(board);

	}
	

}
