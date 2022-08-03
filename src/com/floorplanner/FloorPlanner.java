package com.floorplanner;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class FloorPlanner {
	/*
	 * -----------------------------------------------------------------------------
	 * ALGORITHM OF THE PROGRAM
	 * -----------------------------------------------------------------------------
	 * 1. One function to get and store the number of total floors, as well as the
	 * floor sizes. inputs 1 by 1 into a stack (floor size for each day)
	 * 
	 * After obtaining the inputs, copy the array and sort the copy in descending
	 * order.
	 * 
	 * Have two counters, i and j for keeping index in the two arrays respectively.
	 * 
	 * Increment i from 0 till
	 * 
	 */
	public Integer numFloors;
	public Integer[] floorSizes;

	/*
	 * 
	 */
	public void getFloorSizes() {
		Scanner sc = new Scanner(System.in);

		System.out.println("enter the total no of floors in the building");
		numFloors = sc.nextInt();

		floorSizes = new Integer[numFloors];

		for (int i = 0; i < numFloors; ++i) {
			System.out.println("enter the floor size given on day : " + (i + 1));
			floorSizes[i] = sc.nextInt();
		}

		sc.close();
	}

	public void printConstructionOrder() {

		System.out.println("The order of construction is as follows");

		// sort the array in reverse order, largest to smallest
		Integer[] floorSizesSorted = this.floorSizes.clone();
		Arrays.sort(floorSizesSorted, Collections.reverseOrder());

		Stack<Integer> assembledFloorStack = new Stack<Integer>(); // use stack for storing integers parsed from the
																	// input array

		int j = 0; // index to keep track of position in sorted array

		for (int i = 0; i < this.numFloors; ++i) { // loop from 0 till numFloors, i to keep track of the index

			if (this.floorSizes[i] == floorSizesSorted[j]) { // whenever the index matches the largest element
																// (currently at j)

				j = (i == this.numFloors - 1) ? i : (i + 1); //

				System.out.println("Day: " + (i + 1));

				if (assembledFloorStack != null) {
					System.out.print(this.floorSizes[i] + " ");
					while (!assembledFloorStack.isEmpty()) {
						int val = assembledFloorStack.pop(); // last element in the stack.
						if (val >= floorSizesSorted[j]) { // if the last element in the stack is > next consecutive
															// element in the sorted array
							System.out.print(val + " "); // print it
						} else {
							assembledFloorStack.push(val);
							j -= assembledFloorStack.size();
							break;
						}
					}
					System.out.println("");
				} else {
					System.out.println(this.floorSizes[i]);
				}
			} else {
				System.out.println("Day: " + (i + 1));
				assembledFloorStack.push(this.floorSizes[i]);
			}
		}
	}
}
