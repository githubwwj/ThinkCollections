package com.wwj.collecitons;

import java.util.NoSuchElementException;

public class LinkList<E> {

	// 节点中有多少个元素
	// transient 只在内存有效
	private transient int size = 0;

	private transient Node<E> first;

	private transient Node<E> last;

	public LinkList() {
	}

	public boolean add(E e) {
		linkLast(e);
		return true;
	}

	private void linkLast(E e) {
		final Node<E> l = last;
		final Node<E> newNode = new Node<E>(l, e, null);
		last = newNode;
		if (l == null) {
			first = newNode;
		} else {
			l.next = newNode;
		}
		size++;
	}

	void add(int index, E element) {
		checkIndex(index);
		if (index == size) {
			linkLast(element);
		} else {
			linkBefore(index, element);
		}
	}

	// 删除节点中的第一个元素
	public E remove() {
		return removeFirst();
	}

	private E removeFirst() {
		final Node<E> f = first;
		if (f == null) {
			throw new NoSuchElementException("没有节点");
		}
		E element = unlinkFirst(f);
		return element;
	}

	private E unlinkFirst(Node<E> f) {
		final E element = f.item;
		first = first.next;
		f.item = null;
		f.next = null;
		f.prev = null; // help GC
		if (first == null) {
			last = null;
		} else {
			first.prev = null;
		}
		size--;
		return element;
	}

	public E remove(int index) {
		checkIndex(index);
		return unlink(index);
	}

	public E set(int index, E element) {
		checkIndex(index);
		Node<E> targe = node(index);
		E oldValue = targe.item;
		targe.item = element;
		return oldValue;
	}

	private E unlink(int index) {
		final Node<E> x = node(index);
		final E element = x.item;
		final Node<E> pre = x.prev;
		final Node<E> next = x.next;

		if (null == pre) {
			first = next;
		} else {
			pre.next = next;
		}

		if (null == next) {
			last = pre;
		} else {
			next.prev = pre;
			x.next = null;
		}
		x.item = null;

		size--;
		return element;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E removeLast() {
		Node<E> l = last;
		if (l == null) {
			throw new NoSuchElementException("没有节点");
		}
		E element = l.item;
		last = last.prev;
		if (null != last) {
			last.next = null;
		}
		l.prev = null;
		l.next = null;
		l.item = null;

		size--;
		return element;
	}

	private void linkBefore(int index, E element) {
		final Node<E> succ = node(index);
		final Node<E> pre = succ.prev;
		final Node<E> newNode = new Node<E>(pre, element, succ);
		succ.prev = newNode;
		if (pre == null) {
			first = newNode;
		} else {
			pre.next = newNode;
		}
		size++;
	}

	public E get(int index) {
		checkIndex(index);
		return node(index).item;
	}

	private Node<E> node(int index) {
		if (index < size >> 1) {
			Node<E> x = first;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			return x;
		} else {
			Node<E> x = last;
			for (int i = size - 1; i > index; i--) {
				x = x.prev;
			}
			return x;
		}
	}

	private void checkIndex(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("" + index);
		}
	}

	public int size() {
		return size;
	}

	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}

}
