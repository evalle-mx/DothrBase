package net.dothr.app.serv;

import java.io.IOException;
import java.util.List;

import net.dothr.app.dto.AdminDto;
import net.dothr.app.dto.MenuDto;
import net.dothr.app.dto.aux.UsuarioDto;

public interface AdminService {

	String setAdmin(AdminDto admindto)  throws Exception;
	List<UsuarioDto> getUsers(UsuarioDto userDto) throws IOException;
	
	
	String menu(MenuDto menuDto);
	
	
//	String lastDateFinalSyncDocs(ControlProcesoDto  controlProceso)throws Exception;
//	String lastDateFinalRemodel(ControlProcesoDto controlProcesoDto) throws Exception ;
//	String lastDateFinalReloadCoreSolr(ControlProcesoDto controlProcesoDto) throws Exception;
//	String lastDateFinalReclassDocs(ControlProcesoDto controlProcesoDto) throws Exception;
//	
//	String ping(AdminDto adminDto);
//	String bitacoraPosicion(Object object)  throws Exception;
//	String bitacoraTracking(Object object,BtcTrackingDto btcTrackingDto)  throws Exception;
//	RelacionEmpresaPersona getRelacionEmpresaPersona(String idPersona, String idEmpresaConf);
//	PerfilPosicion getPerfilPosicion(String IdPosicion);
//	String changeEmailToTest(AdminDto admindto);
}
