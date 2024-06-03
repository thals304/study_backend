package com.application.jpa.data;

import java.util.Date;

import lombok.Data;

@Data
public class BrandDTO {
	
	private Long brandId;
	private String brandNm;
	private Date enteredDt;
	private String activeYn;
}
