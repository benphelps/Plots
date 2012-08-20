package me.benphelps.Plots.commands;

import java.lang.reflect.Array;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Java15Compat;

public class PlotsCommand implements CommandExecutor {

    private Plugin plots;
    private HashMap<String, CommandExecutor> commandMap = new HashMap<String, CommandExecutor>();
    
    public PlotsCommand(Plugin plots) {
        if (plots == null) throw new IllegalArgumentException("plugin cannot be null");
        this.plots = plots;
    }
    
    public void registerCommand(String command, CommandExecutor commandExecutor) {
        if (commandExecutor == null || command == null || command.isEmpty()) {
            throw new IllegalArgumentException("invalid command paramters specified");
        }
        this.commandMap.put(command.toLowerCase(), commandExecutor);
    }
    
    public void unregisterCommand(String command) {
        this.commandMap.remove(command.toLowerCase());
    }
    
    public CommandExecutor getCommandExecutor(String command) {
        return this.commandMap.get(command.toLowerCase());
    }
    
    public boolean hasCommand(String command) {
        return this.commandMap.containsKey(command.toLowerCase());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (args.length >= 1 && hasCommand(args[0])) {
                CommandExecutor executor = this.getCommandExecutor(args[0]);
                return executor.onCommand(sender, cmd, label, popArray(args));
            } else {
                sender.sendMessage(ChatColor.BLUE + "Plots version " + plots.getDescription().getVersion() + " by" + ChatColor.DARK_GREEN + " Ben Phelps");
                sender.sendMessage(ChatColor.BLUE + "Do " + ChatColor.WHITE + "/plots help " + ChatColor.BLUE + "to see help for the plugin.");
                return true;
            }
    }
   
    @SuppressWarnings("unchecked")
	private static final <T> T[] popArray(T[] args) {
        return (args.length >= 2) ? Java15Compat.Arrays_copyOfRange(args, 1, args.length) : 
            (T[]) Array.newInstance(args.getClass().getComponentType(), 0);
    }

}