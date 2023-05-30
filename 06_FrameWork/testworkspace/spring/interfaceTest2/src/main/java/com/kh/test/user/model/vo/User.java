package com.kh.test.user.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Setter
@Getter
public class User {
	
	private int UserNumber;
	private String UserId;
	private String UserName;
	private int UserAge;
}
