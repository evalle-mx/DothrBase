package net.dothr.util;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.http.HttpStatus;

import com.google.gson.Gson;

import net.dothr.app.dto.MensajeDto;

public class UtilsTce {
	
	
	/**
	 * Valida por medio de apache Commons si la cadena es numerica
	 * @param stNumber
	 * @return
	 */
	public static boolean isNumeric(String stNumber){
		return NumberUtils.isCreatable(stNumber);
				//.isNumber(stNumber);
	}
	
	/**
	 * Obtiene una cadena con formato Json en base a los parametros ingresados,
	 * en caso de parametro "errores" != null, concatena, dejando el detalle anterior
	 * al final de la cadena
	 * @param code
	 * @param type
	 * @param eMessage
	 * @return
	 */
	public static String getJsonMessageGson(String errores, Object object ) {
		StringBuilder sb=new StringBuilder("[");
		return (errores == null || errores.equals("")) ? 
			 		sb.append(new Gson().toJson(object)).append("]").toString():
			 		sb.append(new Gson().toJson(object)).append(",").
			 		append(errores.substring(1, errores.length())).toString();
	}
	
	/**
	 * Regresa un mensaje de Notificacion (Warning) indicando que el metodo no esta habilitado
	 * @param optMethodName
	 * @return
	 */
	public static String methodNotImplemented(String optMethodName) {		
		return getJsonMessageGson(null, 
				new MensajeDto(null,null,
						String.valueOf(HttpStatus.OK),
						Mensaje.TYPE_WARNING,
						Mensaje.DISABLED_METHOD +(optMethodName!=null?": "+optMethodName:"")
						));
	}

}
