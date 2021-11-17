package net.dothr.app.dto;

import org.springframework.http.HttpStatus;

public class MensajeDto extends ComunDto {

	private String name;
	private String value;
	
	public MensajeDto(){}
	public MensajeDto(String name,String value,String code,String type,String message){
		this.setName(name);
		this.setValue(value);
		this.setCode(code);
		this.setType(type);
		this.setMessage(message);
	}
	
	public MensajeDto(String name,String value, String messages){
		this.setName(name);
		this.setValue(value);		
		this.setMessages(messages);
	}
	
	public void setCode(HttpStatus httpStatus) {
		this.setCode( String.valueOf(httpStatus) );
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
