package net.dothr.app.serv.impl;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.google.gson.Gson;

import net.dothr.app.dao.UserDao;
import net.dothr.app.dto.AdminDto;
import net.dothr.app.dto.MensajeDto;
import net.dothr.app.dto.MenuDto;
import net.dothr.app.dto.aux.UsuarioDto;
import net.dothr.app.serv.AdminService;
import net.dothr.util.Constante;
import net.dothr.util.Mensaje;
import net.dothr.util.UtilsTce;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {
	
	static final Logger log4j = LogManager.getLogger( AdminServiceImpl.class );
	
	private JSONObject jsonObject = null;
	private final static int F_ADMIN = 18;	
	private boolean errorFilter = false;
	
	@Inject
	private Gson gson;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public String setAdmin(AdminDto admindto) throws Exception {
		admindto =(AdminDto) filtros( admindto, F_ADMIN );
		log4j.debug("setAdmin() -> getModo="+admindto.getModo()+
				" getDescripcion="+admindto.getDescripcion());
		if(admindto.getCode() == null && admindto.getMessage() == null){	
			
			
			//si hay error fatal
			if(Byte.parseByte(admindto.getModo()) == Constante.MODO_ERROR_FATAL){
				String respNotf=Mensaje.OK_JSON;
				
				//Se manda el mensaje por correo
					
				jsonObject = new JSONObject();
				jsonObject.put("claveEvento",Constante.NOTIF_CLAVE_EVENTO_ERROR_FATAL);
				jsonObject.put("comentario",admindto.getDescripcion());
				jsonObject.put("nombreEmisor",admindto.getNombreEmisor());
				jsonObject.put("hostName",admindto.getHostName());
				jsonObject.put("hostAddress",admindto.getHostAddress());
				jsonObject.put("fecha",admindto.getFecha());
				
				/* SE CREA OBJETO NOTIFICACIÓN Y SE ENVIA A OPERATIONAL PARA SER CREADA */
//				//TODO CREAR LA NOTIFICACION Y PROCESARLA EN ESTA APP, NO TIENE SENTIDO ENVIARLO...
//				respNotf= (String)restJsonService.serviceRESTJson(gson.toJson(new NotificacionProgramadaDto(
//																(String)jsonObject.get("claveEvento"),
//																jsonObject.toString(),null)),
//																new StringBuilder(Constante.URI_NOTIFY_PROG).
//																append(Constante.METHOD_CREATE).toString());
//				log4j.debug("<setAdmin> ...Se mando notificación -> respuesta_Notif="+respNotf);
				respNotf = Mensaje.OK_JSON;
				
				//hubo problemas en notificar
				if(!respNotf.equals(Mensaje.OK_JSON)){
//					log4j.error("Error al crear notificacion para el evento: "+
//							Constante.NOTIF_CLAVE_EVENTO_ERROR_FATAL +
//							" Descripcion: "+admindto.getDescripcion()+
//							" NombreEmisor: "+admindto.getNombreEmisor()+
//							" HostName: "+admindto.getHostName()+
//							" HostAddress: "+admindto.getHostAddress()+
//							" Fecha: "+admindto.getFecha()+
//							" resp= "+respNotf);
					log4j.error("Error al crear notificacion para el evento: "+ jsonObject.toString() );
					admindto.setMessages(respNotf);
				}
			
				//Todo bien
				admindto.setMessages(respNotf);				
			}
		}else{
			if(admindto.getMessages() == null)
				admindto.setMessages(UtilsTce.getJsonMessageGson(null, 
										new MensajeDto(null,null,
										admindto.getCode(),
										admindto.getType(),
										admindto.getMessage())));
			else
				admindto.setMessages(UtilsTce.getJsonMessageGson(null, 
											new MensajeDto(null,null,
											Mensaje.SERVICE_CODE_006,
											Mensaje.TYPE_FATAL,
											Mensaje.ERROR_DEFAULT_MSG)));
		}	
		return admindto.getMessages();
	}
	
	

	@Override
	public String menu(MenuDto menuDto) {		
		return UtilsTce.methodNotImplemented("menu");
	}
	/*  ***************  METODOS NUEVOS/TEMPORALES  *********** */
	
	@Override
	public List<UsuarioDto> getUsers(UsuarioDto userDto) throws IOException{
		Long idEstatusInscripcion = null,idRol =null;
		
		if(userDto.getIdEstatusInscripcion()!=null) {
			idEstatusInscripcion = Long.parseLong(userDto.getIdEstatusInscripcion());
		}
		if(userDto.getIdRol()!=null) {
			idRol = Long.parseLong(userDto.getIdRol());
		}
		
		return userDao.getUsers(idEstatusInscripcion, idRol);
	}
	
	/*  ****************************************************** */
	/*  **************   FILTROS / Validacion    ************* */
	/*  ****************************************************** */
	/**
	 * Filtros para el servicio
	 * @param menuDto
	 * @param funcion
	 * @return
	 */
	private Object filtros(Object object, int funcion){
		errorFilter=false;
		
		 if(object instanceof AdminDto){
			  AdminDto admindto= (AdminDto)object;
			  
			  if(funcion == F_ADMIN && 
				 admindto.getModo() == null ){
				  log4j.debug("<filtros> Modo es requerido ");
				  errorFilter=true;
			  }
				 
			  if(errorFilter){
					 admindto=new AdminDto();
					 admindto.setMessage(Mensaje.ERROR_DEFAULT_MSG);
					 admindto.setType(Mensaje.TYPE_FATAL);
					 admindto.setCode(Mensaje.SERVICE_CODE_006);
				 } 
			  return admindto;
//		 }else if(object instanceof MenuDto){
//			 MenuDto menuDto= (MenuDto)object;
//				  
//			 if(menuDto.getIdEmpresaConf() == null){
//				 log4j.debug("<filtros> IdEmpresaConf es requerido ");
//				 errorFilter=true;
//			 }
//			 
//			 if(funcion == Constante.F_MENU && 
//				menuDto.getIdPersona() == null){
//				 log4j.debug("<filtros> IdPersona es requerido ");
//				 errorFilter=true;
//			  }
//			 
//			 if(errorFilter){
//				 menuDto=new MenuDto();
//				 menuDto.setMessage(Mensaje.ERROR_DEFAULT_MSG);
//				 menuDto.setType(Mensaje.TYPE_FATAL);
//				 menuDto.setCode(Mensaje.SERVICE_CODE_006);
//			 }
//			 return menuDto;			 
		 }else {
			 return object;
		 }
	}

}
