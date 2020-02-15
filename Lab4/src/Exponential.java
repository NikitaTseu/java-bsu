import java.util.Iterator;
import java.util.StringTokenizer;

public class Exponential extends Series implements Comparable<Exponential>, Iterator<String>{
	public double base, q;
	public int size, id;
	// q - знаменатель геометрической прогресии
	// id - индекс итератора
	
	public static final String[] fieldnames = {"base", "q", "size"};

	public static class ArgException extends Exception {
		private static final long serialVersionUID = 1L;

		ArgException(String arg) {
			super("Invalid argument: " + arg);
		}
	}


	public Exponential(double _base, double _q, int _size) throws ArgException {
		if (_size < 0) {
			throw new ArgException(Integer.toString(_size));
		} else {
			base = _base;
			q = _q;
			size = _size;
		}
	}

	// формат строки для инициализации прогресии: (основание;знаменатель;кол-во членов)
	public Exponential(String s) throws ArgException {
		StringTokenizer strtok = new StringTokenizer(s, "(;)");
		if(strtok.countTokens() != 3) {
			throw new ArgException(s);
		}
		else {
			base = Double.parseDouble(strtok.nextToken());
			q = Double.parseDouble(strtok.nextToken());
			size = Integer.parseInt(strtok.nextToken());
		}
	}

	public String toString() {
		String s = "(" + base + ";" + q + ";" + size + ")";
		return s;
	}

	public double sum() {
		double sum = 0;
		double curelem = base;
		for (int i = 0; i < size; i++) {
			sum += curelem;
			curelem *= q;
		}
		return sum;
	}

	public double getElement(int j) throws ArgException {
		if (j >= size) {
			throw new ArgException(Integer.toString(j));
		}
		double elem = base;
		for (int i = 0; i < j; i++) {
			elem *= q;
		}
		return elem;
	}

	public int compareTo(Exponential ex) {
		switch(id) {
		case 0:
		{
			if (this.base < ex.base) {
				return -1;
			}
			if (this.base > ex.base) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		case 1:
		{
			if (this.q < ex.q) {
				return -1;
			}
			if (this.q > ex.q) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		case 2:
		{
			if (this.size < ex.size) {
				return -1;
			}
			if (this.size > ex.size) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		default:
		{
			return 0;
		}
		}
	}


	public void setFieldToComparison(String s) throws ArgException {
		boolean correct = false;
		for(int i = 0; i < fieldnames.length; i++) {
			if (s.equals(fieldnames[i])) {
				id = i;
				correct = true;			}
		}
		if(!correct) {
			throw new ArgException(s);
		}
	}

	public void resetIterator() {
		id = 0;
	}
	
	public boolean hasNext() {
		return id >= fieldnames.length ? false: true;
	}

	public String next() {
		if(id < fieldnames.length) {
			return fieldnames[id++];
		}
		else {
			return null;
		}
	}

	public String getCurrentFieldname() {
		return fieldnames[id];
	}
}
