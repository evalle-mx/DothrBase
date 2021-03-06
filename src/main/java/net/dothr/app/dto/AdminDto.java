package net.dothr.app.dto;

import java.util.List;

public class AdminDto extends ComunDto {

	private String descripcion;
	private String nombreEmisor;
	private String hostName;
	private String hostAddress;
	private String fecha;
	private List<String> sinCambioPersonas;
	
	public AdminDto(){}
	
	public AdminDto(String modo,String descripcion){
		this.descripcion=descripcion;
		this.setModo(modo);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getNombreEmisor() {
		return nombreEmisor;
	}

	public void setNombreEmisor(String nombreEmisor) {
		this.nombreEmisor = nombreEmisor;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHostAddress() {
		return hostAddress;
	}

	public void setHostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public List<String> getSinCambioPersonas() {
		return sinCambioPersonas;
	}

	public void setSinCambioPersonas(List<String> sinCambioPersonas) {
		this.sinCambioPersonas = sinCambioPersonas;
	}
}
