package net.dothr.app.exc;

/**
 * WHY? I have no f.... idea
 * @author Goyo
 *
 */
@SuppressWarnings("serial")
public class FileException extends Exception {

	public FileException(String msg) {
		super(msg);
	}
	
	public FileException(Throwable causa) {
		super(causa);
	}
	
	public FileException(String mensaje, Throwable causa) {
		super(mensaje,causa);
	}
}
