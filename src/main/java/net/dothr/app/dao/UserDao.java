package net.dothr.app.dao;

import java.io.IOException;
import java.util.List;

import net.dothr.app.dto.aux.TourFromFile;
import net.dothr.app.dto.aux.UsuarioDto;

public interface UserDao {

	List<TourFromFile> getTours() throws IOException;
	
	List<UsuarioDto> getUsers(Long idEstatusInscripcion, Long idRol)  throws IOException;
}
