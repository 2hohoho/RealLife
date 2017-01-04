package classes.PlayerRegion;

import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import classes.main;

public class CMD_Plot implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

//		if (cmd.getName().equalsIgnoreCase("aclaim")) {
//			if (args.length == 0) {
//				p.sendMessage("§5§l[]§3§l==========§5§l[Claim]§3§l==========§5§l[]");
//				p.sendMessage(main.prefix + "/claim delete <Spieler>");
//				p.sendMessage(main.prefix + "/claim admin on/off <spieler>");
//				p.sendMessage(main.prefix + "/claim spieler <spieler>");
//				p.sendMessage(main.prefix + "/claim build on/off");
//				p.sendMessage("§5§l[]§3§l==========§5§l[Claim]§3§l==========§5§l[]");
//			} else if (args[0].equalsIgnoreCase("delete")) {
//				if (args.length == 2) {
//					try {
//						OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
//						Plot_Methoden.cfg.set(player.getName(), null);
//						Plot_Methoden.cfg.save(Plot_Methoden.file);
//						p.sendMessage(main.prefix + "Du hast das Grundstück von " + player.getName() + " gelöscht!");
//					} catch (Exception d) {
//
//					}
//				}
//			} else {
//				
//			}
//		}
		if (cmd.getName().equalsIgnoreCase("claim")) {
			if (args.length == 0) {
				p.sendMessage("§5§l[]§3§l==========§5§l[Claim]§3§l==========§5§l[]");
				p.sendMessage(main.prefix + "/claim add <Spieler>");
				p.sendMessage(main.prefix + "/claim remove <Spieler>");
				p.sendMessage(main.prefix + "/claim rächte");
				p.sendMessage(main.prefix + "/claim Spieler");
				p.sendMessage(main.prefix + "/claim delete");
				p.sendMessage("§5§l[]§3§l==========§5§l[Claim]§3§l==========§5§l[]");
			} else if (args[0].equalsIgnoreCase("add")) {
				if (Plot_Methoden.cfg.getString(p.getName() + ".owner") != null) {
					if (args.length == 2) {
						Player d = (Player) Bukkit.getOfflinePlayer(args[1]);
						if (d != p) {
							if (Plot_Methoden.cfg.getStringList(p.getName() + ".Spieler").size() <= 1) {
								if (!Plot_Methoden.cfg.getStringList(p.getName() + ".Spieler").contains(d.getName())) {
									p.sendMessage(main.prefix + "Du hast den Spieler " + d.getName() + " hinzugefügt");
									List<String> list = Plot_Methoden.cfg.getStringList(p.getName() + ".Spieler");
									list.add(d.getName());
									Plot_Methoden.cfg.set(p.getName() + ".Spieler", list);
									try {
										Plot_Methoden.cfg.save(Plot_Methoden.file);
									} catch (IOException e) {
									}
									Plot_Methoden.resetPerms(p, d);
									p.sendMessage(main.prefix + "Damit der Spieler" + d.getName()
											+ " den du hinzugefügt hast was auf deinem Grundstück machen kann musst du zuerst die Rächte einstellen! -> /claim rächte");
								} else {
									p.sendMessage(
											main.prefix + "Dieser Spieler ist bereits auf deinem Plot hinzugefügt");
								}
							} else {
								p.sendMessage(main.prefix + "Du hast die Maximale Spieler anzahl erreicht!");
							}
						} else {
							p.sendMessage(main.prefix + "Du kannst dich nicht Selber removen!");
						}
					}
				} else {
					p.sendMessage(main.prefix + "Du musst ein Grundstück besitzen um dies zu machen!");
				}
			} else if (args[0].equalsIgnoreCase("remove")) {
				if (Plot_Methoden.cfg.getString(p.getName() + ".owner") != null) {
					if (args.length == 2) {
						try {
							Player d = (Player) Bukkit.getPlayer(args[1]);
							if (d != p) {
								if (Plot_Methoden.cfg.getStringList(p.getName() + ".Spieler").contains(d.getName())) {
									p.sendMessage(main.prefix + "Du hast den Spieler " + d.getName() + " entfernt");
									List<String> list = Plot_Methoden.cfg.getStringList(p.getName() + ".Spieler");
									list.remove(d.getName());
									Plot_Methoden.cfg.set(p.getName() + ".Spieler", list);
									Plot_Methoden.cfg.save(Plot_Methoden.file);
									Plot_Methoden.resetPerms(p, d);
								} else {
									p.sendMessage(main.prefix + "Du hast diesen Spieler bereits entfernt");
								}
							} else {
								p.sendMessage(main.prefix + "Du kannst dich nicht Selber removen!");
							}
						} catch (Exception e) {
							p.sendMessage(main.prefix + "Dieser Spieler ist nicht Online");
						}

					}
				} else {
					p.sendMessage(main.prefix + "Du musst ein Grundstück besitzen um dies zu machen!");
				}
			} else if (args[0].equalsIgnoreCase("delete")) {
				if (Plot_Methoden.cfg.getString(p.getName() + ".owner") != null) {
					if (args.length == 1) {
						p.sendMessage(main.prefix + "Dein Grundstück wurde entfernt");
						Plot_Methoden.cfg.set(p.getName(), null);
						Plot_Methoden.save();
					}
				} else {
					p.sendMessage(main.prefix + "Du musst ein Grundstück besitzen um dies zu machen!");
				}
			} else if (args[0].equalsIgnoreCase("rächte") || args[0].equalsIgnoreCase("permission")
					|| args[0].equalsIgnoreCase("permissions") || args[0].equalsIgnoreCase("perm")
					|| args[0].equalsIgnoreCase("perms")) {
				if (Plot_Methoden.cfg.getString(p.getName() + ".owner") != null) {

					try {

						Plot_Methoden.SpielerInv(p);

					} catch (Exception d) {
					}

				} else {
					p.sendMessage(main.prefix + "Du musst ein Grundstück besitzen um dies zu machen!");
				}

			} else if (args[0].equalsIgnoreCase("spieler")) {
				if (Plot_Methoden.cfg.getString(p.getName() + ".owner") != null) {

					try {

						Plot_Methoden.SpielerInv(p);

					} catch (Exception d) {
					}

				} else {
					p.sendMessage(main.prefix + "Du musst ein Grundstück besitzen um dies zu machen!");
				}

			}
		}
		return false;
	}

}
