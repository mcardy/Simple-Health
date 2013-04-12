package minny.simplehealth;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class SimpleHealth extends JavaPlugin {

	private final SimpleHealthPlayerListener playerListener = new SimpleHealthPlayerListener();
	
	@Override
	public void onDisable() {
	}
	@Override
	public void onEnable() {
		
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(playerListener, this);
		
		registerScoreboard();
	}
	
	public void registerScoreboard(){
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		board.registerNewObjective("simplehealth", "health");
	}

	
}
