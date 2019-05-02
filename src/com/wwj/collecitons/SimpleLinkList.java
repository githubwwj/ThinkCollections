package com.wwj.collecitons;

public class SimpleLinkList<E> {

	private Node<E> head;

	public boolean add(E item) {
		linkLast(item);
		return true;
	}

	private void linkLast(E item) {
		Node<E> newNode = new Node<E>(item);
		if (null == head) {
			head = newNode;
		} else {
			Node<E> tail = head;
			while (tail.next != null) {
				tail = tail.next;
			}
			tail.next = newNode;
		}
	}

	public void display() {
		Node<E> tail = head;
		int i = 0;
		while (tail != null) {
			System.out.println((i++) + ":" + tail.item);
			tail = tail.next;
		}
	}

	public void reverse() {
		Node<E> curr = head;
		Node<E> reve = null;
		while (curr != null) {
			Node<E> temp = curr;
			curr = curr.next;
			temp.next = reve;
			reve = temp;
		}
		head = reve;
	}

	public static void main(String[] args) {
		SimpleLinkList<Integer> simpleLinkList = new SimpleLinkList<Integer>();
		simpleLinkList.add(10);
		simpleLinkList.add(20);
		simpleLinkList.add(30);
		simpleLinkList.add(40);

//ÄæÖÃ	40 30 20  10 

		simpleLinkList.display();
		
		System.out.println("ÄæÖÃºó");
		simpleLinkList.reverse();
		simpleLinkList.display();

	}

	private static class Node<E> {
		E item;
		Node<E> next;

		public Node(E item) {
			this.item = item;
		}
	}

}
