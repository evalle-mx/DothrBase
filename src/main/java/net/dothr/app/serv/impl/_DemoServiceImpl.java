package net.dothr.app.serv.impl;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import net.dothr.app.dao.UserDao;
import net.dothr.app.dto.DothrDto;
import net.dothr.app.dto.aux.TourFromFile;
import net.dothr.app.serv._DemoService;
import net.dothr.util.Mensaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Service
//@Transactional
public class _DemoServiceImpl implements _DemoService {
	
	static final Logger log4j = LogManager.getLogger( _DemoServiceImpl.class );

	@Autowired
	UserDao userDao;
	
	/**
	 * Usar este metodo para cuando se requiera hacer alguna prueba, activandolo en el controlador/adapter Respectivo
	 */
	@Override
	public DothrDto aux(DothrDto dto) {
		if(dto!=null) {
			System.out.println("<aux> dto: "+ dto);
			log4j.debug("<aux> dto: "+ dto);			
			try {				
				List<TourFromFile> lsTours = userDao.getTours();
				if(lsTours !=null && !lsTours.isEmpty()) {
					System.out.println("Encontrados " + lsTours.size() + " tours");
					lsTours.stream().forEach( tour -> {
						System.out.println("Titulo: "+ tour.getTitle() +", Nombre paquete: " + tour.getPackageName()
								+", detalles: " + tour.getDetails().toString()
								);
					});
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		dto.setCode(String.valueOf(HttpStatus.OK));
		dto.setType("I");
		dto.setMessage("AUX OK");
		return dto;
	}
	
	@Override
	public DothrDto ping(DothrDto dto) {
		if(dto!=null) {
			System.out.println("<ping> dto: "+ dto);
			log4j.debug("<ping> dto: "+ dto);
		}
		dto.setCode(String.valueOf(HttpStatus.OK));
		dto.setType("I");
		dto.setMessage("PING: OnLine");
		return dto;
	}

	@Override
	public DothrDto get(DothrDto dto) {
		if(dto!=null) {
			System.out.println("<get> dto: "+ dto);
			log4j.debug("<get> dto: "+ dto);
		}
		dto.setCode(String.valueOf(HttpStatus.OK));
		dto.setType("W"); dto.setMessage( Mensaje.DISABLED_METHOD + ":GET");
		return dto;
	}
	
	@Override
	public DothrDto create(DothrDto dto) {
		if(dto!=null) {
			System.out.println("<create> dto: "+ dto);
			log4j.debug("<create> dto: "+ dto);
		}
		dto.setCode(String.valueOf(HttpStatus.CREATED));
		dto.setType("W"); dto.setMessage( Mensaje.DISABLED_METHOD + ":CREATED");
		return dto;
	}

	@Override
	public DothrDto read(DothrDto dto) {
		if(dto!=null) {
			System.out.println("<read> dto: "+ dto);
			log4j.debug("<read> dto: "+ dto);
		}
		dto.setCode(String.valueOf(HttpStatus.OK));
		dto.setType("W"); dto.setMessage( Mensaje.DISABLED_METHOD + ":READ");
		return dto;
	}
	
	@Override
	public DothrDto update(DothrDto dto) {
		if(dto!=null) {
			System.out.println("<update> dto: "+ dto);
			log4j.debug("<update> dto: "+ dto);
		}
		dto.setCode(String.valueOf(HttpStatus.ACCEPTED));
		dto.setType("W"); dto.setMessage( Mensaje.DISABLED_METHOD + ":UPDATE");
		return dto;
	}
	
	@Override
	public DothrDto delete(DothrDto dto) {
		if(dto!=null) {
			System.out.println("<delete> dto: "+ dto);
			log4j.debug("<delete> dto: "+ dto);
		}
		dto.setCode(String.valueOf(HttpStatus.OK));
		dto.setType("W"); dto.setMessage( Mensaje.DISABLED_METHOD + ":DELETE");
		return dto;
	}
	
}
