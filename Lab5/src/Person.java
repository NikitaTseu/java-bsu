
public class Person implements Comparable<Person>{
	public String name;
	public Integer age;
	
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name + "-" + age;
	}
	
	public int compareTo(Person p) {
		if(this.age < p.age) {
			return -1;
		}
		else {
			if(this.age == p.age) {
				return 0;
			}
			else {
				return 1;
			}
		}
	}
}
