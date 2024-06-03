package com.application.jpa.config;

import com.application.jpa.data.Brand;
import com.application.jpa.data.BrandDTO;

public class BrandMapper { // DTO <> Entity 매핑 클래스로 사용
	
	// DTO > Entity 매핑 예시
	public static Brand toEntity(BrandDTO brandDTO) {
		
		Brand brand = new Brand();
		brand.setBrandId(brandDTO.getBrandId());
		brand.setBrandNm(brandDTO.getBrandNm());
		brand.setEnteredDt(brandDTO.getEnteredDt());
		brand.setActiveYn(brandDTO.getActiveYn());
		
		return brand;
	}
	
	// Entity > DTO 매핑 예시
	public static BrandDTO toDTO(Brand brand) {
		
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setBrandId(brand.getBrandId());
		brandDTO.setBrandNm(brand.getBrandNm());
		brandDTO.setEnteredDt(brand.getEnteredDt());
		brandDTO.setActiveYn(brand.getActiveYn());
		
		return brandDTO;
	}
	// List<Entity> > List<DTO> 매핑 예시

}
