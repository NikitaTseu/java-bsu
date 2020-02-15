
public abstract class Auto implements Comparable<Auto>{
	protected String name, color;
	protected Fuel fuel;
	
	public Auto() {
		this.name = "";
		this.color = "";
		this.fuel = null;
	}
	
	public Auto(String name, String color, Fuel fuel) {
		this.name = name;
		this.color = color;
		this.fuel = fuel;
	}
	
	public void print() {
		System.out.println(this);
	}
	
	public String toString() {
		return name + ", " + color + ",  fuel type:" + fuel;
	}

	public int compareTo(Auto p) {
		if(this.name.compareTo(p.name) > 0) {
			return 1;
		}
		else {
			if(this.name.compareTo(p.name) == 0) {
				if(this.fuel.compareTo(p.fuel) < 0) {
					return 1;
				}
				else {
					if(this.fuel.compareTo(p.fuel) > 0) {
						return -1;
					}
					else {
						return 0;
					}
				}
			}
			else {
				return -1;
			}
		}
	}

	public abstract boolean equalTo(Auto p);
}
