package com.satya.learn.ds.hierarchical;

import java.util.function.Consumer;

/**
 * The guidelines for Binary Tree.
 * 
 * @author Satyendra
 * 
 * @param <E>
 *            type of data held by this tree.
 */
public interface Tree<E extends Comparable<E>> {

	public enum DFSTraversal {
		PRE, IN, POST;
	}

	public boolean insert(E data);

	public E delete(E data);

	public boolean isPresent(E data);

	public void actBFS(E data, Consumer<E> accept);

	public void actDFS(E data, Consumer<E> accept);

	public int countOfNodes();

	public int height();

	public int depth();

	public int heightOf(E data);

	public int depthOf(E data);

	public boolean isEmpty();

}
