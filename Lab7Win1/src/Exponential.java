
public class Exponential extends Series {
	
	public Exponential(int base, int q, int size){
		super();
		this.base = base;
		this.q = q;
		this.size = size;
	}
	
	public int getElement(int j) {
		int elem = base;
		for(int i = 0; i < j; i++) {
			elem *= q;
		}
		return elem;
	}
}
