package com.floorplanner;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

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

		MaxHeap maxheap = new MaxHeap(this.numFloors); // create max heap to store the floors

		int j = 0; // index to keep track of position in sorted array

		for (int i = 0; i < this.numFloors; ++i) { // loop from 0 till numFloors, i to keep track of the index

			System.out.println("Day: " + (i + 1));

			if (this.floorSizes[i] == floorSizesSorted[j]) { // Check if the current element in unsorted stack equals
																// the largest element in the sorted stack

				System.out.printf(floorSizes[i] + " "); // print current floor number
				j++; // go to next largest item in the sorted list

				while (maxheap.getSize() > 0) {
					if (maxheap.viewMax() < floorSizesSorted[j]) // if the maximum of current heap is lower than the
																	// next max element in sorted array, do nothing
						break;
					else {
						System.out.printf(maxheap.extractMax() + " "); // the next element in stack is same as the next
																		// //
																		// largest array in sorted array
						j = (j < numFloors - 1) ? (j + 1) : (j); // increment max heap
					}
				}

				System.out.println();
			} else
				maxheap.insert(this.floorSizes[i]);
		}
	}
}
