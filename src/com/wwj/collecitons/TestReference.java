package com.wwj.collecitons;

import java.lang.ref.WeakReference;

public class TestReference {

	static class Person {
		int id;

		@Override
		public String toString() {
			return "Person.id=" + id;
		}
	}

	public static void main(String[] args) {

		Person person = new Person();
		person.id = 100;

		WeakReference<Person> weakReference = new WeakReference<Person>(person);
		person = null;
		System.gc();
		System.out.println(weakReference.get());

	}

}
