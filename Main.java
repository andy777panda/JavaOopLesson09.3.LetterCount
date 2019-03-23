package net.ukr.andy777;

/*
 Lesson09
 3. Считайте из файла текст на английском языке,
 вычислите относительную частоту повторения каждой буквы и
 выведите на экран результат в порядке убывания относительной частоты повторения. */

import java.io.File;

public class Main {
	public static void main(String[] args) {
		File file = new File("text.txt"); // файл зчитування
		String lang = "EN"; // мова літер пошуку EN/RU
		Abc abc = new Abc(file, lang);
		System.out.println(abc.countLetters().sort());
	}
}