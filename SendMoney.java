package de.kaktus.main.commands;

import de.kaktus.main.Main;
import de.kaktus.main.api.MoneyAPI;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendMoney implements CommandExecutor {
  public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
    if (!(s instanceof Player))
      return false; 
    Player p = (Player)s;
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
        if (moneyAPI.getMoney((OfflinePlayer)p).intValue() >= amount) {
          moneyAPI.removeMoney((OfflinePlayer)p, amount);
          moneyAPI.addMoney((OfflinePlayer)t, amount);
          p.sendMessage("Du hast " + t.getName() + "" + amount + "$ gegeben!");
          t.sendMessage(p.getName() + " hat dir " + amount + "$ gegeben!");
        } else {
          p.sendMessage("Du hast nicht genug Guthaben!");
        } 
      } else {
        p.sendMessage( "Spieler ist nicht online!");
      } 
    } else {
      p.sendMessage("nutze: /pay <Spieler> <Betrag>");
    } 
    return false;
  }
}
