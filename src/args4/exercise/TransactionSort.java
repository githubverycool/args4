package args4.exercise;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TransactionSort {

	public static void main(String[] args) {
		// Transaction[] ts=
		String s = "1";
		System.out.println(s.hashCode());
		System.out.println(new String("1").equals(new String("1")));
		Object[] o = new Object[2];
		Arrays.sort(o);
		System.out.println(o.hashCode());
	}
}
