package com.satya.learn.ds.linear;

/**
 * The node to represent each unit of a linear data-structure.
 * 
 * @author Satyendra
 *
 * @param <E>
 *            type of data held by this node.
 */
public final class LinearNode<E> {
	E data;
	LinearNode<E> next;

	public LinearNode(E e) {
		this.data = e;
	}
}
