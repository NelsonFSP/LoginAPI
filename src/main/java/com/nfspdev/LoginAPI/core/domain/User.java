package com.nfspdev.loginapi.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class User implements Serializable{

	@Serial
    private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String login;
	private String password;
}
