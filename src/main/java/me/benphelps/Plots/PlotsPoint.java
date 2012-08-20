package me.benphelps.Plots;

/*
 * http://www.tomgibara.com/java/fast-coordinates
 */

public class PlotsPoint {
	final int x;
	final int y;
	PlotsPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}     
	public static long point(int x, int y) {
		return (((long)x) << 32) | y;
	}
	public static int x(long point) {
		return (int)(point >> 32);
	}
	public static int y(long point) {
		return (int) point;
	}
}