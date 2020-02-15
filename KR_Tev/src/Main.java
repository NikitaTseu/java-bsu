import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) throws Exception{
		MyContainer<Car> cont1 = new MyContainer<>();
		MyContainer<Bus> cont2 = new MyContainer<>();
		
		try {
			Scanner sc = new Scanner(new File("input1.txt"));
			cont1.clear();
			while(sc.hasNextLine()) {
				StringBuffer sb = new StringBuffer();
				String s = sc.nextLine();
				sb.append(s);
				cont1.add(new Car(s));
			}
			sc.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Exception! File 'input1.txt' isn't found.");
		}
		catch(NoSuchElementException e) {
			System.out.println("Exception! Get error during parsing the input data.");
		}
		
		try {
			Scanner sc = new Scanner(new File("input2.txt"));
			cont2.clear();
			while(sc.hasNextLine()) {
				StringBuffer sb = new StringBuffer();
				String s = sc.nextLine();
				sb.append(s);
				cont2.add(new Bus(s));
			}
			sc.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Exception! File 'input2.txt' isn't found.");
		}
		catch(NoSuchElementException e) {
			System.out.println("Exception! Get error during the parsing the input data.");
		}
		
		System.out.println("Demonstration for class 'Car'");
		System.out.println("Print the container:");
		cont1.print();
		System.out.println("Nuber of cars:");
		System.out.println(cont1.count(new Car("Reno", "red", Fuel.valueOf("ROCKETFUEL"), Material.valueOf("METAL"))));
		System.out.println("Let's find a car:");
		System.out.println(cont1.binarySearch(new Car("Reno", "red", Fuel.valueOf("ROCKETFUEL"), Material.valueOf("METAL"))));
		System.out.println("Find max:");
		System.out.println(cont1.max());
		
		System.out.println();
		System.out.println();
		
		System.out.println("Demonstration for class 'Bus'");
		System.out.println("Print the container:");
		cont2.print();
		System.out.println("Nuber of buses:");
		System.out.println(cont2.count(new Bus("Reno", "red", Fuel.valueOf("ROCKETFUEL"), 1, 1)));
		System.out.println("Let's find a bus:");
		System.out.println(cont2.binarySearch(new Bus("Reno", "green", Fuel.valueOf("ROCKETFUEL"), 1, 1)));
		System.out.println("Find max:");
		System.out.println(cont2.max());
	}

}
