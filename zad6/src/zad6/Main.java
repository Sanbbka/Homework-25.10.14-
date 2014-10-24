package zad6;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static void rs(String path) throws IOException {

		List<String> a = new ArrayList<String>();

		Path p = Paths.get(path);

		List<String> lines = Files.readAllLines(p, Charset.defaultCharset());

		for (String s : lines) {
			StringTokenizer t = new StringTokenizer(s, " ");
			String line = t.hasMoreTokens() ? t.nextToken() : "";
			while (t.countTokens() > 0) {
				line += " " + t.nextToken();
			}
			a.add(line);
		}

		Files.write(p, a, Charset.defaultCharset());

	}

	public static void main(String[] args) throws IOException {

		rs("data.txt");

	}

}
