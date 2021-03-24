package br.com.tony.springaoplogging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class LoggerApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoggerApplication.class, args);
	}
}
