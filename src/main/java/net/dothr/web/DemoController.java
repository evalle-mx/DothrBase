package net.dothr.web;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.dothr.app.dto.DothrDto;
import net.dothr.app.dto.aux.UsuarioDto;
import net.dothr.app.serv.AdminService;

@RestController
@RequestMapping("/app")
public class DemoController extends AbstractCtrlRest {
	
	static final Logger log4j = LogManager.getLogger( DemoController.class );
	
	@Autowired
	AdminService adminService;
	
	@GetMapping(path = "/aux")
	public String aux(@RequestBody DothrDto dto ) throws Exception {
		Object response =service.aux(dto);	//gson.fromJson(json, ComunDto.class));
		return (response instanceof String) ? (String)response:gson.toJson(response);
	}
	
//	@GetMapping(path = "/usuarios")
//	public List<UsuarioDto> getUsuarios(@RequestBody UsuarioDto userDto ) throws Exception {
//		List<UsuarioDto> response =adminService.getUsers(userDto); /Funciona pero regresa Null en los demas atributos
//		return response;
//	}
	@GetMapping(path = "/usuarios")
	public @ResponseBody String get(@RequestBody UsuarioDto userDto ) throws Exception  {
		Object object= adminService.getUsers(userDto); //curriculumService.get(gson.fromJson(json, CurriculumDto.class));
		return  (object instanceof String) ? (String)object:gson.toJson(object);
	}
}
