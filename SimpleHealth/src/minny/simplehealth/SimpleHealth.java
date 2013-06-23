package minny.simplehealth;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
public class SimpleHealth extends JavaPlugin implements Listener{
	Scoreboard board;
	@Override
	public void onEnable() {
		board = Bukkit.getScoreboardManager().getNewScoreboard();
		board.registerNewObjective("showhealth", "health");
		Objective objective = board.getObjective("showhealth");
		objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
		objective.setDisplayName(" ♥");
		getServer().getPluginManager().registerEvents(this, this);
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (!p.hasPermission("simplehealth.hidehealth")) {
				p.setScoreboard(board);
				p.setHealth(p.getHealth());
			}
		}
	}
}
