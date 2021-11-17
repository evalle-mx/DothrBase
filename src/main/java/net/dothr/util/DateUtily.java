package net.dothr.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DateUtily {
	
	static final Logger log4j = LogManager.getLogger( DateUtily.class );

	
	
	/**
	 * Regrea un objeto Calendar
	 * @param date
	 * @return
	 */
	public static Calendar getCalendar(){				 		
		 Calendar cal=Calendar.getInstance(Constante.TIMEZONE, Constante.LOCALE);
		 return cal;
	}
	
	
	/**
	 * Regresa la fecha actual 
	 * @return Date
	 */
	public static Date getToday(){		
		return getCalendar().getTime();
	}
	/**
	 * Regresa una fecha dada, en un string, dependiendo del formato
	 * @param fecha, fecha a convertir
	 * @param pattern, formato asigando
	 * @return la fecha en string
	 */
	public static String date2String(Date fecha, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(fecha);
	}
}
