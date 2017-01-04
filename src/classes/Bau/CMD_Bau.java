package classes.Bau;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import classes.main;

public class CMD_Bau implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (Bau_Listener.bauen.contains(p.getName())) {
			Bau_Listener.bauen.remove(p.getName());
			p.sendMessage(main.prefix + "Du kannst nun nicht mehr bauen");
		} else {
			Bau_Listener.bauen.add(p.getName());
			p.sendMessage(main.prefix + "Du kannst nun bauen");
		}
//		Shematic.Shematics("Test", p.getLocation().getBlockX(), p.getLocation().getBlockZ(), p.getLocation().getBlockY(), p.getWorld().getName());
		
		
		return false;
	}

}
