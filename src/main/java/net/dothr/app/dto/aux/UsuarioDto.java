package net.dothr.app.dto.aux;

import net.dothr.app.dto.ComunDto;

public class UsuarioDto extends ComunDto {

	private String idEstatusInscripcion;
	private String idRol;
	private String idPersona;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String email;	
	
	private String fechaCreacion;
	private String idTipoRelacion;
	
	
	public UsuarioDto() {
	}
	/** Constructor para Json */
	public UsuarioDto(String idEstatusInscripcion, String idRol, String idPersona,
			String nombre, String apellidoPaterno, String apellidoMaterno, String email, String idTipoRelacion,  String fechaCreacion) {
		
		this.idEstatusInscripcion=idEstatusInscripcion;
		this.idRol=idRol;
		this.idPersona=idPersona;
		this.nombre=nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.email=email;
		this.idTipoRelacion=idTipoRelacion;		
		this.fechaCreacion=fechaCreacion;
	}
	

	/* **** GET/SET ***** */
	public String getIdEstatusInscripcion() {
		return idEstatusInscripcion;
	}
	public void setIdEstatusInscripcion(String idEstatusInscripcion) {
		this.idEstatusInscripcion = idEstatusInscripcion;
	}
	public String getIdRol() {
		return idRol;
	}
	public void setIdRol(String idRol) {
		this.idRol = idRol;
	}
	public String getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getIdTipoRelacion() {
		return idTipoRelacion;
	}
	public void setIdTipoRelacion(String idTipoRelacion) {
		this.idTipoRelacion = idTipoRelacion;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
}
