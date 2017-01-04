package classes.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

import classes.main;

public class SQLStats {

	public static boolean playerExists(String uuid) {

		try {

			ResultSet rs = main.mysql.query("SELECT * FROM Stats WHERE UUID='" + uuid + "'");
			if (rs.next()) {
				return rs.getString("UUID") != null;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public static void createPlayer(String uuid, Player p) {
		
	if(!playerExists(uuid)) {
		main.mysql.update("INSERT INTO Stats(Name, UUID, Job, Coins, Bank, OnlineStatus) VALUES ('" + p.getName() + "', '" + uuid + "', 'Arbeitslos', '0', '0', 'Offline');");
	}
	}
	
	
	public static void setCoins(Player p, Integer Coins) {
		String uuid = p.getUniqueId().toString();
		if(playerExists(uuid)) {
			main.mysql.update("UPDATE Stats SET Coins= '" + Coins + "' WHERE UUID= '" + uuid + "';");
		} else {
			createPlayer(uuid, p);
			setCoins(p, Coins);
		}
		
	}
	
	
	
	public static void setBank(Player p, Integer Bank) {
		String uuid = p.getUniqueId().toString();
		if(playerExists(uuid)) {
			main.mysql.update("UPDATE Stats SET Bank= '" + Bank + "' WHERE UUID= '" + uuid + "';");
		} else {
			createPlayer(uuid, p);
			setBank(p, Bank);
		}
		
	}
	
	
	
	public static void setJob(Player p, String Job) {
		String uuid = p.getUniqueId().toString();
		if(playerExists(uuid)) {
			main.mysql.update("UPDATE Stats SET Job= '" + Job + "' WHERE UUID= '" + uuid + "';");
		} else {
			createPlayer(uuid, p);
			setJob(p, Job);
		}
		
	}
	
	
	public static void setOnline(Player p, String Online) {
		String uuid = p.getUniqueId().toString();
		if(playerExists(uuid)) {
			main.mysql.update("UPDATE Stats SET OnlineStatus= '" + Online + "' WHERE UUID= '" + uuid + "';");
		} else {
			createPlayer(uuid, p);
			setJob(p, Online);
		}
		
	}
	

}
