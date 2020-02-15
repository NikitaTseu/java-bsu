import java.util.StringTokenizer;
import java.io.Serializable;

public class TTime implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int min;
	
	public TTime(int hours, int mins) {
		this.min = 60 * hours + mins;
	}
	
	public int getHours(){
		return this.min / 60;
	}
	
	public int getMinutes(){
		return this.min % 60;
	}
	
	public String toString() {
		String s = this.getHours() + ":" + this.getMinutes();
		if(this.getMinutes() == 0) {
			s += "0";
		}
		return s;
	}
	
	public TTime(String time) throws NumberFormatException {
		StringTokenizer strtok = new StringTokenizer(time, " :");
		this.min = Integer.parseInt(strtok.nextToken()) * 60;
		this.min += Integer.parseInt(strtok.nextToken());
	}
	
	public TTime(int t) {
		min = t;
	}
	
 	public TTime() {
		min = 0;
	}
	
	public TTime add(TTime t) {
		this.min += t.getMinutes() + t.getHours() * 60;
		min = min % 1440;
		return this;
	}

	public int delta(TTime t) {
		return this.min - t.getHours() * 60 - t.getMinutes();
	}
}