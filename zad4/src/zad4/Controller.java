package zad4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

	private static ArrayList<Character> numb = new ArrayList<Character>();
	private static ArrayList<Character> rus = new ArrayList<Character>();
	private static ArrayList<Character> eng = new ArrayList<Character>();

	public static String action(String s) {

		numb.clear();
		rus.clear();
		eng.clear();

		File f = new File(s);

		if (!f.exists()) {
			return "Файл не найден";
		}

		FileReader fr;
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			return "Файл не найден";
		}

		try {
			Pattern num = Pattern.compile("\\d");
			Pattern lrus = Pattern.compile("[а-яА-Я]");
			Pattern leng = Pattern.compile("[a-zA-Z]");

			int c;
			while ((c = fr.read()) != -1) {
				Matcher m = num.matcher(((char) c) + "");
				if (m.matches()) // && !numbers.contains((char)c) )
					numb.add((char) c);

				m = lrus.matcher(((char) c) + "");
				if (m.matches())// && !lRus.contains((char)c) )
					rus.add((char) c);

				m = leng.matcher(((char) c) + "");
				if (m.matches())// && !lEng.contains((char)c) )
					eng.add((char) c);

			}

			fr.close();
		} catch (IOException e1) {
			return "Нет доступа для чтения";
		}

		sortLists();
		try {
			writeFiles();
		} catch (IOException e) {
			return "Нет доступа для записи";
		}

		return "success";
	}

	private static void sortLists() {
		Collections.sort(numb);
		Collections.sort(rus);
		Collections.sort(eng);
	}

	static void writeFiles() throws IOException {
		File dir = new File("answer");
		if (!dir.exists()) {
			dir.mkdir();
		}

		File f = new File("answer/rus.txt");
		f.createNewFile();

		PrintWriter out = new PrintWriter(f);
		for (Character c : rus) {
			out.println(c);
		}
		out.close();

		f = new File("answer/eng.txt");
		f.createNewFile();

		out = new PrintWriter(f);
		for (Character c : eng) {
			out.println(c);
		}
		out.close();

		f.createNewFile();
		f = new File("answer/numbers.txt");
		out = new PrintWriter(f);
		for (Character c : numb) {
			out.println(c);
		}
		out.close();

	}

}
