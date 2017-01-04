package classes.Coins;

import java.io.IOException;

import org.bukkit.entity.Player;

import classes.main;

public class Methoden {
	
	public static void addMoney(Player d, int Menge, Player p) {
		int money = main.yaml.getInt(d.getName() + ".Coins");
		int moneyJz= money + Menge;
		main.yaml.set(d.getName() + ".Coins", moneyJz);
		try {
			main.yaml.save(main.file);
		} catch (IOException e) {
		}
		p.sendMessage(main.prefix + "Du hast dem Spieler " + d.getName() + " " + Menge + " Dazugegeben");
		d.sendMessage(main.prefix + "Dir wurden " + Menge + " Coins hinzugefügt");
	}
	
	
	public static void setMoney(Player d, int Menge, Player p) {
		main.yaml.set(d.getName() + ".Coins", Menge);
		try {
			main.yaml.save(main.file);
		} catch (IOException e) {
		}
		p.sendMessage(main.prefix + "Du hast dem Spieler " + d.getName() + " die Coins auf " + Menge + " gesetzt");
		d.sendMessage(main.prefix + "Deine Coins wurden auf " + Menge + " gesetzt!");
	}
	
	
	public static void removeMoney(Player d, int Menge, Player p) {
		int money = main.yaml.getInt(d.getName() + ".Coins");
		int moneyJz= money - Menge;
		main.yaml.set(d.getName() + ".Coins", moneyJz);
		try {
			main.yaml.save(main.file);
		} catch (IOException e) {
		}
		p.sendMessage(main.prefix + "Du hast dem Spieler " + d.getName() + " " + Menge + " Weggenommen");
		d.sendMessage(main.prefix + "Dir wurden " + Menge + " Coins abgezogen");
	}
	
	public static void getMoney(Player d, Player p) {
		int money = main.yaml.getInt(d.getName() + ".Coins");
		p.sendMessage(main.prefix + "Der Spieler " + d.getName() + " hat " + money + " Coins");
	}
}
