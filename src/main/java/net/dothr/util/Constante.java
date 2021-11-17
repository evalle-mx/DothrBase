package net.dothr.util;

import java.util.Locale;
import java.util.TimeZone;

public abstract class Constante {
	
	
	public final static String ERROR_CODE_SYSTEM = "000"; //TODO verificar con que valida este codigo
	
	
	public final static int FATAL_LENGHT = 5000;


	public final static byte MODO_ERROR_FATAL = 1;
	
	/*  Date Management and DateUtily  *** */
	public final static String DATE_FORMAT = "yyyy-MM-dd";	
	public final static String HOUR_FORMAT_JAVA = "HH:mm:ss";	
	public final static String DATE_FORMAT_JAVA = DATE_FORMAT+" "+HOUR_FORMAT_JAVA;	
	
	public static TimeZone TIMEZONE = TimeZone.getTimeZone("Mexico/General");
	public static Locale LOCALE = new Locale("es","MX");
	public static final String DEFAULT_PATTERN_DATE = "dd/MM/yyyy";
	
	
	
	/* CLAVE EN TABLA DE NOTIFICACION ??? TODO desacoplar esta estupidez  */
	public final static String NOTIF_CLAVE_EVENTO_ERROR_FATAL="ERROR_FATAL";
	
	
	/* ****  REST-REMOTE ENDPOINTS  ********** */
	public final static String URI_NOTIFY_PROG="/module/notifyProg";
	
	
	/* ****** METHODS ********* */
	public final static String METHOD_UPDATE="/update";
	public final static String METHOD_MULTIPLE_UPDATE="/updmultiple";
	public final static String METHOD_RELOAD="/reload";
	public final static String METHOD_CREATE="/create";
	public final static String METHOD_RECOVERY_MAIL="/recovery";
	public final static String METHOD_RESTORE_PWD="/restore";
	public final static String METHOD_UPD_PWD="/updpwd";
	public final static String METHOD_READ="/read";
	public final static String METHOD_DELETE="/delete";
	public final static String METHOD_GET="/get";
	public final static String METHOD_DATA_CONF="/dataconf";
	public final static String METHOD_EXISTS="/exists";
	public final static String METHOD_INITIAL="/initial";

}
