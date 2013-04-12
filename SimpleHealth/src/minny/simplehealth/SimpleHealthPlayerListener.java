package minny.simplehealth;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class SimpleHealthPlayerListener implements Listener {

	@EventHandler
	public void onPunch(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player target = (Player) e.getEntity();
			if (!target.hasPermission("simplehealth.hidehealth")) {
				ScoreboardManager manager = Bukkit.getScoreboardManager();
				Scoreboard board = manager.getNewScoreboard();
				target.setScoreboard(board);
			}

		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		if (!e.getPlayer().hasPermission("simplehealth.hidehealth")){
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			Scoreboard board = manager.getNewScoreboard();

			Objective objective = board.getObjective("simplehealth");
			objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
			objective.setDisplayName("/ 20");
			e.getPlayer().setScoreboard(board);
		}
	}

}
