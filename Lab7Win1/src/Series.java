
public abstract class Series {
	public int size, base, q;
	
	public Series() {
		this.base = 0;
		this.q = 0;
		this.size = 0;
	}
	
	public abstract int getElement(int j);
	
	public int sum(){
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += this.getElement(i);
		}
		return sum;
	}
	
	public String toString() {
		String sum = "";
		for(int i = 0; i < size; i++) {
			sum += this.getElement(i);
			sum += "  ";
		}
		return sum;
	}
	
	public void saveTo() {
		
	}
}
