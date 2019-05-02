package com.wwj.collecitons;

public class TestMyLink {

	public static void main(String[] args) {

		LinkList<Integer> linkList = new LinkList<Integer>();

		linkList.add(10);
		linkList.add(16);
		linkList.add(36);
		linkList.add(6);

		linkList.remove(1);
		linkList.remove();
		
		linkList.set(0, 99);
		linkList.set(1, 66);
		
		for (int i = 0; i < linkList.size(); i++) {
			int value = linkList.get(i);
			System.out.printf("%d:%d\t", i, value);
		}

	}

}
