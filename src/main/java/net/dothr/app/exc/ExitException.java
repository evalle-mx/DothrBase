package net.dothr.app.exc;
/* https://examples.javacodegeeks.com/enterprise-java/slf4j/slf4j-spring-boot-example/ */
import org.springframework.boot.ExitCodeGenerator;

public class ExitException extends RuntimeException implements ExitCodeGenerator {
	
	private static final long serialVersionUID = 8358829093628638202L;

	@Override
	public int getExitCode() {
		return 10;
	}

}
