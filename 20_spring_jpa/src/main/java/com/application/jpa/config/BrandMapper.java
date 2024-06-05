package com.application.jpa.config;

import java.util.List;
import java.util.stream.Collectors;

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
	public static List<BrandDTO> toDTOList(List<Brand> brands){
		/*
		 
		객체.stream() : 스트림변환
		 
			- 객체.stream()을 통해 객체들의 스트림(Stream)을 생성한다.
			- 스트림은 자바 8부터 도입된 컬렉션을 효율적으로 처리하기 위한 API이다.
	
		.map(BrandMapper::toDTO) : 매핑
		
			- 구문은 각 entity 객체를 DTO 객체로 변환하는 작업을 수행한다. 
		 	-  BrandMapper::toDTO는 메소드 레퍼런스로, BrandMapper 클래스에 정의된 toDTO 메소드를 각 Brand 객체에 적용한다.
		
		.collect(Collectors.toList()) : 결과 수집
		
			- 스트림을 통해 변환된 BrandDTO 객체들을 새로운 리스트로 수집한다.

	 */
		//return brands.stream().map(BrandMapper::toDTO).collect(Collectors.toList());
		return brands.stream().
				map(BrandMapper::toDTO).
				collect(Collectors.toList());
	}

}
