package me.benphelps.Plots;

import org.bukkit.plugin.java.JavaPlugin;

public class Plots extends JavaPlugin {
	
	public boolean creating;

	public void onEnable(){
		getServer().getPluginManager().registerEvents(new PlotsBlockListener(this), this);
		getCommand("plots").setExecutor(new PlotsCommandExecutor(this));
		getLogger().info("Plots has been enabled!");
	}
 
	public void onDisable(){
		getLogger().info("Plots has been disabled.");
	}
	
}