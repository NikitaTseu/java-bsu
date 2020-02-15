import java.io.Serializable;

public class Route implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private TTime[] timeList;
	private int[] priceList;
	private Station[] stList;
	
	public Route(TTime[] timeList, int[] priceList, Station[] stList) {
		this.timeList = timeList;
		this.priceList = priceList;
		this.stList = stList;
	}

	public boolean includeStation(String name) {
		boolean ans = false;
		for(int i = 0; i < stList.length; i++) {
			if (stList[i].getName() == name) {
				ans = true;
			}
		}
		return ans;
	}
	
	public int getPrice(String dest) throws Exception{
		if (this.includeStation(dest)) {
			int i = 0;
			int price = 0;
			
			while(stList[i].getName() != dest) {
				price += priceList[i];
				i++;
			}
			price += priceList[i];
			return price;
		}
		else {
			throw new Exception("Error! This route doesn't include the station " + dest);
		}
	}
	
	public TTime getTime(String dest) throws Exception{
		if (this.includeStation(dest)) {
			int i = 0;
			TTime time = new TTime();
			
			while(stList[i].getName() != dest) {
				time.add(timeList[i]);
				i++;
			}
			time.add(timeList[i]);
			return time;
		}
		else {
			throw new Exception("Error! This route doesn't include the station " + dest);
		}
	}

}
