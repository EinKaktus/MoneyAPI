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
            p.sendMessage(Main.pre + "Ungültige Eingabe!");
            return true;
          } 
          moneyAPI.addMoney((OfflinePlayer)t, amount);
          p.sendMessage(Main.pre + amount + "$ wurden deinem Konto hinzugefügt!");
        } else {
          p.sendMessage(Main.pre + "Spieler ist offline!");
        } 
      } else {
        p.sendMessage(Main.pre + "nutze: <give/remove> <Spieler> <Betrag>");
      } 
    } else {
      p.sendMessage(Main.pre + "Dazu hast du keine Rechte!");
    } 
    return false;
  }
}
