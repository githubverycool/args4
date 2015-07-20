package args4;

import edu.princeton.cs.introcs.In;

/**
 * 插入排序
 * 
 * @author guojun
 *
 */
public class InsertionSort extends Template {

	/**
	 * 比较 N2/2 - N-1 交换 N2/2 - 0
	 * 
	 * @param arr
	 */
	public static void sort(Comparable[] arr) {
		int lessCount = -1;
		int exchCount = 0;
		for (int i = 0; i < arr.length; i++) {
			++lessCount;
			for (int j=i; j > 0 && (less(arr[j], arr[j - 1])); j--) {
				++lessCount;
				++exchCount;
				exch(arr, j, j - 1);
			}
		}
		System.out.println("插入排序比较次数:" + lessCount);
		System.out.println("插入排序交换次数:" + exchCount);
	}

	public static void main(String[] args) {
		// String filename = "/home/guojun/test/algs4";
		String filename = "/home/guojun/test/tiny.txt";
		String[] arr = In.readStrings(filename);
		sort(arr);
		System.out.println(isSorted(arr));
		show(arr);
	}
}
