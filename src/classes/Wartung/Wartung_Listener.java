package classes.Wartung;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import classes.main;
import classes.Chat.Chat_Methoden;

public class Wartung_Listener implements Listener, CommandExecutor{
	
	public static File file = new File("plugins//RealLife//wartung.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public void onJoin(PlayerJoinEvent e) {
		List<String> supporter = Chat_Methoden.cfg.getStringList(".Supporter");
		List<String> Moderator = Chat_Methoden.cfg.getStringList(".Moderator");
		List<String> Builder = Chat_Methoden.cfg.getStringList(".Builder");
		List<String> Developer = Chat_Methoden.cfg.getStringList(".Developer");
		List<String> Admin = Chat_Methoden.cfg.getStringList(".Admin");
		List<String> Owner = Chat_Methoden.cfg.getStringList(".Owner");
		Player p = e.getPlayer();
		
		if(cfg.getBoolean("wartung") == true) {
			
			if(Owner.contains(p.getName())) {
				
			} else if(Admin.contains(p.getName())) {
				
			} else if(Developer.contains(p.getName())) {
				
			} else if(Builder.contains(p.getName())) {
				
			} else if(Moderator.contains(p.getName())) {
				
			} else if(supporter.contains(p.getName())) {
				
			} else {
				p.kickPlayer(main.prefix + "§4Der Server ist in Wartung!");
			}
			
		}
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cfg.getBoolean("wartung") == true) {
			cfg.set("wartung", false);
			p.sendMessage(main.prefix + "Wartung ist nun Aus");
			try {
				cfg.save(file);
			} catch (IOException e) {
			}
		} else {
			cfg.set("wartung", true);
			p.sendMessage(main.prefix + "Wartung ist nun An");
			try {
				cfg.save(file);
			} catch (IOException e) {
			}
		}
		
		return false;
	}

}
