
public class Request {
	protected String destination;
	public void setDestination(String dest) {
		this.destination = dest;
	}
	public String getDestination() {
		return this.destination;
	}
	
	protected TDate arrivalTime;
	protected TTime arrivalTime2;
	public TTime getArrivalTime() {
		return this.arrivalTime;
	}
	public TTime getArrivalTime2() {
		return this.arrivalTime2;
	}
	
	public Request(String dest, String time){
		this.destination = dest;
		this.arrivalTime = new TDate(time);
		this.arrivalTime2 = new TTime(this.arrivalTime.getHours() * 60 + this.arrivalTime.getMinutes());
	}
	
	public String toString() {
		return "Запрос: " + this.destination + " " + this.arrivalTime;
	}
}
