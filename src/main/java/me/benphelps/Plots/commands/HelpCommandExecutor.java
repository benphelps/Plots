package me.benphelps.Plots.commands;

import me.benphelps.Plots.Plots;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommandExecutor implements CommandExecutor {

	private Plots plots;

	public HelpCommandExecutor(Plots plots) {
		this.plots = plots;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player == false) {
			sender.sendMessage("You must be a player!");
			return false;
		}
		
		if (!sender.hasPermission("Plots.manage")) {
		    sender.sendMessage(ChatColor.RED + "No commands available.");
        } else {
            if (sender.hasPermission("Plots.manage.new")) {
                sender.sendMessage(ChatColor.WHITE + "/plots new:" + ChatColor.BLUE + " Enter plot creation mode.");
            }
        }
		
		return true;
	}

}
