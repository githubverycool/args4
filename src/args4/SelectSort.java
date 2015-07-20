package args4;

import edu.princeton.cs.introcs.In;

/**
 * 选择排序
 * 
 * @author guojun
 *
 */
public class SelectSort extends Template {

	/**
	 * 比较次数 N2/2 交换次数 N
	 * 
	 * @param arr
	 */
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] arr) {
		int lessCount = 0;
		int exchCount = 0;
		int n = arr.length;
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				++lessCount;
				if (less(arr[j], arr[min])) {
					min = j;
				}
			}
			++exchCount;
			exch(arr, i, min);
		}
		System.out.println("选择排序比较次数:"+lessCount);
		System.out.println("选择排序交换次数:"+exchCount);
	}

	public static void main(String[] args) {
//		String filename = "/home/guojun/test/algs4";
		 String filename = "/home/guojun/test/tiny.txt";
		String[] arr = In.readStrings(filename);
		sort(arr);
		System.out.println(isSorted(arr));
		show(arr);
	}

}
