/**
 * 
 */
package com.floorplanner;

public class Main {

	public static int totalFloors;
	public static int[] totalFloorSize;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FloorPlanner fp = new FloorPlanner();
		fp.getFloorSizes(); // Show all floor sizes
		fp.printConstructionOrder(); // Show order of construction
	}

}