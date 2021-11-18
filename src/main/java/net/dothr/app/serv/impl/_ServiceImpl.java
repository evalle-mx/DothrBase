package net.dothr.app.serv.impl;

import java.lang.invoke.MethodHandles;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import net.dothr.app.exc.DothrSystemException;
import net.dothr.util.UtilsTce;

public abstract class _ServiceImpl {
	
	@Inject
	protected Gson gson;
	
	protected StringBuilder sb;
	
	public boolean errorFilter = false;
	
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	/**
	 * Respuesta Default al implementar metodos 
	 * @param methodName
	 * @return
	 */
	protected String notImplemented(String methodName ) {
		log.error("Metodo " + methodName + " No implementado, logging exception:", 
				new DothrSystemException("Metodo \"" + (methodName!=null?methodName.toUpperCase():"---") + "\" No implementado"));
		return UtilsTce.methodNotImplemented(methodName);
	}

}
