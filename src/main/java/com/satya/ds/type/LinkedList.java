package com.satya.ds.type;

/**
 * This is an implementation of Linked List.
 * 
 * @author Satyendra Kumar Sharma
 *
 */
public class LinkedList<T> {

	protected Node<T> head = null;
	protected Node<T> tail = null;

	public static class Node<E> {
		public E value = null;
		public Node<E> next = null;

		@SuppressWarnings("unused")
		private Node() {
			// not to be used
		}

		public Node(E value) {
			this.value = value;
		}
	}

	/**
	 * This method inserts the given new node at end of linked list.
	 * 
	 * @param value
	 *            the node to be inserted.
	 * @return newly inserted node.
	 */
	public Node<T> add(T value) {
		Node<T> node = new Node<>(value);
		if (head == null) {
			setNullHead(node);
		} else {
			tail.next = node;
			tail = node;
		}
		return node;
	}

	/**
	 * This method inserts the node next to given position of Linked List.
	 * 
	 * @param e
	 *            the position next to which element is to be inserted.
	 * @param value
	 *            the noted to be inserted.
	 * @return newly inserted node.
	 */
	public Node<T> addAt(Node<T> e, T value) {
		if (head != null && e == null) {
			throw new NullPointerException("The position of insertion shall not be null.");
		}
		Node<T> node = new Node<>(value);
		if (head == null) {
			setNullHead(node);
		} else {
			node.next = e.next;
			e.next = node;
		}
		return node;
	}

	/**
	 * This method inserts the given node as first element of Linked List.
	 * 
	 * @param value
	 *            the noted to be inserted.
	 * @return newly inserted node.
	 */
	public Node<T> addAtFront(T value) {
		Node<T> node = new Node<>(value);
		if (head == null) {
			setNullHead(node);
		} else {
			node.next = head;
			head = node;
		}
		return node;
	}

	private void setNullHead(Node<T> node) {
		head = node;
		tail = node;
	}

	public void del() {

	}

	public void show() {
		Node<T> node = head;
		System.out.print("[HEAD] --> ");
		while (node != null) {
			System.out.print("[" + node.value + "] --> ");
			node = node.next;
		}
		System.out.print("[#]");
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

}
