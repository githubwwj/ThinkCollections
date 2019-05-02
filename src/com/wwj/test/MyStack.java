package com.wwj.test;

import java.util.EmptyStackException;

public class MyStack<E> {

	private Object[] elementData;
	private int elementCount;

	public MyStack(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		this.elementData = new Object[initialCapacity];
	}

	public MyStack() {
		this(10);
	}

	public E push(E e) {
		if (elementCount + 1 > elementData.length) {
			grow();
		}
		elementData[elementCount++] = e;
		return e;
	}

	@SuppressWarnings("unchecked")
	public E pop() {
		return (E) elementData[--elementCount];
	}

	public synchronized E peek() {
		int len = elementCount;

		if (len == 0)
			throw new EmptyStackException();
		return elementAt(len - 1);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized E elementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
        }
        return (E) elementData[index];
    }

	public synchronized int size() {
		return elementCount;
	}

	private void grow() {

	}

}
