package com.bstconverter;

/**
 * Templatized node declaration
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
