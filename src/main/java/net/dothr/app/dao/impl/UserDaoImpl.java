package net.dothr.app.dao.impl;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import net.dothr.app.dao.UserDao;
import net.dothr.app.dto.aux.TourFromFile;
import net.dothr.app.dto.aux.UsuarioDto;

//Static imports
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;


@Service
public class UserDaoImpl extends _AbstractDao implements UserDao {
	
	@Value("${ec.importfile}")
    private String importFile;
	@Value("${adm.users}")
    private String adm_users;
	
	private List<UsuarioDto> lsUsuarioDto;
	
	//Logger log4j = LogManager.getLogger( this.getClass());
	private static final Logger log4j = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	public List<TourFromFile> getTours() throws IOException {
		log4j.debug("<getTours> ...");
		return readTours(importFile);
	}
	
	
	/* Predicados para filtros opcionales */
	public Predicate<UsuarioDto> fIdEstatus(String sIdEstatus) {
	    return (UsuarioDto usr) -> {
	      return usr.getIdEstatusInscripcion().equals(sIdEstatus);
	    };
	}
	public Predicate<UsuarioDto> fIdRol(String sIdRol) {
	    return (UsuarioDto usr) -> {
	      return usr.getIdRol()!=null?usr.getIdRol().equals(sIdRol):false; //En caso que el Dto no contenga el dato
	    };
	}
    

	@Override
	public List<UsuarioDto> getUsers(Long idEstatusInscripcion, Long idRol) {
		log4j.debug("<getUsers> ...");
		try {
			/* filtrar por los parametros si existen */
			Predicate<UsuarioDto> usrFilter;
			
			if(idEstatusInscripcion!=null || idRol!=null ) {
				if(idEstatusInscripcion!=null && idRol!=null) { //Dos filtros
					usrFilter = fIdEstatus(String.valueOf(idEstatusInscripcion)).and(fIdRol(String.valueOf(idRol)));
				}
				else if(idEstatusInscripcion!=null && idRol==null) { //Solo IdInscripcion
					usrFilter = fIdEstatus(String.valueOf(idEstatusInscripcion));
				}
				else { //Solo idRol
					usrFilter = fIdRol(String.valueOf(idRol));
				}
				lsUsuarioDto = readUsuarios().stream().filter(  usrFilter ).collect(Collectors.toList());
			}
			else { //Sin filtros
				lsUsuarioDto = readUsuarios();
			}
			System.out.println("Se encontraron " + lsUsuarioDto.size() + " usuarios");
			log4j.debug("Se encontraron " + lsUsuarioDto.size() + " usuarios");
		} catch (IOException e) {
			e.printStackTrace();
			//log4j.error(e);
			log4j.error( String.valueOf(e) );
			lsUsuarioDto = null;
		}
		
		return lsUsuarioDto;
	}
	
	private List<TourFromFile> readTours(String fileToImport) throws IOException {
    	System.out.println("Reading from file " + fileToImport + " to map as List<Map<String, String>>");
    	/*/Codigo para leer como MAP (MongoDB)
    	System.out.println("Reading from file " + fileToImport + " to map as List<Map<String, String>>");
        List<Map<String, String>> records = new ObjectMapper().setVisibility(FIELD, ANY).
                readValue(new FileInputStream(fileToImport),
                        new TypeReference<List<Map<String, String>>>() {});
        return records.stream().map(TourFromFile::new)
                .collect(Collectors.toList()); //*/
    	return new ObjectMapper().setVisibility(FIELD, ANY).
                readValue(new FileInputStream(fileToImport), new TypeReference<List<TourFromFile>>() {});
    }
	
	private List<UsuarioDto> readUsuarios() throws IOException {
		log4j.debug("leyendo el archivo en proyecto local " + adm_users + " ");
    	return new ObjectMapper().setVisibility(FIELD, ANY).
                readValue(new FileInputStream(adm_users), new TypeReference<List<UsuarioDto>>() {});
    }

}
