package classes.Advent;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class config {
	
	public static File adventsFile = new File("plugins//RealLife//Advent.yml");
	public static FileConfiguration yaml = YamlConfiguration.loadConfiguration(adventsFile);
	
}
