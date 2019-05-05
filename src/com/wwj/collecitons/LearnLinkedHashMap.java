package com.wwj.collecitons;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class LearnLinkedHashMap {

	public static void main(String[] args) {

		LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<String, Integer>();
//		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

		hashMap.put("Bob", 54);
		hashMap.put("LiLi", 80);
		hashMap.put("Bob_q", 64);

		Set<Entry<String, Integer>> entrySet = hashMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey());
		}
		
		System.out.println("--------------");
		Iterator<Entry<String, Integer>> iterator=entrySet.iterator();
		while(iterator.hasNext()) {
			Entry<String, Integer> entry=iterator.next();
			System.out.println(entry);
		}
		
	}

}
