package com.wwj.collecitons;

import java.util.HashSet;
import java.util.Iterator;

public class LearnHashSet {

	Person person = new Person(this);
	String name;

	static class Person {
		LearnHashSet lhs;

		public Person(LearnHashSet learnHashSet) {
			lhs = learnHashSet;
		}

		public void setName(String n) {
			lhs.name = n;
		}
		
		@Override
		public String toString() {
			return lhs.name;
		}
		
	}

	public static void main(String[] args) {

		//强引用
		HashSet<Person> hashSet = new HashSet<Person>();

		Person person = new Person(new LearnHashSet());
		person.setName("斯坦利");
		System.out.println(hashSet.add(person));
		System.out.println(hashSet.add(person));
		
		Iterator<Person> iterator=hashSet.iterator();
		System.out.println(iterator.next());
		
		
		
		
		

	}
	

}
