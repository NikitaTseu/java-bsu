import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Connector<T> {
	private String filename;

	public Connector( String filename ) {
		this.filename = filename;
	}

	public void write(T[] map) throws IOException {
		FileOutputStream fos = new FileOutputStream (filename);
		try ( ObjectOutputStream oos = new ObjectOutputStream( fos )) {
			oos.writeInt( map.length );
			for ( int i = 0; i < map.length; i++) {
				oos.writeObject( map[i] );		
			}
			oos.flush();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> read() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(filename);
		try ( ObjectInputStream oin = new ObjectInputStream(fis)) {
			int length = oin.readInt();
			List<T> list = new ArrayList<T>();
			for ( int i = 0; i < length; i++ ) {
				list.add((T) oin.readObject());
			}
			return list;	
		}
	}
}
