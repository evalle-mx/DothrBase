package net.dothr.app.exc;

import net.dothr.util.Constante;

//public class SystemTCEException extends Exception {
@SuppressWarnings("serial")
public class DothrSystemException extends Exception {
private String cveError = Constante.ERROR_CODE_SYSTEM;
	
	public DothrSystemException(String msg) {
		super(msg);
		
	}
	public DothrSystemException(String msg, Throwable causa) {
		super(msg,causa);
	}
	public DothrSystemException(String cveError, String msg) {
		super(msg);
		this.cveError= cveError;
	}
	public String getCveError() {
		return cveError;
	}

}
