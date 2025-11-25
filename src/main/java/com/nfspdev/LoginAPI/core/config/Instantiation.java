package com.nfspdev.loginAPI.core.config;


import com.nfspdev.loginAPI.adapters.IUserRepository;
import com.nfspdev.loginAPI.adapters.dto.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final IUserRepository userRepository;

    public Instantiation(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();

        UserEntity maria = new UserEntity(
                null
                ,"Maria Cicera"
                ,"MaCic"
                , "132456");

        userRepository.saveAll(List.of(maria));

    }
}
