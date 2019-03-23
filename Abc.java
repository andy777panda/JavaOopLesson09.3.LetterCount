package net.ukr.andy777;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Abc {
	private ArrayList<Letter> abc;// = new ArrayList<Letter>();
	private File file;
	private String lang;

	// конструктор
	public Abc(File file, String lang) {
		this.file = file;
		this.lang = lang;
		abc = fillLetters(new ArrayList<Letter>());
	}

	// ініціалізація колекції літерами алфавіту пошуку 
	public ArrayList<Letter> fillLetters(ArrayList<Letter> abc) {
		for (char ch = (lang.equals("EN")?'A':'А'); ch <= (lang.equals("EN")?'Z':'Я'); ch++) {
			abc.add(new Letter(ch));
		}
		return abc;
	}

	// посимвольне вичитування тексту з файлу та підрахунок літер алфавіту пошуку
	public Abc countLetters() {
		char ch;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			int symbol = br.read();// зчитування символу
			while (symbol != -1) {
				ch = Character.toUpperCase((char) symbol); // перетворення до великих літер
				symbol = (int) ch - (int) (lang.equals("EN")?'A':'А'); // місце великої літери в колекції
				if (symbol >= 0 && symbol <= 25)
					abc.get(symbol).addCount();
				symbol = br.read(); // зчитування символу
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

	// сортування алфавіту
	public Abc sort() {
		Collections.sort(abc, new LetterComparator());
		return this;
	}

	public String toString() {
		String res = "In the file \"" + file + "\" are such letters:" + System.getProperty("line.separator");
		for (int i = 0; i < abc.size(); i++) {
			res += abc.get(i).getChr() + "\t" + abc.get(i).getCount() + System.getProperty("line.separator");
		}
		return res;
	}
}
