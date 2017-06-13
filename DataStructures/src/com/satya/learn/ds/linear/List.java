package com.satya.learn.ds.linear;

public interface List<E> {
	void add(E e);

	E remove(E e);

	E remove(int index);

	E get(int index);

	int indexOf(E e);

	int size();
}
