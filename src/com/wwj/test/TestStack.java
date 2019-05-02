package com.wwj.test;

public class TestStack {

	public static void main(String[] args) {
		MyStack<Integer> suffix = new MyStack<Integer>();
		MyStack<Integer> number = new MyStack<Integer>();

		String str = "9+(3-1)*3+10/2";

//		int second, first;
//		boolean number = false;
//		if (number) {
//			second = chArr[i];
//		} else {
//			first = chArr[i];
//			number = true;
//		}
//		char[] chArr = str.toCharArray();
//		for (int i = 0; i < chArr.length; i++) {
//			if (chArr[i] >= '0' && chArr[i] <= '9') {
//				number.push((int) chArr[i]);
//			} else if (chArr[i] == '+' || chArr[i] == '-') {
//				if (suffix.size() > 0) {
//					int ch = suffix.peek();
//					if (ch > chArr[i]) {
//						number.push((int) chArr[i]);
//						continue;
//					}
//				}
//				suffix.push((int) chArr[i]);
//			} else if (chArr[i] == '*' || chArr[i] == '/') {
//				suffix.push((int) chArr[i]);
//			} else if (chArr[i] == '(') {
//				suffix.push((int) chArr[i]);
//			} else if (chArr[i] == ')') {
//				while (suffix.size() > 0) {
//					if (suffix.peek() == '(') {
//						break;
//					}
//					number.push(suffix.pop());
//				}
//				suffix.pop();
//			}
//		}
//
//		for (int i = 0; i < number.size(); i++) {
//			System.out.println(number.pop());
//		}

	}

}
