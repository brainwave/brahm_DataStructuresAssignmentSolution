package com.bstconverter;

public class Main {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree(); // binary search tree
		int[] inputNodes = { 50, 30, 10, 60, 55 }; // given hardcoded list in question

		for (int i : inputNodes)
			tree.insert(i); // create a binary search tree using hardcoded input

		/*
		 * Convert tree to skewedBst (also displays values)
		 */

		BinarySearchTree skewedBst = tree.buildSkewedBst();

	}
}
