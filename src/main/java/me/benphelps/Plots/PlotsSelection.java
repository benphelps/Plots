package me.benphelps.Plots;

import org.bukkit.block.Block;

public class PlotsSelection {
	
	private static Block tmp_a;
	private static Block tmp_b;
	
	public static void setA(Block tmp_a) {
		PlotsSelection.tmp_a = tmp_a;
	}

	public static void setB(Block temp_b) {
		PlotsSelection.tmp_b = temp_b;
	}
	
	public static boolean complete(){
		if(tmp_a != null && tmp_b != null) {
			return true;
		}
		return false;
	}
	
	public static Block getA(){
		return tmp_a;
	}
	
	public static Block getB(){
		return tmp_b;
	}

	public static void clear() {
		tmp_a = null;
		tmp_b = null;
	}

}
