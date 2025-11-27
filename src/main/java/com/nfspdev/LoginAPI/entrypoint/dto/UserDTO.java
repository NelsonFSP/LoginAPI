package com.nfspdev.loginapi.entrypoint.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String login;
	private String password;
}
