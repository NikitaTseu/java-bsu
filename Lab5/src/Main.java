public class Main {

	public static void main(String[] args) {
		TreePrinter trP = new TreePrinter();
		Person[] pArr = new Person[13];
		pArr[0] = new Person("Ellie", 12);
		pArr[1] = new Person("John", 9);
		pArr[2] = new Person("Mary", 15);
		pArr[3] = new Person("Alex", 7);
		pArr[4] = new Person("Bob", 11);
		pArr[5] = new Person("Mike", 14);
		pArr[6] = new Person("Nik", 21);
		pArr[7] = new Person("Helga", 6);
		pArr[8] = new Person("Jerry", 10);
		pArr[9] = new Person("Farid", 19);
		pArr[10] = new Person("Sandra", 30);
		pArr[11] = new Person("Jim", 3);
		pArr[12] = new Person("Sofia", 5);
		
		
		Node<Person> personRoot = new Node<>(pArr[0]); 
		for(int i=1; i<13; i++) {
			personRoot.add(new Node<Person>(pArr[i]));
		}
		personRoot.goThroughRootLeftRight(trP);
		System.out.println();
		personRoot.goThroughLeftRightRoot(trP);
		System.out.println();
		personRoot.goThroughLeftRootRight(new NodeVisitor() {
			public void visit(Node<?> node) {
				System.out.println(node);
			}
		});
		System.out.println();
		
		int[] nArr = new int[13];
		nArr[0] = 12;
		nArr[1] = 9;
		nArr[2] = 15;
		nArr[3] = 7;
		nArr[4] = 11;
		nArr[5] = 14;
		nArr[6] = 21;
		nArr[7] = 6;
		nArr[8] = 10;
		nArr[9] = 19;
		nArr[10] = 30;
		nArr[11] = 3;
		nArr[12] = 5;
		
		
		Node<Integer> numbersRoot = new Node<>(nArr[0]); 
		for(int i=1; i<13; i++) {
			numbersRoot.add(new Node<Integer>(nArr[i]));
		}
		numbersRoot.goThroughRootLeftRight(trP);
		System.out.println();
		numbersRoot.goThroughLeftRightRoot(trP);
		System.out.println();
		numbersRoot.goThroughLeftRootRight(trP);
		System.out.println();
		
		Node<Integer> n6 = numbersRoot.find(6);
		Node<Integer> n14 = numbersRoot.find(14);
		Node<Integer> n9= numbersRoot.find(9);
		
		System.out.println(numbersRoot.relationDegree(n6));
		System.out.println(n6.relationDegree(n9));
		System.out.println(n14.relationDegree(n6));
		System.out.println(n6.relationDegree(numbersRoot));
	}

}
