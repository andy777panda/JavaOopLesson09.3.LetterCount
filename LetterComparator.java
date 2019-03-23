package net.ukr.andy777;

import java.util.Comparator;

public class LetterComparator implements Comparator<Letter> {
	@Override
	public int compare(Letter l1, Letter l2) {
		if (l1.getCount()> l2.getCount()) {
			return -1;
		} else if (l1.getCount()< l2.getCount()) {
			return 1;
		} else
			return 0;
	}
}