import java.util.Arrays;

public class Demonstration {
	public static void main(String[] args) throws Exponential.ArgException{
		Exponential e1 = new Exponential(2, 1, 5);
		Exponential e2 = new Exponential("(2;2;3)");
		Exponential e3 = new Exponential(1, 0.5, 50);
		
		System.out.println("����� ������ ����������  = " + e1.sum());
		System.out.println("����� ������ ����������  = " + e2.sum());
		System.out.println("����� ������� ���������� = " + e3.sum());
		System.out.println();
		
		System.out.println("��������� ������ ������ ����������  = " + e1.toString());
		System.out.println("��������� ������ ������ ����������  = " + e2.toString());
		System.out.println("��������� ������ ������� ���������� = " + e3.toString());
		System.out.println();
		
		try{
			System.out.println("������ ������� ������� ����������  = " + e3.getElement(2));
			// ������� �������������� ��������
			System.out.println("��������� ������� ������ ����������  = " + e1.getElement(29));
		}
		catch(Exponential.ArgException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println();
		
		try{
			e2.setFieldToComparison("base"); // ������ ���������� ����� ������������ � ������� �� ���������
		}
		catch(Exponential.ArgException e) {
			e.printStackTrace();
		}
		
		System.out.println("������� ������ � ������ ���������� (�� ���������): ");
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
		
		e2.next(); // ������ ������ ���������� ������������ � ������� ��� �� �����������
		System.out.println("������� ������ � ������ ���������� (�� �����������): ");
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
		
		System.out.println("������� ���� ���������� � ������ � ����������� ��� �� �����������: ");
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
