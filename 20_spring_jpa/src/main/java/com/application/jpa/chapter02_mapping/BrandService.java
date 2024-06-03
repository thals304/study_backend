package com.application.jpa.chapter02_mapping;

import java.util.List;

import com.application.jpa.data.BrandDTO;

public interface BrandService {

	public List<BrandDTO> getAllBrands(); 		// 브랜드 전체조회
	public BrandDTO getBrandById(Long brandId); // 브랜드 상세조회
	public void createBrand(BrandDTO brandDTO); // 브랜드 추가
	public void updateBrand(BrandDTO brandDTO); // 브랜드 수정
	public void deleteBrand(Long brandId);		// 브랜드 삭제
	
}
