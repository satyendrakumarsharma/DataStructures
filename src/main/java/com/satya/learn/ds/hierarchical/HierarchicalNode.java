package com.satya.learn.ds.hierarchical;

/**
 * A node implementation to represent as unit for any hierarchical structure.
 * 
 * @author Satyendra
 * 
 * @param <E>
 *            type of data held by this node.
 */
public class HierarchicalNode<E> {
	E data;
	HierarchicalNode<E> left;
	HierarchicalNode<E> right;

	public HierarchicalNode(E data) {
		this(data, null, null);
	}

	public HierarchicalNode(E data, HierarchicalNode<E> left, HierarchicalNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		String leftNode = (left != null && left.data != null) ? left.data.toString() : "NULL";
		String rightNode = (right != null && right.data != null) ? right.data.toString() : "NULL";
		return "[" + leftNode + "] <--- [" + data.toString() + "] ---> [" + rightNode + "]";
	}
}
