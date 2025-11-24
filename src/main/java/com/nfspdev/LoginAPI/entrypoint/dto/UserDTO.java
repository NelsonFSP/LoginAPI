package com.nfspdev.loginAPI.entrypoint.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import com.nfspdev.loginAPI.core.domain.User;

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
}
