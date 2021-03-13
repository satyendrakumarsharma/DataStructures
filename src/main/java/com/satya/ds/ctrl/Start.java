package com.satya.ds.ctrl;

import com.satya.ds.type.LinkedList;
import com.satya.ds.type.LinkedList.Node;

/**
 * @author 703162557
 *
 */
public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("      ~~~~~~ Data Structures ~~~~~~\n");

		LinkedList<Object> list = new LinkedList<>();
		list.add(24);
		list.add(5.7);
		Node<Object> n = list.add("Satya");
		list.add(12);
		list.addAtFront('F');
		list.addAt(n, 555);

		list.show();

	}
}
