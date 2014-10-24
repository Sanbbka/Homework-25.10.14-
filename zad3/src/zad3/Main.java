package zad3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
	
		qwe c = new qwe();
		
		Scanner sc = new Scanner(new File("camera.txt"));
		sc.useDelimiter(";|\\s");	
		
		
		
		while(sc.hasNext()){
			c.add(sc.next());
		}
		
		sc.close();
		
		c.cameraCount();
		c.playVideo("192.168.1.125:554");
		
	}

}
