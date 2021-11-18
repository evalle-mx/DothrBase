package net.dothr.web;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
//import org.hibernate.PropertyValueException;
//import org.hibernate.exception.ConstraintViolationException;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.jdbc.UncategorizedSQLException;
//import org.springframework.transaction.CannotCreateTransactionException;
//import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import net.dothr.app.dto.AdminDto;
import net.dothr.app.dto.DothrDto;
import net.dothr.app.dto.MensajeDto;
import net.dothr.app.exc.DothrSystemException;
import net.dothr.app.exc.FileException;
import net.dothr.app.serv.AdminService;
import net.dothr.app.serv._DemoService;
import net.dothr.util.Constante;
import net.dothr.util.DateUtily;
import net.dothr.util.Mensaje;
import net.dothr.util.UtilsTce;

public abstract class AbstractCtrlRest {

	private static final Logger log4j = LoggerFactory.getLogger(AbstractCtrlRest.class);
	
	final String DIVISOR_HTTP=" -HTTP- ";
	final int HTTP_ERROR_CLIENT_4xx_INI=400;
	final int HTTP_ERROR_CLIENT_4xx_FIN=431;	
	
	private List<MensajeDto> lsMensajeDto;
	private AdminDto admindto;
	
	@Inject
	Gson gson;
	
	@Autowired
	protected _DemoService service;
	
	@Autowired
	private AdminService adminService;
	
	private MensajeDto mensajeDto=new MensajeDto(null,null,
			String.valueOf(HttpStatus.BAD_REQUEST),
			Mensaje.TYPE_FATAL,
			null);
	
	@GetMapping( path = "/ping")
	public String ping(@RequestBody DothrDto dto ) throws Exception {
		//System.out.println("<AbstractCtrlRest.ping>");
		Object response =service.ping(dto);	//gson.fromJson(json, ComunDto.class));
		return (response instanceof String) ? (String)response:gson.toJson(response);
	}
	
	/**
	 * Maneja excepciones de tipo DothrSystemException
	 * @param e, objeto de la excepcion correspondiente
	 * @return un mensaje JSON
	 */
	@ExceptionHandler(DothrSystemException.class)
	public @ResponseBody String handleDothrSystemException(final DothrSystemException e)
	{
		//log4j.error("SystemTCEException ERROR: "+e.toString(), e);
		log4j.error("DothrSystemException ERROR: "+e.toString(), e);
		e.printStackTrace();
	    return mensajeErrorPolitica(e.getMessage()); 
	}
	
	
//	/**
//	 * Maneja excepciones de tipo GenericJDBCException
//	 * @param e, objeto de la excepcion correspondiente
//	 * @return un mensaje JSON
//	 */
//	@ExceptionHandler(PropertyValueException.class)
//	public @ResponseBody String handlePropertyValueException(final PropertyValueException e)
//	{
//		log4j.error("&---&  handlePropertyValueException ERROR: "+e.toString(), e);
//		e.printStackTrace();
//	    return mensajeErrorSistema(e); 
//	}
		
//	/**
//	 * Maneja excepciones de tipo UncategorizedSQLException
//	 * @param e, objeto de la excepcion correspondiente
//	 * @return un mensaje JSON
//	 */
//	@ExceptionHandler(UncategorizedSQLException.class)
//	public @ResponseBody String handleUncategorizedSQLException(final UncategorizedSQLException e)
//	{
//		log4j.error("&---&  UncategorizedSQLException ERROR: "+e.getSQLException().getMessage()+" --(bueno) "+
//				e.getSQLException().getErrorCode(), e);
//		e.printStackTrace();
//	    return mensajeErrorSistema(e); 
//	}
	
//	/**
//	 * Maneja excepciones de tipo DataIntegrityViolationException
//	 * @param e, objeto de la excepcion correspondiente
//	 * @return un mensaje JSON
//	 */
//	@ExceptionHandler(DataIntegrityViolationException.class)
//	public @ResponseBody String handleDataIntegrityViolationException(final DataIntegrityViolationException e)
//	{
//		log4j.error("&---&  DataIntegrityViolationException ERROR: "+e.getMostSpecificCause().getMessage(), e);
//		e.printStackTrace();
//	    return mensajeErrorSistema(e); 
//	}
	
//	/**
//	 * Maneja excepciones de tipo ConstraintViolationException
//	 * @param e, objeto de la excepcion correspondiente
//	 * @return un mensaje JSON
//	 */
//	@ExceptionHandler(ConstraintViolationException.class)
//	public @ResponseBody String handleConstraintViolationException(final ConstraintViolationException e)
//	{
//		log4j.error("&---& ConstraintViolationException ERROR:"+e.getSQLState()+" -- "+e.getSQLException().getErrorCode()+
//				" --"+e.getSQLException().getMessage(), e);
//		e.printStackTrace();
//	    return mensajeErrorSistema(e); 
//	}
	
//	/**
//	 * Maneja excepciones de tipo JsonSyntaxException
//	 * @param e, objeto de la excepcion correspondiente
//	 * @return un mensaje JSON
//	 */
//	@ExceptionHandler(JsonSyntaxException.class)
//	public @ResponseBody String handleJsonSyntaxException(final JsonSyntaxException e)
//	{
//		log4j.error("&---& JsonSyntaxException ERROR: "+e.toString(), e);
//		e.printStackTrace();
//	    return mensajeErrorSistema(e); 
//	}
	
//	/**
//	 * Maneja excepciones de tipo JsonSyntaxException
//	 * @param e, objeto de la excepcion correspondiente
//	 * @return un mensaje JSON
//	 */
//	@ExceptionHandler(NumberFormatException.class)
//	public @ResponseBody String handleNumberFormatException(final NumberFormatException e)
//	{
//		log4j.error("&---& NumberFormatException ERROR: "+e.toString(), e);
//		e.printStackTrace();
//	    return mensajeErrorSistema(e); 
//	}
	
