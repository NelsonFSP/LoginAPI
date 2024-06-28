package com.nfspdev.LoginAPI.userDTO;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import com.nfspdev.LoginAPI.domain.User;

@Getter
@Setter
@Builder
public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private String login;
	private String password;

	public User dtoToUser(){
		return User.builder()
				.id(id)
				.name(name)
				.login(login)
				.password(password)
				.build();
	}

}
