package me.benphelps.Plots;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlotsBlockListener implements Listener {

	public Plots plots;
	
	//if ((max(x0,x1,x2) != x0 && min(x0,x1,x2) != x0) &&(max(y0,y1,y2) != y0 && min(y0,y1,y2) != x0)) {
	//}

	public PlotsBlockListener(Plots plots) {
		this.plots = plots;
	}
	
	private void checkPair(Player player){
		if(PlotsSelection.complete()){
			player.sendMessage(ChatColor.DARK_GREEN + "Selection complete!");
			PlotsSelection.clear();
			plots.creating = false;
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		if(player.getItemInHand().getTypeId() == Material.GOLD_AXE.getId() && plots.creating == true){
			Action action = event.getAction();
			//long point = PlotsPoint.point(block.getX(), block.getZ());
			if (action == Action.LEFT_CLICK_BLOCK) { 
				player.sendMessage(ChatColor.DARK_GREEN + "Point A set to: " + ChatColor.WHITE + "X " + block.getX() + ChatColor.DARK_GREEN + " - " + ChatColor.WHITE + " Z " + block.getZ());
				PlotsSelection.setA(block);
			}
			else if (action == Action.RIGHT_CLICK_BLOCK) {
				player.sendMessage(ChatColor.DARK_GREEN + "Point B set to: " + ChatColor.WHITE + "X " + block.getX() + ChatColor.DARK_GREEN + " - " + ChatColor.WHITE + " Z " + block.getZ());
				PlotsSelection.setB(block);
			}
			checkPair(player);
			event.setCancelled(true);
		}
	}
}