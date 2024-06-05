package com.application.jpa.data;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	private Long productId;
	private String productNm;
	private Integer price;
	private Integer deliveryPrice;
	private Date enrollDt;
	
	
}
