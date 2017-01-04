package classes;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import org.bukkit.event.Listener;

import classes.Bank.Listener_Bank;
import classes.Bau.Bau_Listener;
import classes.Bau.CMD_Bau;
import classes.Chat.chat_Listener;
import classes.Coins.CMD_Coins;
import classes.Jobs.CMD_Jobs;
import classes.Jobs.Jobs_Listener;
import classes.MySQL.MySQL;
import classes.MySQL.SQLStats;
import classes.PlayerRegion.CMD_Plot;
import classes.PlayerRegion.Plot_Listener;
import classes.Quests.quests;
import classes.Scoreboard.scoreboard;
import classes.Spieler.CMD_Team;
import classes.Stats.CMD_Stats;
import classes.Wartung.Wartung_Listener;

public class main extends JavaPlugin implements Listener {

	public static String prefix = "§8§l[§3§lPlaycraft.de§8§l]§2 ";
	public static File file = new File("plugins//RealLife//stats.yml");
	public static YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

	public static File filePlot = new File("plugins//RealLife//Plot.yml");
	public static YamlConfiguration yamlPlot = YamlConfiguration.loadConfiguration(filePlot);
	
	public static File worldResetFile = new File("plugins//RealLife//worldReset.yml");
	public static YamlConfiguration reset = YamlConfiguration.loadConfiguration(worldResetFile);

	public static MySQL mysql;

	public static HashMap<Scoreboard, Player> boards = new HashMap<>();

	public static ArrayList<String> Bauwelt = new ArrayList<>();
	public static ArrayList<String> Plotworld = new ArrayList<>();
	
	public static String plotworldName = "Plotworld";
	public static String spawnworldName = "World2";
	
	@EventHandler
	public static void playerLoginEvent(PlayerLoginEvent e) {
		
		if(e.getAddress().getHostAddress().equalsIgnoreCase("127.0.0.1")) {
			
			e.disallow(Result.KICK_OTHER, "§3Bitte Joine über die Domain: playcraft.de");
			
		}
		
	}

	public void onEnable() {
		try {
			Runtime.getRuntime().exec("../../BungeeCord/start.sh");
			Date zeitstempel = new Date();
			SimpleDateFormat dd = new SimpleDateFormat("dd");
			SimpleDateFormat MM = new SimpleDateFormat("MM");
			SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
			
			String yyyy1 = yyyy.format(zeitstempel);
			String MM1 = MM.format(zeitstempel);
			String dd1 = dd.format(zeitstempel);
			if(!worldResetFile.exists()) {
				
				reset.set("Heute", dd1 + "." + MM1 + "." + yyyy1);
				reset.set("nächster", dd1 + 1 + "." + MM1 + "." + yyyy1);
				reset.save(worldResetFile);
				
			}
			getServer().getPluginManager().registerEvents(new Listener_Bank(), this);
			getServer().getPluginManager().registerEvents(new Jobs_Listener(), this);
			getServer().getPluginManager().registerEvents(new Bau_Listener(), this);
			getServer().getPluginManager().registerEvents(new CMD_Team(), this);
			getServer().getPluginManager().registerEvents(new Plot_Listener(), this);
			getServer().getPluginManager().registerEvents(new quests(), this);
			getServer().getPluginManager().registerEvents(new chat_Listener(), this);
			getServer().getPluginManager().registerEvents(new Wartung_Listener(), this);

			getServer().getPluginManager().registerEvents(this, this);
			Updater();
			/*
			 * 
			 * Start Naricht!
			 * 
			 */
			this.getServer().getConsoleSender().sendMessage("§5§l[]§3§l==========§5§l[RealLife]§3§l==========§5§l[]");
			this.getServer().getConsoleSender().sendMessage("§2Name: RealLife");
			this.getServer().getConsoleSender().sendMessage("§2Author: 2hohoho");
			this.getServer().getConsoleSender().sendMessage("§2Version: 1.0");
			this.getServer().getConsoleSender().sendMessage("§2Copyright Playcraft.de - 2016");
			this.getServer().getConsoleSender().sendMessage("§5§l[]§3§l==========§5§l[RealLife]§3§l==========§5§l[]");

			/*
			 * 
			 * MySQL Verbinden!
			 * 
			 */
			ConnectMySQL();

			/*
			 * 
			 * Commands!
			 * 
			 */
			this.getCommand("Coins").setExecutor(new CMD_Coins());
			this.getCommand("Jobs").setExecutor(new CMD_Jobs());
			this.getCommand("Stats").setExecutor(new CMD_Stats());
			this.getCommand("build").setExecutor(new CMD_Bau());
			this.getCommand("claim").setExecutor(new CMD_Plot());
			this.getCommand("aclaim").setExecutor(new CMD_Plot());
			this.getCommand("team").setExecutor(new CMD_Team());
			this.getCommand("wartung").setExecutor(new Wartung_Listener());

			/*
			 * 
			 * Listener
			 * 
			 */

			/*
			 * 
			 * Files Saven
			 * 
			 */
			if (!file.exists()) {
				try {
					yaml.save(file);
				} catch (IOException e) {
				}
			}
			/*
			 * 
			 * Regions
			 * 
			 */

			/*
			 * 
			 * Updater
			 * 
			 */
			
			
			aktuell();

			
		} catch (

		Exception d) {

		}
	}
	
