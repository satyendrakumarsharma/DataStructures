package com.satya.learn.ds.linear;

/**
 * Singly Linked List
 * 
 * @author Satyendra
 *
 */
public class LinkedList<E> implements List<E> {

	private LinearNode<E> head;

	// private LinearNode<E> last;

	private int size = 0;

	public LinkedList() {
	}

	@Override
	public void add(E e) {
		LinearNode<E> pos = head;
		// create a new node with given data.
		LinearNode<E> newElement = new LinearNode<>(e);
		if (head == null) {
			head = newElement;
		} else {
			// traverse to the END of linked-list.
			while (pos.next != null) {
				pos = pos.next;
			}
			// set this newly created node at the end of linked-list.
			pos.next = newElement;
		}
		size++;
		// last = newElement;
	}

	@Override
	public E remove(E e) {
		LinearNode<E> node = getNodeFor(e);
		E remElement = null;
		if (node != null) {
			unlink(node);
			remElement = node.data;
		}
		return remElement;
	}

	@Override
	public E remove(int index) {
		LinearNode<E> node = getNodeFor(index);
		E remElement = null;
		if (node != null) {
			unlink(node);
			remElement = node.data;
		}
		return remElement;
	}

	private LinearNode<E> getNodeFor(E e) {
		LinearNode<E> node = head;
		while (node != null && !node.data.equals(e)) {
			node = node.next;
		}
		return node;
	}

	private LinearNode<E> getNodeFor(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		LinearNode<E> node = head;
		for (int i = 0; node != null && i < index; i++) {
			node = node.next;
		}
		return node;
	}

	private void unlink(LinearNode<E> node) {
		LinearNode<E> posPre = head;
		LinearNode<E> pos = head;
		boolean isFirst = true;
		if (head != null && node != null) {
			if (node == head) {
				head = node.next;
			}
			while (!pos.equals(node)) {
				if (isFirst) {
					isFirst = false;
				} else {
					posPre = posPre.next;
				}
				pos = pos.next;
			}
			posPre.next = pos.next;
		}
		size--;
	}

	@Override
	public E get(int index) {
		E element = null;
		if (head != null) {
			LinearNode<E> pos = head;
			for (int i = 0; i <= index; i++) {
				element = pos.data;
				pos = pos.next;
			}
		}
		return element;
	}

	@Override
	public int indexOf(E e) {
		if (head != null) {
			LinearNode<E> pos = head;
			int index = 0;
			// keep traversing till the END of linked-list.
			while (pos.next != null) {
				if (pos.data.equals(e)) {
					return index;
				}
				pos = pos.next;
				index++;
			}
		}
		return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder strArrayList = new StringBuilder("[ ");
		int i = 0;
		LinearNode<E> node = head;
		while (node != null) {
			strArrayList.append("[" + i++ + "]").append(node.data).append(" ");
			node = node.next;
		}
		strArrayList.append("]");
		return strArrayList.toString();
	}

}
