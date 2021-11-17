package net.dothr.app.serv;

import net.dothr.app.dto.DothrDto;

public interface _DemoService {

	//String ping(DothrDto dto);
	DothrDto ping(DothrDto dto);
	DothrDto get(DothrDto dto);
	DothrDto create(DothrDto dto);
	DothrDto read(DothrDto dto);
	DothrDto update(DothrDto dto);
	DothrDto delete(DothrDto dto);
	DothrDto aux(DothrDto dto);
}
