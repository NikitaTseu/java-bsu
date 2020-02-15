import java.util.StringTokenizer;

public class Zver extends Animal{
	private final int MASS_KOEF = 2;
	private String food;
	public Zver(String name, String place, String food) {
		super(name, place);
		this.food = food;
	}
	
	public int countMass() {
		StringTokenizer strtok = new StringTokenizer(food, " ");
		return strtok.countTokens() * MASS_KOEF;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "Zver [name=" + name + ", place=" + place +  ", food=" + food + ", mass = " + this.countMass() + "]";
	}
	
	
}
