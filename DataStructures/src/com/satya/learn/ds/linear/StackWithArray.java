package com.satya.learn.ds.linear;

/**
 * Implementation of stack using an array.
 * 
 * @author Satyendra
 *
 */
public class StackWithArray<E> implements Stack<E> {

	private static final int DEFAULT_STACK_SIZE = 10;
	private int maxStackSize;

	private final Object[] elements;

	private int topIndex = -1;

	public StackWithArray() {
		this(DEFAULT_STACK_SIZE);
	}

	public StackWithArray(int maxSize) {
		elements = new Object[maxSize];
		this.maxStackSize = maxSize;
	}

	@Override
	public boolean push(E e) {
		boolean isPushed = false;
		if (isPushed = validateStackSize()) {
			elements[++topIndex] = e;
		}
		return isPushed;
	}

	private boolean validateStackSize() {
		return topIndex + 1 < maxStackSize;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		elements[topIndex--] = null;
		return (E) elements[topIndex];
	}

	@Override
	@SuppressWarnings("unchecked")
	public E peek() {
		return (E) elements[topIndex];
	}

	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}

	@Override
	public int size() {
		return topIndex + 1;
	}

	@Override
	public String toString() {
		StringBuilder strArrayList = new StringBuilder("[ ");
		for (int i = 0; i <= topIndex; i++) {
			strArrayList.append("[" + i + "]").append(elements[i]).append(" ");
		}
		strArrayList.append("]");
		return strArrayList.toString();
	}

}
