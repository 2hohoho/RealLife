package classes.Jobs;

import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import classes.main;

public class Jobs {

	public static void Miner(Player p) {
		loadFile();
		if (main.yaml.getString(p.getName() + ".Job").equalsIgnoreCase("Arbeitslos")) {
			p.sendMessage(main.prefix + "Du bist dem Job Miner beigetreten");
			main.yaml.set(p.getName() + ".Job", "Miner");
			try {
				main.yaml.save(main.file);
			} catch (IOException e) {
			}
		} else {
			p.sendMessage(main.prefix + "Du hast bereits einen Job");
		}
	}

	public static void Holzfaeller(Player p) {
		loadFile();
		if (main.yaml.getString(p.getName() + ".Job").equalsIgnoreCase("Arbeitslos")) {
			p.sendMessage(main.prefix + "Du bist dem Job Holzfäller beigetreten");
			main.yaml.set(p.getName() + ".Job", "Holzfaeller");
			try {
				main.yaml.save(main.file);
			} catch (IOException e) {
			}
		} else {
			p.sendMessage(main.prefix + "Du hast bereits einen Job");
		}
	}

	public static void Graeber(Player p) {
		loadFile();
		if (main.yaml.getString(p.getName() + ".Job").equalsIgnoreCase("Arbeitslos")) {
			p.sendMessage(main.prefix + "Du bist dem Job Gräber beigetreten");
			main.yaml.set(p.getName() + ".Job", "Graeber");
			try {
				main.yaml.save(main.file);
			} catch (IOException e) {
			}
		} else {
			p.sendMessage(main.prefix + "Du hast bereits einen Job");
		}
	}
	
	private static void loadFile() {
		try {
			main.yaml.load(main.file);
		} catch (IOException | InvalidConfigurationException e) {
		}
	}
}
