package args4.exercise;

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.introcs.StdOut;

public class Transaction implements Comparable<Transaction> {

	private final String who;
	private final Date when;
	private final double amount;

	public Transaction(String who, Date when, double amount) {
		super();
		this.who = who;
		this.when = when;
		if (amount == 0.0) {
			this.amount = 0.0;
		} else {
			this.amount = amount;
		}
	}

	public Transaction(String transactionStr) {
		String[] params = transactionStr.split(" ");
		this.who = params[0];
		this.when = new Date(params[1]);
		this.amount = Double.parseDouble(params[2]);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((when == null) ? 0 : when.hashCode());
		result = prime * result + ((who == null) ? 0 : who.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		if (when == null) {
			if (other.when != null)
				return false;
		} else if (!when.equals(other.when))
			return false;
		if (who == null) {
			if (other.who != null)
				return false;
		} else if (!who.equals(other.who))
			return false;
		return true;
	}

	@Override
	public int compareTo(Transaction that) {
		if (this.amount > that.amount) {
			return 1;
		} else if (this.amount < that.amount) {
			return -1;
		} else {
			return 0;
		}
	}

	public static class WhoOrder implements Comparator<Transaction> {
		@Override
		public int compare(Transaction o1, Transaction o2) {
			return o1.who.compareTo(o2.who);
		}
	}

	public static class WhenOrder implements Comparator<Transaction> {
		@Override
		public int compare(Transaction o1, Transaction o2) {
			return o1.when.compareTo(o2.when);
		}
	}

	public static class HowMuchOrder implements Comparator<Transaction> {
		@Override
		public int compare(Transaction o1, Transaction o2) {
			if (o1.amount > o2.amount) {
				return 1;
			} else if (o1.amount < o2.amount) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	@Override
	public String toString() {
		return "Transaction [who=" + who + ", when=" + when + ", amount="
				+ amount + "]";
	}

	public static void main(String[] args) {
		Transaction[] ts = new Transaction[3];
		String s1 = "zhangsan 6/17/1990 100";
		String s2 = "lisi 6/18/1990 190";
		String s3 = "wangwu 6/15/1990 110";
		ts[0] = new Transaction(s1);
		ts[1] = new Transaction(s2);
		ts[2] = new Transaction(s3);
		Arrays.sort(ts, new Transaction.WhoOrder());
		for (int i = 0; i < ts.length; i++) {
			StdOut.println(ts[i]);
		}
		StdOut.println();
		Arrays.sort(ts, new Transaction.WhenOrder());
		for (int i = 0; i < ts.length; i++) {
			StdOut.println(ts[i]);
		}
		StdOut.println();
		Arrays.sort(ts, new Transaction.HowMuchOrder());
		for (int i = 0; i < ts.length; i++) {
			StdOut.println(ts[i]);
		}
		StdOut.println();
	}

}
