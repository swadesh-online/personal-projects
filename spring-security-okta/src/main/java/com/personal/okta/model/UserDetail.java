package com.personal.okta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {

	private String firstName;
	private String lastName;
	private String email;
	private String lastAccessed;
}
