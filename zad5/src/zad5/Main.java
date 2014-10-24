package zad5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void qw(String pat) throws IOException {
		int lettersCount = 0;
		int linesCount = 0;
		int charsCount = 0;

		Path p = Paths.get(pat);

		List<String> lines = Files.readAllLines(p, Charset.defaultCharset());

		linesCount = lines.size();

		for (String s : lines) {
			StringTokenizer l = new StringTokenizer(s);
			lettersCount += l.countTokens();

			while (l.hasMoreTokens()) {
				charsCount += l.nextToken().length();
			}

		}

		System.out.println("Количестово символов: " + charsCount
				+ "\nКоличестово слов: " + lettersCount
				+ "\nКоличестово строк: " + linesCount);

	}

	public static void main(String[] args) throws IOException {
		qw("1.txt");

	}
}
