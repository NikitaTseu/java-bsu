import java.util.Arrays;

public class Demonstration {
	public static void main(String[] args) throws Exponential.ArgException{
		Exponential e1 = new Exponential(2, 1, 5);
		Exponential e2 = new Exponential("(2;2;3)");
		Exponential e3 = new Exponential(1, 0.5, 50);
		
		System.out.println("Сумма первой прогрессии  = " + e1.sum());
		System.out.println("Сумма второй прогрессии  = " + e2.sum());
		System.out.println("Сумма третьей прогрессии = " + e3.sum());
		System.out.println();
		
		System.out.println("Строковый формат первой прогрессии  = " + e1.toString());
		System.out.println("Строковый формат второй прогрессии  = " + e2.toString());
		System.out.println("Строковый формат третьей прогрессии = " + e3.toString());
		System.out.println();
		
		try{
			System.out.println("Третий элемент третьей прогрессии  = " + e3.getElement(2));
			// Вызовем исключительную ситуацию
			System.out.println("Тридцатый элемент первой прогрессии  = " + e1.getElement(29));
		}
		catch(Exponential.ArgException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println();
		
		try{
			e2.setFieldToComparison("base"); // вторая прогрессия будет сравниваться с другими по основанию
		}
		catch(Exponential.ArgException e) {
			e.printStackTrace();
		}
		
		System.out.println("Сравним вторую и третью прогрессии (по основанию): ");
		if(e2.compareTo(e3) == 1) {
			System.out.println("e2 > e3");
		}
		else {
			if(e2.compareTo(e3) == -1) {
				System.out.println("e2 < e3");
			}
			else {
				System.out.println("e2 = e3");
			}
		}
		System.out.println();
		
		e2.next(); // теперь вторая прогрессия сравнивается с другими уже по знаменателю
		System.out.println("Сравним вторую и первую прогрессии (по знаменателю): ");
		if(e2.compareTo(e1) == 1) {
			System.out.println("e2 > e1");
		}
		else {
			if(e2.compareTo(e1) == -1) {
				System.out.println("e2 < e1");
			}
			else {
				System.out.println("e2 = e1");
			}
		}
		System.out.println();
		
		System.out.println("Добавим наши прогрессии в массив и отсортируем его по знаменателю: ");
		e1.setFieldToComparison("q");
		e2.setFieldToComparison("q");
		e3.setFieldToComparison("q");
		Series[] arr = new Series[3];
		arr[0] = e1;
		arr[1] = e2;
		arr[2] = e3;
		System.out.println("Sorted by: " + e1.getCurrentFieldname());
    	Arrays.sort(arr);
    	for(int i=0; i < 3; i++) {
    		System.out.println(arr[i]);
    	}
    	System.out.println();
	}
}
