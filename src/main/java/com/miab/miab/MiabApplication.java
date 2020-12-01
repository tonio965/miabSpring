package com.miab.miab;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.miab.services.AppplicationService;

@SpringBootApplication(scanBasePackages={
"com.miab.*"})
@EnableJpaRepositories(basePackages = "com.miab.repository")
@EntityScan(basePackages = "com.miab.model")
public class MiabApplication implements CommandLineRunner {

	@Autowired
	private AppplicationService applicationService;
	
	private static Logger LOG = Logger
		      .getLogger(MiabApplication.class.getName());
	
	public static void main(String[] args) {
		LOG.log(Level.INFO, "start");
		SpringApplication.run(MiabApplication.class, args);
		LOG.log(Level.INFO, "finish");
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.log(Level.INFO, "run");
		applicationService.runApp();
		
	}

}
