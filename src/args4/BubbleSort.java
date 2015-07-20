package args4;

import edu.princeton.cs.introcs.In;
/**
 * 冒泡排序
 * @author guojun
 *
 */
public class BubbleSort extends Template {

	/**
	 * 比较次数 N2/2 交换次数 0-N2/2
	 * 
	 * @param arr
	 */
	public static void sort(Comparable[] arr) {
		int lessCount=0;
		int exchCount=0;
		for (int i = 0; i < arr.length; i++) {
			int n = arr.length;
			for (int j = i + 1; j < n; j++) {
				++lessCount;
				if (less(arr[j], arr[i])) {
					++exchCount;
					exch(arr, j, i);
				}
			}

		}
		System.out.println("冒泡排序比较次数:"+lessCount);
		System.out.println("冒泡排序交换次数:"+exchCount);
	}
	public static void main(String[] args) {
		String filename = "/home/guojun/test/algs4";
//		 String filename = "/home/guojun/test/tiny.txt";
		String[] arr = In.readStrings(filename);
		sort(arr);
		System.out.println(isSorted(arr));
		show(arr);
	}

}
