package com.satya.learn.ds.linear;

/**
 * Implementation of stack using a linked-list.
 * 
 * @author Satyendra
 *
 */
public class StackWithLinkedList<E> implements Stack<E> {

	private Node<E> top;

	private int size = 0;

	@Override
	public boolean push(E e) {
		Node<E> newNode = new Node<>(e);
		if (top != null) {
			newNode.next = top;
		}
		top = newNode;
		size++;
		return true;
	}

	@Override
	public E pop() {
		E elementPopped = null;
		if (top != null) {
			Node<E> temp = top;
			elementPopped = top.data;
			top = top.next;
			temp.next = null;
			temp = null;
		}
		return elementPopped;
	}

	@Override
	public E peek() {
		return top != null ? top.data : null;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder strArrayList = new StringBuilder("[ ");
		Node<E> temp = top;
		int i = 0;
		while (temp != null && temp.next != null) {
			strArrayList.append("[" + i++ + "]").append(temp.data).append(" ");
			temp = temp.next;
		}
		strArrayList.append("]");
		return strArrayList.toString();
	}

}
