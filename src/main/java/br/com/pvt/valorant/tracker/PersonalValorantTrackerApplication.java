package br.com.pvt.valorant.tracker;

import br.com.pvt.valorant.tracker.service.ValorantApiClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class PersonalValorantTrackerApplication {

	@Autowired
	private ValorantApiClientService valorantApiClientService;

	public static void main(String[] args) {
		SpringApplication.run(PersonalValorantTrackerApplication.class, args);
	}
}
