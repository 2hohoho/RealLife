package classes.Chat;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

public class Chat_Methoden {

	public static File file = new File("plugins//RealLife//chat.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	public static void createrang() {

		List<String> spieler = cfg.getStringList(".Spieler");
		List<String> supporter = cfg.getStringList(".Supporter");
		List<String> Moderator = cfg.getStringList(".Moderator");
		List<String> Builder = cfg.getStringList(".Builder");
		List<String> Developer = cfg.getStringList(".Developer");
		List<String> Admin = cfg.getStringList(".Admin");
		List<String> Owner = cfg.getStringList(".Owner");

		cfg.set(".Spieler", spieler);
		cfg.set(".Supporter", supporter);
		cfg.set(".Moderator", Moderator);
		cfg.set(".Builder", Builder);
		cfg.set(".Developer", Developer);
		cfg.set(".Admin", Admin);
		cfg.set(".Owner", Owner);
		
		save();

	}

	public static void save() {
		try {
			cfg.save(file);
		} catch (IOException e) {
		}
	}

}
