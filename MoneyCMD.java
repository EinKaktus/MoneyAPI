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
      s.sendMessage("Du musst ein Spieler sein!");
      return false;
    } 
    MoneyAPI moneyAPI = new MoneyAPI();
    Player p = (Player)s;
    if (args.length == 0) {
      int money = moneyAPI.getMoney((OfflinePlayer)p).intValue();
      p.sendMessage("Du hast " + amount + "$ auf deinem Konto");
    } else if (args.length == 1) {
      OfflinePlayer t = Bukkit.getOfflinePlayer(args[0]);
      if (t.hasPlayedBefore()) {
        p.sendMessage("Der Spieler " + p.getName() + " hat " + amount + "$ auf seinem Konto!");
      } else {
        p.sendMessage(+ "Spieler ist uns nicht bekannt!");
      } 
    } else {
      p.sendMessage("nutze: /money <Spieler>");
    } 
    return false;
  }
}
