package zad4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¬ведите название файла ");
		String s = sc.nextLine();
		System.out.println(Controller.action(s));
		sc.close();
	}

}