	/**
	 * Maneja excepciones de tipo ClassNotFoundException
	 * @param e, objeto de la excepcion correspondiente
	 * @return un mensaje JSON
	 */
	@ExceptionHandler(ClassNotFoundException.class)
	public @ResponseBody String handleClassNotFoundException(final ClassNotFoundException e)
	{
		log4j.error("&---& ClassNotFoundException ERROR: "+e.toString(), e);
		e.printStackTrace();
	    return mensajeErrorSistema(e); 
	}
	
//	/**
//	 * Maneja excepciones de tipo CannotCreateTransactionException
//	 * @param e, objeto de la excepcion correspondiente
//	 * @return un mensaje JSON
//	 */
//	@ExceptionHandler(CannotCreateTransactionException.class)
//	public @ResponseBody String handleCannotCreateTransactionException(final CannotCreateTransactionException e)
//	{
//		log4j.error("&---& CannotCreateTransactionException ERROR: "+e.toString(), e);
//		e.printStackTrace();
//	    return mensajeErrorSistema(e); 
//	}
	
	/**
	 * Maneja excepciones de tipo CannotCreateTransactionException
	 * @param e, objeto de la excepcion correspondiente
	 * @return un mensaje JSON
	 */
	@ExceptionHandler(FileException.class)
	public @ResponseBody String handleFileException(final FileException e)
	{
		log4j.error("&---& FileException ERROR: "+e.toString(), e);
		e.printStackTrace();
	    return mensajeErrorSistema(e); 
	}
	
	/**
	 * Maneja excepciones de tipo CannotCreateTransactionException
	 * @param e, objeto de la excepcion correspondiente
	 * @return un mensaje JSON
	 */
	@ExceptionHandler(IOException.class)
	public @ResponseBody String handleIOException(final IOException e)
	{
		log4j.error("<IOException> ERROR: "+e.toString(), e);
		e.printStackTrace();
		MensajeDto dtoMsg = new MensajeDto();
		//dtoMsg.setCode(Mensaje.CODE_HTTP_403);
		dtoMsg.setCode( HttpStatus.FORBIDDEN );
		dtoMsg.setType(Mensaje.TYPE_FATAL);
		dtoMsg.setMessage(Mensaje.ERROR_IO);
	    return UtilsTce.getJsonMessageGson(null,dtoMsg); 
	}
	
	
	/**
	 * Maneja cualquier otra excepcion
	 * @param e, objeto de la excepcion correspondiente
	 * @return un mensaje JSON
	 */
	@ExceptionHandler(Exception.class)
	public @ResponseBody String Exception(final Exception e)
	{
	    log4j.error("<ErrorMsgAdapter.Exception> ERROR: "+e.toString(), e);
		e.printStackTrace();
	    return mensajeErrorSistema(e); 
	}
	
	
	
