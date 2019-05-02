package com.wwj.collecitons;

import java.util.EmptyStackException;

public class MyStack<E> {

	private Object[] elementData;
	private int elementCount;

	public MyStack() {
		this(10);
	}

	public MyStack(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new EmptyStackException();
		}
		this.elementData = new Object[initialCapacity];
	}

	public E push(E item) {
		addElement(item);
		return item;
	}

	public E pop() {
		if (elementCount <= 0) {
			throw new EmptyStackException();
		}
		@SuppressWarnings("unchecked")
		E element = (E) elementData[--elementCount];
		elementData[elementCount] = null;
		return element;
	}

	@SuppressWarnings("unchecked")
	public E peek() {
		if (elementCount <= 0) {
			throw new EmptyStackException();
		}
		return (E) elementData[--elementCount];
	}

	private void addElement(E item) {
		ensureCapacity();

		elementData[elementCount++] = item;
	}

	private void ensureCapacity() {
		if (elementCount + 1 > elementData.length) {
			grow();
		}
	}
	
	public int size() {
		return elementCount;
	}

	private void grow() {
		elementCount *= 2;

		Object[] newOjbect = new Object[elementCount];
		for (int i = 0; i < elementCount; i++) {
			newOjbect[i] = elementData[i];
		}
	}

}
