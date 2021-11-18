package net.dothr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DothrBaseApplication {

	private static final Logger log = LoggerFactory.getLogger(DothrBaseApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DothrBaseApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run() throws Exception {
		System.out.println("Using CommandLineRunner...");
		return args -> {
			log.trace("trace Enabled ");
			log.debug("debug Enabled");
			log.info("inform Enabled");
			log.warn("warn Enabled");
			log.error("error Enabled");
//			log.fatal("fatal Enabled"); //No existe en slf4j
		};
	}

}
