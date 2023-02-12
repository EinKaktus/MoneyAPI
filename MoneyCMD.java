package de.kaktus.main.commands;

import de.kaktus.main.Main;
import de.kaktus.main.api.MoneyAPI;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoneyCMD implements CommandExecutor {
  public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
    if (!(s instanceof Player)) {
      s.sendMessage("musst ein Spieler sein!");
      return false;
    } 
    MoneyAPI moneyAPI = new MoneyAPI();
    Player p = (Player)s;
    if (args.length == 0) {
      int money = moneyAPI.getMoney((OfflinePlayer)p).intValue();
      p.sendMessage(Main.pre + "hast + Main.pre + "deinem Konto!");
    } else if (args.length == 1) {
      OfflinePlayer t = Bukkit.getOfflinePlayer(args[0]);
      if (t.hasPlayedBefore()) {
        p.sendMessage(Main.pre + "Spieler + Main.pre + "hat + t.getName() + "seinem Konto!");
      } else {
        p.sendMessage(Main.pre + "Spieler ist uns nicht bekannt!");
      } 
    } else {
      p.sendMessage(Main.pre + "nutze: <Spieler>");
    } 
    return false;
  }
}