import java.util.StringTokenizer;

public class Car extends Auto{
	private Material material;
	
	public Car() {
		super();
		this.material = null;
	}

	public Car(String name, String color, Fuel fuel, Material material) {
		super(name, color, fuel);
		this.material = material;
	}
	
	public String toString(){
		return super.toString() + ", material:" + this.material;
	}

	public Car(String s) {
		StringTokenizer st = new StringTokenizer(s,",");
		
		this.name = st.nextToken();
		this.color = st.nextToken();
		this.fuel = Fuel.valueOf(st.nextToken());
		this.material = Material.valueOf(st.nextToken());
	}
	
	public boolean equalTo(Auto p) {
		Car p1 = (Car)p;
		return (this.name.equals(p.name) &&
				this.color.equals(p.color) &&
				this.fuel.equals(p.fuel) &&
				this.material.equals(p1.material));
	}
}
