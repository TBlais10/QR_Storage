package com.qr_storeage.QR_StoragePt2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class QrStoragePt2Application {

	public static void main(String[] args) {
		SpringApplication.run(QrStoragePt2Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}


}
