package net.dothr.util;

import org.springframework.http.HttpStatus;

public abstract class Mensaje {

	public final static String DISABLED_METHOD = "El metodo no esta habilitado";
	
	public final static String OK_JSON="[]";
	
	public final static String OK_DELETE="Fue borrado satisfactoriamente ";
	public final static String OK_CREATE_PERSONA="Fue creado satisfactoriamente. Por favor verificar su correo para concluir la inscripcion ";
	public final static String OK_EMAIL_SEND = "Se ha enviado un correo electrónico, verifique su bandeja de entrada";
	public final static String OK_CUOTA="Cumple la cuota";
	public final static String OK_PWD_UPDATE = "La contraseña fue modificada correctamente";
	
	public final static String WARNING_DEFAULT="Notificación del sistema";
	public final static String WARNING_PUBLICATION_MODIFICATION_INDEX = "Se modifico el valor de un indice o propiedad KO, por lo tanto se debe publicar de nuevo la posición";
	public final static String WARNING_PUBLICATION_MODIFICATION = "Se cambió una propiedad en un contexto de Publicación";
	
	public final static String ERROR_SYSTEM="Error de sistema, conectarse mas tarde";
	public final static String ERROR_DEFAULT_MSG="La construcción del mensaje no es correcta, favor de verificar la especificación correspondiente";
	public final static String ERROR_PWD_INVALID = "La contraseña ingresada no es correcta";
	public final static String ERROR_NO_CHANGE="No se realizó ningun cambio en los datos";
	public final static String ERROR_LACK_PARAMS="Es requerido definir al menos uno de los parametros de búsqueda.";
	public final static String ERROR_LACK_PARAMSAREA="Es requerido definir al menos una área de búsqueda.";
	public final static String ERROR_INVALID_DATA="Su peticion no cumple con el formato requerido.";
	
	public final static String ERROR_IO="Error de permiso/acceso a los datos, favor de verificar";
	public final static String ERROR_SUPERA_MAX="Superó el máximo de archivos permitidos";
	public final static String ERROR_EMAILING="No se pudo enviar el correo de confirmación ";
	public final static String ERROR_EMPTY = "No existen datos registrados, verifique la información proporcionada";
	public final static String ERROR_ENCRIPT = "Error al encriptar el dato: ";
	public final static String ERROR_DATACONF = "Excepcion en filtros DataConf";
	public final static String ERROR_REL_EMP_PERSONA="Relación de empresa persona ";
	public final static String ERROR_DUPLICATE = "Ya existen los datos registrados";
	public final static String ERROR_DATACONF_EMPRESAPERSONA = "No hay informacion en la tabla de EMPRESA_PARAMETRO relacionada con el Dataconf de:";
	public final static String ERROR_SOLR_SYSTEM = "Error de comunicación/interacción con el servidor Solr";
	public final static String ERROR_PUBLICATION = "No se cumplieron algunos criterios en la publicación de los datos";
	public final static String ERROR_FASES_DIAS_SECUENCIAL="La asignación de dias debe ser secuencial por orden y actividad.";
	public final static String ERROR_UNAUTHORIZED_LINKEDIN = "No autorizado para realizar la operación (Verificar Key's)";	
	public final static String ERROR_MASIVE_DUPLICATEEMAIL = "El correo electronico ya esta registrado para esta empresa";
	public final static String ERROR_ASENTAMIENTO_REQUERIDO = "No se pudo obtener Asentamiento requerido";
	public final static String ERROR_PWD_DIFERENT = "Las contraseñas nuevas no coinciden";
	public final static String ERROR_PWD_DUPLICATE = "La contraseña nueva no puede ser igual a la actual";
	public final static String ERROR_FASES_FECHA_FINAL_ANTERIOR="No se creo la fase ya que la fase anterior debe tener dias asignados";
	public final static String ERROR_HAY_POSTULANTES="la Fase del Modelo_RSC_Pos ya que existen postulantes(candidatos confirmados)";
	public final static String ERROR_EXISTEN_PERSONA_ROL = "Existen usuarios relacionados al Rol. Se necesita desasociar el Rol a los usuarios correspondientes";
	public final static String ERROR_TEXTO_LENGTH = "El texto ingresado es demasiado largo, favor de verificar";
	public final static String ERROR_OTHER_MONITOR_NOTACOMPLISH = "Es requerido que Otro(s) participante(s) complete(n) la actividad anterior";
	public final static String ERROR_PATTERN_GENERIC_PARAM="El formato de <PARAM> es incorrecto";
	public final static String ERROR_FORBIDEN_ESTADO_TRACKING = "No esta permitido modificar el estado de <EDO1> a <EDO2>";
	public final static String ERROR_REQ_COMENTARIO = "Es requerido que se escriba un comentario";
	public final static String ERROR_POSTULANT_ROLLBACK = "Únicamente monitor principal puede reintegrar al candidato";
	
	public final static String FATAL_OPERATIONAL_STRUCTURED = "Error de comunicación con OPERATIONAL, Comuniquese con el Administrador";
	
	//Tipos de mensaje
	public final static String TYPE_INFORMATION="I";
	public final static String TYPE_WARNING="W";
	public final static String TYPE_FATAL="F";
	public final static String TYPE_ERROR="E";
	//Codigos de Respuesta
	public static final String CODE_SYSTEM_ERROR = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR);
	
	
	//TODO reemplazar el nombre de los siguientes atributos (Se conservan para reducir tiempo de desarrollo)
	
	public final static String SERVICE_CODE_006="006";	// El objeto no es correcto TODO HTTP STATUS: BAD_REQUEST (400)
	
		
}
