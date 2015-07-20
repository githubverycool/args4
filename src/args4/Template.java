package args4;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

public abstract class Template {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	@SuppressWarnings("rawtypes")
	public static void exch(Comparable[] arr, int i, int j) {
		Comparable t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	@SuppressWarnings("rawtypes")
	public static void show(Comparable[] arr) {
		for (int i = 0; i < arr.length; i++) {
			StdOut.print(arr[i] + "\t");
		}
		StdOut.println();
	}

	@SuppressWarnings("rawtypes")
	public static boolean isSorted(Comparable[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (less(arr[i], arr[i - 1])) {
				return false;
			}
		}
		return true;
	}

	// exchange a[i] and a[j]
	public static void draw(Comparable[] arr, int row, int ith, int min) {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(-2.50, row, ith + "");
		StdDraw.text(-1.25, row, min + "");
		for (int i = 0; i < arr.length; i++) {
			if (i == min)
				StdDraw.setPenColor(StdDraw.BOOK_RED);
			else if (i < ith)
				StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			else
				StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(i, row, arr[i] + "");
		}
	}
}
