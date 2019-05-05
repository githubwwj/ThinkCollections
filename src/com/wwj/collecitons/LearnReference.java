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

	// �ڴ����:�ܹ���1M�ڴ�,�Ѿ�ʹ����1M,���������ڴ�ʧ�� OutOfMemoryError

	// �ڴ�й©:�ܹ���1M�ڴ�,ĳ������ʹ����100K�ڴ�,����һֱ���ͷ�

	// ǿ����:GCɨ�赽ĳ��������ǿ����,���������

	// ������:�ڴ治��GC���ͷ��ڴ�

	// ������:GCɨ�赽�������,ֱ�ӻ���

	public static void main(String[] args) {

		// ǿ����
//		Apple[] apples = new Apple[12000];
//		for (int i = 0; i < apples.length; i++) {
//			apples[i] = new Apple(i + 1, "��ϲ����ƻ��" + i);
//		}
//		System.out.println(apples[apples.length - 1]);

//		SoftReference<Apple>[] softReferenceArr = new SoftReference[12000];
//		for(int i=0;i<softReferenceArr.length;i++) {
//			softReferenceArr[i]=new SoftReference<Apple>(new Apple(i + 1, "��ϲ����ƻ��" + i));
//		}
//		System.out.println(softReferenceArr[softReferenceArr.length - 1].get());

//		WeakReference<Apple>[] weReferences=new WeakReference[12000];
//		for(int i=0;i<weReferences.length;i++) {
//			weReferences[i] =new WeakReference<Apple>(new Apple(i + 1, "��ϲ����ƻ��" + i));
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
