import java.io.Serializable;

public class Train implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int number;
	private TTime start;
	public int getNumber() {
		return this.number;
	}
	
	private Route route;
	public Route getRoute() {
		return this.route;
	}
	public void setRoute(Route r) {
		this.route = r;
	}

	public Train() {
		number = 0;
	}
	
	public Train(int number, Route route, String start) {
		this.number = number;
		this.route = route;
		this.start = new TTime(start);
	}
	
	public String toString() {
		return "Поезд №" + this.number + " отправляется со станции 'Вокзал' в " + this.start;
	}

	public void setStart(TTime start) {
		this.start = start;
	}

	public TTime getStart() {
		TTime t = new TTime(this.start.getMinutes() + 60 * this.start.getHours());
		return t;
	}
}
