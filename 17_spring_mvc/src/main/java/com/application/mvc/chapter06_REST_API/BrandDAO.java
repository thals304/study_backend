package com.application.mvc.chapter06_REST_API;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.application.mvc.data.BrandDTO;

@Mapper
public interface BrandDAO {

	public List<BrandDTO> getBrandList(); 		  // 브랜드 전체조회
	public BrandDTO getBrandDetail(long brandId); // 브랜드 상세조회
	public void createBrand(BrandDTO brandDTO);	  // 브랜드 추가
	public void updateBrand(BrandDTO brandDTO);	  // 브랜드 수정
	public void deleteBrand(long brandId);		  // 브랜드 삭제
	
}
