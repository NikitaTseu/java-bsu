
public class ReadingFileException extends Exception {
	private static final long serialVersionUID = 1L;

	ReadingFileException(String arg) {
		super("Error! " + arg);
	}
}
