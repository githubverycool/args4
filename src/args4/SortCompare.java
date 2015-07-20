package args4;

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class SortCompare {

	@SuppressWarnings("rawtypes")
	public static double time(String argsName, Comparable[] arr) {
		Stopwatch timer = new Stopwatch();
		if (argsName.equals(INSERTION_SORT)) {
			InsertionSort.sort(arr);
		}
		if (argsName.equals(SELECT_SORT)) {
			SelectSort.sort(arr);
		}
		if (argsName.equals(BUBBLE_SORT)) {
			BubbleSort.sort(arr);
		}
		if(argsName.equals(SHELL_SORT)){
			ShellSort.sort(arr);
		}
		return timer.elapsedTime();
	}

	public static double timeRandomInput(String argsName, int length, int t) {
		double value=0.0;
		double total = 0.0;
		Double[] arr = new Double[length];
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < length; j++) {
//				arr[j] = StdRandom.uniform();
				if(value==3.0){
					value=0.0;
				}
				arr[j] = ++value;
			}
			total += time(argsName, arr);
		}
		return total;
	}

	final static String INSERTION_SORT = "InsertionSort";
	final static String SELECT_SORT = "SelectSort";
	final static String BUBBLE_SORT = "BubbleSort";
	final static String SHELL_SORT = "ShellSort";
/**
 * 初级排序算法的性能由比较次数和交换次数决定.
 * 不同的排序算法的比较次数和交换次数会根据数组的长度 元素是否相同 元素的组成规则
 * @param args
 */
	public static void main(String[] args) {
		int length=5000;
		int t=1;
		double t1= timeRandomInput(INSERTION_SORT, length, t);
		double t2= timeRandomInput(SELECT_SORT, length, t);
		double t3= timeRandomInput(BUBBLE_SORT, length, t);
		double t4= timeRandomInput(SHELL_SORT, length, t);
		StdOut.printf("数组长度为:%d,重复次数:%d,InsertionSort 排序时间是%s 秒\n",length,t,t1);
		StdOut.printf("数组长度为:%d,重复次数:%d,SelectSort 排序时间是%s 秒\n",length,t,t2);
		StdOut.printf("数组长度为:%d,重复次数:%d,BubbleSort 排序时间是%s 秒\n",length,t,t3);
		StdOut.printf("数组长度为:%d,重复次数:%d,ShellSort 排序时间是%s 秒\n",length,t,t4);
//		StdOut.printf("InsertionSort是SelectSort %.1f 倍\n",t2/t1);
	
	}
}