	/* **********************************************************  */
	/**
	 * Crea un mensaje de error si hay falla en el sistema
	 * @return mensaje de error en JSON
	 */
	private String mensajeErrorSistema(Exception e){
		
		//mensajeDto.setCode(Mensaje.SERVICE_CODE_000);
		mensajeDto.setCode(Mensaje.CODE_SYSTEM_ERROR);
		mensajeDto.setMessage(ExceptionUtils.getStackTrace(e).substring(0,
								Constante.FATAL_LENGHT).concat(" ..."));
		
		//se envía correo a los admin
		return enviarCorreo(mensajeDto);
		
	}
	/**
	 * Crea un mensaje de error en general, para las politicas de negocio
	 * @return mensaje de error en JSON
	 */
	@SuppressWarnings("serial")
	private String mensajeErrorPolitica(String mensaje){
		 log4j.error("mensajeErrorPolitica() -> mensaje: "+mensaje);
		if(mensaje != null){
			
			//divisor tipo HTTP 
			if(mensaje.contains(DIVISOR_HTTP)){
				String[] arMensaje= mensaje.split(DIVISOR_HTTP);
				log4j.debug("mensajeErrorPolitica() -> arMensaje[0]: "+arMensaje[0]+
						" arMensaje[1]: "+arMensaje[1]);
				
				//es numerico
				if(UtilsTce.isNumeric(arMensaje[0])){ 
					  //HTTP 4xx
					 if (HTTP_ERROR_CLIENT_4xx_INI <= Integer.parseInt(arMensaje[0]) &&
					    Integer.parseInt(arMensaje[0]) < HTTP_ERROR_CLIENT_4xx_FIN ){
					    	mensajeDto.setCode(HttpStatus.SERVICE_UNAVAILABLE);		//Mensaje.SERVICE_CODE_200); ?porque 200 si es error??
					    	mensajeDto.setMessage(Mensaje.FATAL_OPERATIONAL_STRUCTURED);
					   }
				}				
			}else {
				lsMensajeDto=gson.fromJson(mensaje, new TypeToken<List<MensajeDto>>(){}.getType());
				 log4j.error("mensajeErrorPolitica() -> lsMensajeDto: "+lsMensajeDto != null ? 
						 												String.valueOf(lsMensajeDto.size()):null);
				if(lsMensajeDto.size() > 0) {
					mensajeDto=lsMensajeDto.get(0);
				}
			}
		}
		//se envía correo a los admin
		return enviarCorreo(mensajeDto);		
	}
	@SuppressWarnings("finally")
	private String enviarCorreo(MensajeDto mensajeDto){
		
		try {
			admindto=new AdminDto();
			admindto.setModo(String.valueOf(Constante.MODO_ERROR_FATAL));
			admindto.setDescripcion(mensajeDto.getMessage());
			admindto.setNombreEmisor("AppTransactionalStructured");
			InetAddress address = InetAddress.getLocalHost();
			admindto.setHostAddress(address.getHostAddress());
			admindto.setHostName(address.getHostName());
			admindto.setFecha(DateUtily.date2String(DateUtily.getToday(),
											Constante.DATE_FORMAT_JAVA));
			
			
			log4j.debug("<enviarCorreo> IP Local :"+address.getHostAddress()+
					" HostName:"+address.getHostName()+
					" CanonicalHostName:"+address.getCanonicalHostName()+
					" Fecha="+admindto.getFecha());
			
			adminService.setAdmin(admindto);
		} catch (Exception e) {
			log4j.error("Error al enviar correo a los Administradores por Error Fatal: ",e);			
			e.printStackTrace();
		}finally{
			if(!mensajeDto.getCode().equals("200")) {	// 	Mensaje.SERVICE_CODE_200)){
				mensajeDto.setMessage(Mensaje.ERROR_DEFAULT_MSG);
			}
			
			return UtilsTce.getJsonMessageGson(null,mensajeDto); 
		}
		
	}
}
