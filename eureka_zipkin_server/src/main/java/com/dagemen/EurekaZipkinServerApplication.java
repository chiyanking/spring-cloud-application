package com.dagemen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@ComponentScan("com.dagemen")
@EnableZipkinServer
public class EurekaZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaZipkinServerApplication.class, args);
	}
}
