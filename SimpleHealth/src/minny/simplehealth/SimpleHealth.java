package minny.simplehealth;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class SimpleHealth extends JavaPlugin {

	private final SimpleHealthPlayerListener playerListener = new SimpleHealthPlayerListener();
	
	@Override
	public void onDisable() {
	}
	@Override
	public void onEnable() {
		
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(playerListener, this);
		
	}
	
}
