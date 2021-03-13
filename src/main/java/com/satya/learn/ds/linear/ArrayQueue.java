package com.satya.learn.ds.linear;

/**
 * Implementation of queue using an array.<br/>
 * Default size of queue is 10.<br/>
 * 
 * @author Satyendra
 *
 */
public class ArrayQueue<E> implements Queue<E> {

	private static final int DEFAULT_QUEUE_SIZE = 10;

	private Object[] elements;

	private int rearIndex = -1;

	private int frontIndex = -1;

	private int maxSize;

	private int size = 0;

	public ArrayQueue() {
		this(DEFAULT_QUEUE_SIZE);
	}

	public ArrayQueue(int initSize) {
		elements = new Object[initSize];
		maxSize = initSize;
	}

	@Override
	public boolean enQueue(E e) {
		if (isFull()) {
			return false;
		}
		if (rearIndex == maxSize - 1 && frontIndex > 0) {
			rearIndex = 0;
		} else {
			if (frontIndex == -1) {
				frontIndex++;
			}
			rearIndex++;
		}
		elements[rearIndex] = e;
		calSize();
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E deQueue() {
		if (isEmpty()) {
			return null;
		}
		E frontElement = (E) elements[frontIndex];
		elements[frontIndex] = null;
		if (frontIndex == rearIndex) {
			frontIndex = rearIndex = -1;
		} else if (frontIndex == maxSize - 1 && rearIndex >= 0) {
			frontIndex = 0;
		} else {
			frontIndex++;
		}
		calSize();
		return frontElement;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E frontPeek() {
		return (E) elements[frontIndex];
	}

	@Override
	@SuppressWarnings("unchecked")
	public E rearPeek() {
		return (E) elements[rearIndex];
	}

	private void calSize() {
		if (rearIndex == -1 && frontIndex == -1) {
			size = 0;
		} else {
			int absDiff = Math.abs(rearIndex - frontIndex) + 1;
			size = rearIndex >= frontIndex ? absDiff : maxSize - frontIndex + rearIndex + 1;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isFull() {
		return size == maxSize;
	}

	@Override
	public boolean isEmpty() {
		return size <= 0;
	}

	@Override
	public String toString() {
		StringBuilder queueStr = new StringBuilder("[ <front> ");
		int itr = 0;
		int index = frontIndex;
		while (itr++ < size) {
			queueStr.append("[" + index + "]").append(elements[index]).append(" ");
			if (index < maxSize - 1)
				index++;
			else
				index = 0;
		}
		queueStr.append("<rear> ]");
		return queueStr.toString();
	}

}
