
public abstract class Animal {
	protected String name;
	protected String place;
	
	public abstract int countMass();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Animal(String name, String place) {
		super();
		this.name = name;
		this.place = place;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", place=" + place + "]";
	}
	
	
}
