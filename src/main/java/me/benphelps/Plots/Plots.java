package me.benphelps.Plots;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import me.benphelps.Plots.commands.*;

public class Plots extends JavaPlugin {
	
	public boolean creating;

	public void onEnable(){

		final CommandExecutor HelpCommandExecutor = new HelpCommandExecutor(this);
		final NewCommandExecutor NewCommandExecutor = new NewCommandExecutor(this);
		
		final PlotsCommand plotsCommand = new PlotsCommand(this);
		
		getCommand("plotsHelp").setExecutor(HelpCommandExecutor);
		getCommand("plotsNew").setExecutor(NewCommandExecutor);
		
		plotsCommand.registerCommand("plotsHelp", HelpCommandExecutor);
		plotsCommand.registerCommand("plotsNew", NewCommandExecutor);
		
		plotsCommand.registerCommand("help", HelpCommandExecutor);
		plotsCommand.registerCommand("new", NewCommandExecutor);
		
		this.getCommand("plots").setExecutor(plotsCommand);
		
		getServer().getPluginManager().registerEvents(new PlotsBlockListener(this), this);
		
		getLogger().info("Plots has been enabled!");
	}
 
	public void onDisable(){
		getLogger().info("Plots has been disabled.");
	}
	
}