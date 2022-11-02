package com.nelson.LoginAPI.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nelson.LoginAPI.domain.User;
import com.nelson.LoginAPI.repository.UserRepository;

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
