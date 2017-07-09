package com.satya.learn.ds.hierarchical;

import java.util.function.Consumer;

/**
 * Binary Search Tree implementation.
 * 
 * @author Satyendra
 * 
 * @param <E>
 *            type of data held by this tree.
 */
public class BinarySearchTree<E extends Comparable<E>> implements Tree<E> {

	private HierarchicalNode<E> root;

	private int height = -1;

	private int count = 0;

	public BinarySearchTree() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.satya.learn.ds.hierarchical.Tree#insert(java.lang.Object)
	 */
	@Override
	public boolean insert(E data) {
		HierarchicalNode<E> node = new HierarchicalNode<>(data);
		if (root == null) {
			root = node;
		} else {
			insertNode(root, node);
		}
		count++;
		height();
		return true;
	}

	private HierarchicalNode<E> insertNode(HierarchicalNode<E> currentNode, HierarchicalNode<E> newNode) {
		if (currentNode == null) {
			return newNode;
		} else if (newNode.data.compareTo(currentNode.data) <= 0) {
			currentNode.left = insertNode(currentNode.left, newNode);
		} else {
			currentNode.right = insertNode(currentNode.right, newNode);
		}
		return currentNode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.satya.learn.ds.hierarchical.Tree#delete(java.lang.Object)
	 */
	@Override
	public E delete(E data) {
		HierarchicalNode<E> node = getNodeOf(data);
		deleteNode(node);
		return data;
	}

	private void deleteNode(HierarchicalNode<E> node) {
		HierarchicalNode<E> parent = getParentOf(node);
		if (node.left == null && node.right == null) {
			// ZERO child
			if (parent.left.data.equals(node.data)) {
				parent.left = null; // node is left-child of parent
			} else if (parent.right.data.equals(node.data)) {
				parent.right = null; // node is right-child of parent
			}
		} else if (node.left == null) {
			// ONE child at right
			if (parent.left.data.equals(node.data)) {
				parent.left = node.right; // node is left-child of parent
			} else if (parent.right.data.equals(node.data)) {
				parent.right = node.right; // node is right-child of parent
			}
		} else if (node.right == null) {
			// ONE child at left
			if (parent.left.data.equals(node.data)) {
				parent.left = node.left; // node is left-child of parent
			} else if (parent.right.data.equals(node.data)) {
				parent.right = node.left; // node is right-child of parent
			}
		} else {
			// TWO children
			// get minimum data from right sub-tree.
			HierarchicalNode<E> minAtRight = getMinNode(node);
			// remove the node with minimum data (as it is repeated now).
			deleteNode(minAtRight);
			// replace the current node with minimum data from right sub-tree.
			node.data = minAtRight.data;
		}
	}

	private HierarchicalNode<E> getParentOf(HierarchicalNode<E> node) {
		HierarchicalNode<E> parent = null;
		if (node == null || node.equals(root)) {
			// root node has no parent
			parent = null;
		} else {
			HierarchicalNode<E> currentNode = root;
			while (currentNode != null) {
				// choose the sub-tree to process
				if (node.data.compareTo(currentNode.data) < 0) {
					// Left sub-tree.
					if (currentNode.left.data.equals(node.data)) {
						parent = currentNode;
						break;
					} else {
						currentNode = currentNode.left;
					}
				} else if (node.data.compareTo(currentNode.data) > 0) {
					// Right sub-tree.
					if (currentNode.right.data.equals(node.data)) {
						parent = currentNode;
						break;
					} else {
						currentNode = currentNode.right;
					}
				}
			}
		}
		return parent;
	}

	/**
	 * This is a utility method to provide the node with minimum data in given
	 * sub-tree.
	 * 
	 * @param node
	 *            the root-node of sub-tree.
	 * @return node with minimum data.
	 */
	private HierarchicalNode<E> getMinNode(HierarchicalNode<E> node) {
		HierarchicalNode<E> minNode = node;
		if (minNode != null) {
			while (minNode.left != null) {
				minNode = minNode.left;
			}
		}
		return minNode;
	}

	/**
	 * This is a utility method to provide the node with maximum data in given
	 * sub-tree.
	 * 
	 * @param node
	 *            the root-node of sub-tree.
	 * @return node with maximum data.
	 */
	@SuppressWarnings("unused")
	private HierarchicalNode<E> getMaxNode(HierarchicalNode<E> node) {
		HierarchicalNode<E> maxNode = node;
		if (maxNode != null) {
			while (maxNode.right != null) {
				maxNode = maxNode.right;
			}
		}
		return maxNode;
	}

	/**
	 * This method returns the node in this tree which holds the given data.
	 * 
	 * @param data
	 *            the data to be looked for.
	 * @return the <code>HierarchicalNode</code> for given data,
	 *         <code>null</code> if the data is not present in tree.
	 */
	private HierarchicalNode<E> getNodeOf(E data) {
		HierarchicalNode<E> currentNode = root;
		if (currentNode != null) {
			while (!currentNode.data.equals(data)) {
				if (data.compareTo(currentNode.data) < 0) {
					currentNode = currentNode.left;
				} else {
					currentNode = currentNode.right;
				}
			}
		}
		return currentNode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.satya.learn.ds.hierarchical.Tree#isPresent(java.lang.Object)
	 */
	@Override
	public boolean isPresent(E data) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.satya.learn.ds.hierarchical.Tree#actBFS(java.lang.Object,
	 * java.util.function.Consumer)
	 */
	@Override
	public void actBFS(E data, Consumer<E> accept) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.satya.learn.ds.hierarchical.Tree#actDFS(java.lang.Object,
	 * java.util.function.Consumer)
	 */
	@Override
	public void actDFS(E data, Consumer<E> accept) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.satya.learn.ds.hierarchical.Tree#height()
	 */
	@Override
	public int height() {
		height = heightOf(root);
		return height;
	}

	private int heightOf(HierarchicalNode<E> node) {
		int nodeHeight;
		if (node == null) {
			nodeHeight = -1;
		} else if (node.left == null && node.right == null) {
			nodeHeight = 0;
		} else {
			int heightLeft = heightOf(node.left);
			int heightRight = heightOf(node.right);
			nodeHeight = Math.max(heightLeft, heightRight) + 1;
		}
		return nodeHeight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.satya.learn.ds.hierarchical.Tree#depth()
	 */
	@Override
	public int depth() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.satya.learn.ds.hierarchical.Tree#heightOf(java.lang.Object)
	 */
	@Override
	public int heightOf(E data) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.satya.learn.ds.hierarchical.Tree#depthOf(java.lang.Object)
	 */
	@Override
	public int depthOf(E data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countOfNodes() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
