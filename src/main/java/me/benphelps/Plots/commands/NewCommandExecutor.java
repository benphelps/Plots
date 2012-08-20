package me.benphelps.Plots.commands;

import me.benphelps.Plots.Plots;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NewCommandExecutor implements CommandExecutor {

	private Plots plots;

	public NewCommandExecutor(Plots plots) {
		this.plots = plots;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player == false) {
			sender.sendMessage("You must be a player!");
			return false;
		}
		
		if (!sender.hasPermission("Plots.manage.new")) {
		    sender.sendMessage(ChatColor.RED + "Command unavailable.");
        } else {
        	sender.sendMessage(ChatColor.DARK_GREEN + "You are now creating a new plot.");
            plots.creating = true;
        }
		
		return true;
	}

}
