import java.util.StringTokenizer;

public class TDate extends TTime{
	private static final long serialVersionUID = 1L;
	
	private String date;
	
	public String getDate(){
		return this.date;
	}
	
	public String toString() {
		String s = this.date + " " + this.getHours() + ":" + this.getMinutes();
		if(this.getMinutes() == 0) {
			s += "0";
		}
		return s;
	}
	
	public TDate(String date) throws NumberFormatException {
		StringTokenizer strtok = new StringTokenizer(date, " :");
		this.date = strtok.nextToken();
		this.min = Integer.parseInt(strtok.nextToken()) * 60;
		this.min += Integer.parseInt(strtok.nextToken());
	}
	
	public TDate() {
		super();
	}

	public TDate add(TTime t) {
		super.add(t);
		return this;
	}
}