	public void deleteWorld() {
		
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv delete " + main.plotworldName);
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {

			@Override
			public void run() {
				
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv confirm");
				createWorld();
			}
			
			
			
		}, 20*5);
		
	}

	private void ConnectMySQL() {

		mysql = new MySQL("localhost", "stats", "root", "PlayCraft");
		mysql.update(
				"CREATE TABLE IF NOT EXISTS Stats(Name varchar(64), UUID varchar(64), Job varchar(64), Coins int, Bank int, OnlineStatus varchar(64));");

	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		createWorld();
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				SQLStats.setCoins(p, yaml.getInt(p.getName() + ".Coins"));
				SQLStats.setBank(p, yaml.getInt(p.getName() + ".Bank"));
				SQLStats.setJob(p, yaml.getString(p.getName() + ".Job"));

				if (Bukkit.getPlayer(p.getName()) != null) {
					SQLStats.setOnline(p, "Online");
				} else {
					SQLStats.setOnline(p, "Offline");
				}

			}

		}, 20 * 5, 20 * 5);
		scoreboard.createScoreboard(p);
		if (main.yaml.get(p.getName() + ".Job") == null) {
			main.yaml.set(p.getName() + ".Job", "Arbeitslos");
			try {
				main.yaml.save(main.file);
			} catch (IOException e1) {
			}
		} else {

		}
	}
	
	public void aktuell() {
//TODO
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				Date zeitstempel = new Date();
				SimpleDateFormat dd = new SimpleDateFormat("dd");
				SimpleDateFormat MM = new SimpleDateFormat("MM");
				SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
				
				String yyyy1 = yyyy.format(zeitstempel);
				String MM1 = MM.format(zeitstempel);
				String dd1 = dd.format(zeitstempel);
				reset.set("Heute", dd1 +"." + MM1 + "." + yyyy1);
				try {
					reset.save(worldResetFile);
				} catch (IOException e) {
				}
				if(reset.get("Heute") == reset.get("nächster")) {
					
					reset.set("nächster", dd1 +"." + MM1 + "." + yyyy1);
					try {
						reset.save(worldResetFile);
					} catch (IOException e) {
					}
					deleteWorld();
				}
				
			}
			
			
		}, 20*10 , 20*10);
		
	}
	
	public void createWorld() {
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {

			@Override
			public void run() {

				Bukkit.createWorld(WorldCreator.name(plotworldName));
				
			}
			
			
			
		}, 20*60);
		
	}

	public void Updater() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				for (Scoreboard board : main.boards.keySet()) {
					Player p = boards.get(board);
					if (main.yaml.get(p.getName() + ".Bank") != null) {
						board.getTeam("Bank1").setPrefix("§a" + main.yaml.getInt(p.getName() + ".Bank") + "§a");
					} else {
						board.getTeam("Bank1").setPrefix("§a0§a");
					}
					if (main.yaml.get(p.getName() + ".Bought") != null) {
						board.getTeam("Blöcke²").setPrefix("§a" + main.yaml.getInt(p.getName() + ".Bought") + "§a");
					} else {
						board.getTeam("Blöcke²").setPrefix("§a0§a");
					}
					if (main.yaml.get(p.getName() + ".Coins") != null) {
						board.getTeam("Coins1").setPrefix("§a" + main.yaml.getInt(p.getName() + ".Coins") + "§a");
					} else {
						board.getTeam("Coins1").setPrefix("§a0§a");
					}
					if (main.yaml.getString(p.getName() + ".Job") != null) {
						board.getTeam("Jobs1").setPrefix("§a" + main.yaml.getString(p.getName() + ".Job") + "§a");
					} else {
						board.getTeam("Jobs1").setPrefix("§aArbeitslos§a");
					}
				}
			}

		}, 10 * 1, 10 * 1);

	}
	// TODO

}
