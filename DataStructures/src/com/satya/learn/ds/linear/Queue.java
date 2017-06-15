package com.satya.learn.ds.linear;

/**
 * A contract for queue.
 * 
 * @author Satyendra
 *
 * @param <E>
 *            type of elements of the queue.
 */
public interface Queue<E> {

	boolean enQueue(E e);

	E deQueue();
	
	E front();
	
	E rear();
	
	int size();
	
	boolean isEmpty();

}
