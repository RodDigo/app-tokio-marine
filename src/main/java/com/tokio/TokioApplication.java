package com.tokio;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.tokio.domain.Transferencia;

@SpringBootApplication
@EnableScheduling
public class TokioApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokioApplication.class, args);
	}
}
