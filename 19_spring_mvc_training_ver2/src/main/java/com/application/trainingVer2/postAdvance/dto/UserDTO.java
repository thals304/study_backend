package com.application.trainingVer2.postAdvance.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDTO {

	private String userId;
	private String nickname;
	private String passwd;
	private String profileOriginalName;
	private String profileUUID;
	private String email;
	private String role;
	private Date joinAt;
	
}
