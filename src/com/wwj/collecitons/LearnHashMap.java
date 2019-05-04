package com.wwj.collecitons;

import java.util.HashMap;

public class LearnHashMap {

	public static void main(String[] args) {

		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

		hashMap.put("Bob", 54);
		hashMap.put("LiLi", 80);
		hashMap.put("Bob_q", 64);

		Object obj = new Object();

		System.out.println("obj.hashCode=" + obj.hashCode() + "---objµØÖ·=" + Integer.toHexString(obj.hashCode()));
//		6442b0a6
//		66965
		System.out.println("Bob".hashCode());

		System.out.println(1 ^ 1);

		int h = 66965;
		System.out.println(Integer.toBinaryString(h));

		h ^= (h >>> 20) ^ (h >>> 12);
		h = h ^ (h >>> 7) ^ (h >>> 4);

		System.out.println(Integer.toBinaryString(h) + "--h=" + h);
		int index = h & 15;
		System.out.println("index=" + index);
		
		System.out.println("Bob_q="+hashMap.get("Bob_q"));
		
		hashMap.put(null, 77);
		
		System.out.println(hashMap.get(null));
		System.out.println("remove(\"Bob\")="+hashMap.remove("Bob"));
		
		
	}

}
