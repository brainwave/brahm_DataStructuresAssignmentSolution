package com.bstconverter;

public class Main {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		int[] inputNodes = { 50, 30, 10, 60, 55 };

		for (int i : inputNodes)
			tree.insert(i);

		/*
		 * Show the inorder traversal of binary tree to ensure we have created a binary
		 * search tree
		 */
		BinarySearchTree skewedBst = tree.buildSkewedBst();

	}
}
