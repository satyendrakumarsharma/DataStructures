package com.satya.learn.ds.linear;

public interface Stack<E> {

	public boolean push(E e);

	public E pop();

	public E peek();

	public boolean isEmpty();

	public int size();
}
