import java.util.StringTokenizer;

public class Bus extends Auto{
	private int seats, doors;
	
	public Bus() {
		super();
		this.seats = 0;
		this.doors = 0;
	}

	public Bus(String name, String color, Fuel fuel, int seats, int doors) {
		super(name, color, fuel);
		this.seats = seats;
		this.doors = doors;
	}
	
	public String toString(){
		return super.toString() + ", " + this.seats + " seats, " + this.doors + " doors";
	}

	public Bus(String s) {
		StringTokenizer st = new StringTokenizer(s, ",");
		
		this.name = st.nextToken();
		this.color = st.nextToken();
		this.fuel = Fuel.valueOf(st.nextToken());
		this.seats = new Integer(st.nextToken());
		this.doors = new Integer(st.nextToken());
	}

	public boolean equalTo(Auto p) {
		Bus p1 = (Bus)p;
		return (this.name.equals(p.name) &&
				this.color.equals(p.color) &&
				this.fuel.equals(p.fuel) &&
				this.seats == p1.seats &&
				this.doors == p1.doors);
	}
}
