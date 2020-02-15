import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyContainer<T extends Auto>{
	List<T> list;
	
	public MyContainer(){
		this.list = new ArrayList<T>();
	}
	
	public List<T> getList(){
		return this.list;
	}

	public void add(T elem) {
		this.list.add(elem);
	}

	public boolean isEmpty() {
		return this.list.isEmpty();
	}
	
	public void clear() {
		this.list.clear();
	}

	public void sort() {
		Collections.sort(this.list);
	}
	
	public T max() throws Exception{
		if(this.isEmpty()) {
			throw new Exception("Error! Container is empty.");
		}
		else {
			T curmax = list.get(0);
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).compareTo(curmax) > 0) {
					curmax = list.get(i);
				}
			}
			return curmax;
		}
	}

	public void print() {
		for (int i = 0; i < list.size(); i++) {
			this.list.get(i).print();
		}
	}
	
	public int count(T elem) {
		int counter = 0;
		for(int i = 0; i < this.list.size(); i++) {
			if (elem.equalTo(this.list.get(i))) {
				counter++;
			}
		}
		return counter;
	}

	public T binarySearch(T aut){
		this.sort();
        return this.list.get(Collections.binarySearch(this.list, aut));
    }
}
