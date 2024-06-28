package com.nfspdev.LoginAPI.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Setter
@Getter
@Builder
@AllArgsConstructor
@Document (collection = "user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private String login;
	private String password;
}
