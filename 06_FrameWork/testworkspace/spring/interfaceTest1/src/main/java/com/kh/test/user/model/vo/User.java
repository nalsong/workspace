package com.kh.test.user.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

	
	private int memberNo;
	private String MemberId;
	private String MemberName;
	private int MemberAge;
}
