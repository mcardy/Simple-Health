package minny.simplehealth;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class SimpleHealthPlayerListener implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		board.registerNewObjective("showhealth", "health");

		Objective objective = board.getObjective("showhealth");
		objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
		objective.setDisplayName("/ 20");

		for (Player online : Bukkit.getOnlinePlayers()) {
			if (!online.hasPermission("simplehealth.hidehealth")) {
				if (!online.hasPlayedBefore()){
					online.setHealth(20);
				}
				online.setScoreboard(board);
			}
		}
	}

}
