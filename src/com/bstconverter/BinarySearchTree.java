package com.bstconverter;

import java.util.Stack;

public class BinarySearchTree {
	Node<Integer> root;

	// insertion without recursion (loop approach)
	public void insert(int key) {
		Node<Integer> node = new Node<Integer>(key);

		if (root == null) {
			root = node;
			return;
		}

		Node<Integer> prev = null;
		Node<Integer> temp = root;

		while (temp != null) {
			if (temp.val > key) {
				prev = temp;
				temp = temp.left;
			} else if (temp.val < key) {
				prev = temp;
				temp = temp.right;
			}
		}

		if (prev.val > key)
			prev.left = node;
		else
			prev.right = node;
	}

	public BinarySearchTree buildSkewedBst() {
		BinarySearchTree skewedBst = new BinarySearchTree();

		Node<Integer> temp = root;
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		while (temp != null || !stack.isEmpty()) {
			if (temp != null) {
				stack.add(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				skewedBst.insert(temp.val);
				System.out.print(temp.val + " ");
				temp = temp.right;
			}
		}
		System.out.println();
		return skewedBst;
	}

	public void inorder() {
		Node<Integer> temp = root;
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		while (temp != null || !stack.isEmpty()) {
			if (temp != null) {
				stack.add(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				System.out.print(temp.val + " ");
				temp = temp.right;
			}
		}
		System.out.println();
	}
}
