import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.Serializable;

public class Station implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	public String getName() {
		return this.name;
	}
	
	private List<Train> trains = new ArrayList<Train>();
	public Train[] getTrains() {
		Train[] stockArr = new Train[trains.size()];
		return this.trains.toArray(stockArr);
	}

	public void addTrain(Train tr) {
		this.trains.add(tr);
	}
	
	public Station(String name, Train[] trains) {
		this.name = name;
		this.trains = Arrays.asList(trains);
	}
	
	public Station(String name) {
		this.name = name;
	}

	public void setTrains(Train[] tr) {
		this.trains.clear();
		for(int i = 0; i < tr.length; i++) {
			this.trains.add(tr[i]);
		}
	}
}
