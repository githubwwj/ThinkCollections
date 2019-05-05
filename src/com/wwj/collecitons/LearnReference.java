package com.wwj.collecitons;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.time.temporal.WeekFields;
import java.util.WeakHashMap;

public class LearnReference {

	static class Apple {
		int id;
		String name;

		public Apple(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return "apple id=" + id + " name=" + name;
		}
	}

	// 内存溢出:总共有1M内存,已经使用了1M,继续分配内存失败 OutOfMemoryError

	// 内存泄漏:总共有1M内存,某个对象使用了100K内存,对象一直不释放

	// 强引用:GC扫描到某个对象有强引用,不会回收它

	// 软引用:内存不足GC会释放内存

	// 弱引用:GC扫描到这个对象,直接回收

	public static void main(String[] args) {

		// 强音用
//		Apple[] apples = new Apple[12000];
//		for (int i = 0; i < apples.length; i++) {
//			apples[i] = new Apple(i + 1, "我喜欢吃苹果" + i);
//		}
//		System.out.println(apples[apples.length - 1]);

//		SoftReference<Apple>[] softReferenceArr = new SoftReference[12000];
//		for(int i=0;i<softReferenceArr.length;i++) {
//			softReferenceArr[i]=new SoftReference<Apple>(new Apple(i + 1, "我喜欢吃苹果" + i));
//		}
//		System.out.println(softReferenceArr[softReferenceArr.length - 1].get());

//		WeakReference<Apple>[] weReferences=new WeakReference[12000];
//		for(int i=0;i<weReferences.length;i++) {
//			weReferences[i] =new WeakReference<Apple>(new Apple(i + 1, "我喜欢吃苹果" + i));
//		}
//		System.out.println(weReferences[weReferences.length - 1].get());

		Object object = new Object();
//		SoftReference<Object> softReference = new SoftReference<Object>(object);
		WeakReference<Object> weakReference = new WeakReference<Object>(object);
		object = null;
		System.gc();
		System.out.println(weakReference.get());

		WeakHashMap<String, String> weakHashMap = new WeakHashMap<String, String>();
		weakHashMap.put("LiLi", "80");
		System.gc();

		System.out.println(weakHashMap.get("LiLi"));

	}

}
