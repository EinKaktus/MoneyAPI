package de.kaktus.main.events;

import de.kaktus.main.api.MoneyAPI;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Join implements Listener {
  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
    Player p = e.getPlayer();
    MoneyAPI moneyAPI = new MoneyAPI();
    if (!p.hasPlayedBefore()) {
      moneyAPI.addMoney((OfflinePlayer)p, 500);
    } else {
      e.setJoinMessage(null);
    } 
  }
}
