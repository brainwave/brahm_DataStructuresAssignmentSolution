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
	 * Build a max-heap
	 * 
	 * Increment i from 0 till numFloor - 1 If the element in unsorted array at i
	 * matches the sorted array at j, print. Increment j to be the next maximum
	 * element in the sorted array.
	 * 
	 * If the element at i does not match j, push the element into the maxHeap. This
	 * ensures we always have a sorting in the floors inserted into the max heap.
	 * 
	 * For every time that we have a floor i matching the floor j in unsorted and
	 * sorted heaps respectively, check and empty the maxHeap until the next element
	 * in maxHeap is smaller than the next expected largest element j in sorted
	 * array. increment j each time that we remove an element from the max heap.
	 * 
	 */
	public Integer numFloors;
	public Integer[] floorSizes;

	/*
	 * Helper function to get all floor sizes
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

	/*
	 * Function to print the order of construction
	 */

	public void printConstructionOrder() {

		System.out.println("The order of construction is as follows");

		// sort the array in reverse order, largest to smallest
		Integer[] floorSizesSorted = this.floorSizes.clone();
		Arrays.sort(floorSizesSorted, Collections.reverseOrder());

		MaxHeap maxheap = new MaxHeap(this.numFloors); // create max heap to store the floors

		int j = 0; // index to keep track of position in sorted array

		for (int i = 0; i < this.numFloors; ++i) { // loop from 0 till numFloors, i to keep track of the index

			System.out.println("Day: " + (i + 1));

			if (this.floorSizes[i] == floorSizesSorted[j]) { // Check if the current element in unsorted array equals
																// the largest element in the sorted array

				System.out.printf(floorSizes[i] + " "); // print floor when the sorted and unsorted indices match
				j++; // go to next largest item in the sorted list

				while (maxheap.getSize() > 0) {
					if (maxheap.viewMax() < floorSizesSorted[j]) // if the maximum of current heap is lower than the
																	// next max element in sorted array, break the while
																	// loop. No point checking for other elements in the
																	// heap
						break;
					else {
						System.out.printf(maxheap.extractMax() + " "); // Else (meaning max heap's root is equal to next
																		// expected element from sorted array list)
																		// remove it from heap after printing
						j = (j < numFloors - 1) ? (j + 1) : (j); // increment the index j to reflect next expected
																	// element in sorted heap.
					}
				}

				System.out.println(); // newline character to match output with expected output in question.
			} else
				maxheap.insert(this.floorSizes[i]); // in case the element at i in unsroted array is not the element j
													// in sorted array, insert into max heap
		}
	}
}
