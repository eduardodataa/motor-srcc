package br.com.itau.integrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MotorSrccApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotorSrccApplication.class, args);
	}
}
