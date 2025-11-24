package com.nfspdev.loginAPI.core.config;


import com.nelson.LoginAPI.repository.UserRepository;
import com.nfspdev.loginAPI.adapters.IUserRepository;
import com.nfspdev.loginAPI.core.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

@Configuration
@RequiredArgsConstructor
public class Instantiation implements CommandLineRunner{

	private final IUserRepository userRepository;

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
