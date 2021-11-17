package net.dothr.app.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
/**
 * Atomic/Base DTO (Dto elemental del que heredan los otros)
 * @author evalle
 *
 */
public class DothrDto {
	private String code;
	private String type;
	private String message;
	//private String messages;
	private String auxiliar;

	public DothrDto() { }
	
	public DothrDto(String code, String type, String message) { 
		this.code=code;
		this.type=type;
		this.message=message;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
//	public String getMessages() {
//		return messages;
//	}
//	public void setMessages(String messages) {
//		this.messages = messages;
//	}
	public String toString() {
        return ReflectionToStringBuilder.toString(this).replace("=<null>", "=null");
    }

	public String getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(String auxiliar) {
		this.auxiliar = auxiliar;
	}
}
