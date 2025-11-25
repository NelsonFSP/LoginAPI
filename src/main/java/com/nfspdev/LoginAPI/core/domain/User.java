package com.nfspdev.loginAPI.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class User implements Serializable{

	@Serial
    private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private String login;
	private String password;
}
