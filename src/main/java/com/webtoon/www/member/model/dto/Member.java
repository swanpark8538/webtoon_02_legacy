package com.webtoon.www.member.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
//@Alias(value="member")
public class Member {

	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberNickName;
	private String memberName;
	private String memberEmail;
	private String memberPhone;
	private String memberAddress;
	private int memberBirthdate;
	private int memberGender; //추가함. 2n이면 여성, 2n-1이면 남성.
}
