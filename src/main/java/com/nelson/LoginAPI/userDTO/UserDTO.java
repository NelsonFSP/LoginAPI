package com.nelson.LoginAPI.userDTO;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import com.nelson.LoginAPI.domain.User;


public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private String login;
	private String password;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User obj) {
		
		id = obj.getId();
		name = obj.getName();
		login = obj.getLogin();
		password = obj.getPassword();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
