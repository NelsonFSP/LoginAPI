package com.nelson.LoginAPI.domain;

import java.io.Serializable;

import com.nelson.LoginAPI.userDTO.UserDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Builder
@Document (collection = "user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private String login;
	private String password;

	public UserDTO fromUserToDTo (){
		return UserDTO.builder()
				.id(id)
				.name(name)
				.login(login)
				.password(password)
				.build();
	}
}
