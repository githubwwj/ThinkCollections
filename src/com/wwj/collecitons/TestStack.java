package com.wwj.collecitons;

public class TestStack {

	public static void main(String[] args) {

		MyStack<Integer> myStack = new MyStack<Integer>();

		String str = "9 3 1 - 3 * + 10 2 / +";
		String[] strArr = str.split(" ");

		for (int i = 0; i < strArr.length; i++) {
			int temp = 0;
			if (strArr[i].trim().equals("+")) {
				int a = myStack.pop();
				int b = myStack.pop();
				temp = b + a;
				myStack.push(temp);
			}else if (strArr[i].trim().equals("-")) {
				int a = myStack.pop();
				int b = myStack.pop();
				temp = b - a;
				myStack.push(temp);
			}else if (strArr[i].trim().equals("*")) {
				int a = myStack.pop();
				int b = myStack.pop();
				temp = b * a;
				myStack.push(temp);
			}else if (strArr[i].trim().equals("/")) {
				int a = myStack.pop();
				int b = myStack.pop();
				temp = b / a;
				myStack.push(temp);
			} else {
				myStack.push(Integer.parseInt(strArr[i], 10));
			}
		}
		System.out.println("计算结果为="+myStack.pop()+"\tsize="+myStack.size());

	}

}
