package args4;

import edu.princeton.cs.introcs.In;

public class ShellSort extends Template {

	public static void sort(Comparable[] arr) {
		int n = arr.length;
		int h = 1;
		int lessCount=0;
		int exchCount=0;
		while (h < n / 3) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < n; i++) {
				++lessCount;
				for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) {
					++lessCount;
					++exchCount;
					exch(arr, j, j - h);
					
				}
			}
			h = h / 3;
		}
		System.out.println("希尔排序比较次数:"+lessCount);
		System.out.println("希尔排序交换次数:"+exchCount);
	}

	public static void main(String[] args) {
		String filename = "/home/guojun/test/tiny.txt";
		// String filename = "/home/guojun/test/tiny.txt";
		String[] arr = In.readStrings(filename);
		sort(arr);
		System.out.println(isSorted(arr));
		show(arr);
	}
}
