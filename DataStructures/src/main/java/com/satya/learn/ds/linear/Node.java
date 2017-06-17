package com.satya.learn.ds.linear;

/**
 * The node to represent each unit of a data-structure.
 * 
 * @author Satyendra
 *
 * @param <E>
 *            type of data held by this node.
 */
public final class Node<E> {
	E data;
	Node<E> next;

	public Node(E e) {
		this.data = e;
	}
}
