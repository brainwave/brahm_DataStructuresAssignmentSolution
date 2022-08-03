package com.bstconverter;

/**
 * Templatized node class to create nodes out of any data type (made to help the
 * implementation of the program)
 * 
 * @author brainwave
 *
 * @param <T>
 */

public class Node<T> {

	Node<T> left;
	T val;
	Node<T> right;

	public Node(T val) {
		this.val = val;
	}
}
