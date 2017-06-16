package com.satya.learn.ds.linear;

import java.util.Arrays;

/**
 * Implementation of dynamically growing list using array.
 * 
 * @author Satyendra
 *
 */
public class ArrayList<E> implements List<E> {

	private static final int DEFAULT_SIZE = 10;

	private static final Object[] DEFAULT_EMPTY_ARRAY = {};

	private Object[] elements;

	private int size = 0;

	public ArrayList() {
		elements = new Object[DEFAULT_SIZE];
	}

	public ArrayList(int initSize) {
		if (initSize > 0) {
			elements = new Object[initSize];
		} else if (initSize == 0) {
			elements = DEFAULT_EMPTY_ARRAY;
		} else {
			throw new IllegalArgumentException("Invalid capacity : " + initSize);
		}
	}

	@Override
	public void add(E e) {
		int newSize = size + 1;
		if (newSize - elements.length > 0) {
			expand(newSize);
		}
		elements[size++] = e;
	}

	private void expand(int newLength) {
		elements = Arrays.copyOf(elements, newLength);
	}

	@Override
	public E remove(E e) {
		return null;
	}

	@Override
	public E remove(int index) {
		validateIndexRange(index);
		E removedElement = elementAt(index);
		int positionsToMove = size - index - 1;
		if (positionsToMove > 0) {
			System.arraycopy(elements, index + 1, elements, index, positionsToMove);
		}
		elements[--size] = null;
		return removedElement;
	}

	@Override
	public E get(int index) {
		validateIndexRange(index);
		return elementAt(index);
	}

	@Override
	@SuppressWarnings("unchecked")
	public int indexOf(E e) {
		if (e == null) {
			for (int i = 0; i < elements.length; i++) {
				E element = (E) elements[i];
				if (element == e) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < elements.length; i++) {
				E element = (E) elements[i];
				if (element.equals(e)) {
					return i;
				}
			}
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	private E elementAt(int index) {
		return (E) elements[index];
	}

	private void validateIndexRange(int index) {
		if (index > size || index < 0) {
			throw new ArrayIndexOutOfBoundsException("Size : " + size + " Index : " + index);
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder strArrayList = new StringBuilder("[ ");
		int i = 0;
		for (Object e : elements) {
			strArrayList.append("[" + i++ + "]").append(e).append(" ");
		}
		strArrayList.append("]");
		return strArrayList.toString();
	}

}
