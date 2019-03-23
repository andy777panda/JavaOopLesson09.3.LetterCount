package net.ukr.andy777;

public class Letter {
	private char chr;
	private int count;

	public Letter(char chr) {
		super();
		this.chr = chr;
		count = 0;
	}

	public char getChr() {
		return chr;
	}

	public int getCount() {
		return count;
	}

	public void addCount() {
		count++;
	}

	public String toString() {
		return chr + "\t" + count + System.getProperty("line.separator");
	}
}
