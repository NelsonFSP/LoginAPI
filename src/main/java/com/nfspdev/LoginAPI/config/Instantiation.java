package com.nfspdev.LoginAPI.config;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import com.nfspdev.LoginAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nfspdev.LoginAPI.domain.User;

@Configuration
@RequiredArgsConstructor
public class Instantiation implements CommandLineRunner{

	private final UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();

		User maria = User.builder()
						.id(null)
						.name("Maria Cicera")
						.login("MaCic")
						.password("132456").build();
		
		userRepository.saveAll(List.of(maria));
		
	}
}
