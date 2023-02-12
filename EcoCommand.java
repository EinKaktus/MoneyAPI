package de.kaktus.main.commands;

import de.kaktus.main.Main;
import de.kaktus.main.api.MoneyAPI;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcoCommand implements CommandExecutor {
  public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
    if (!(s instanceof Player))
      return false; 
    Player p = (Player)s;
    if (p.hasPermission("system.eco")) {
      if (args.length == 2) {
        Player t = Bukkit.getPlayer(args[0]);
        MoneyAPI moneyAPI = new MoneyAPI();
        if (t != null) {
          int amount;
          try {
            amount = Integer.parseInt(args[1]);
          } catch (NumberFormatException e) {
            p.sendMessage(Main.pre + "Zahl!");
            return true;
          } 
          moneyAPI.addMoney((OfflinePlayer)t, amount);
          p.sendMessage(Main.pre + "wurden + Main.pre + "geinem Konto );
        } else {
          p.sendMessage(Main.pre + "Spieler ist );
        } 
      } else {
        p.sendMessage(Main.pre + "nutze: <give/remove> <Spieler> <Betrag>");
      } 
    } else {
      p.sendMessage(Main.pre + "hast du );
    } 
    return false;
  }
}
