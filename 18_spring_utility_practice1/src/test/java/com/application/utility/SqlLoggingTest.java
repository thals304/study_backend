package com.application.utility;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.utility.chapter01_sqlLogging.SqlLoggingDAO;

@SpringBootTest
public class SqlLoggingTest {

	@Autowired
	private SqlLoggingDAO sqlLoggingDAO;
	
	@Test
	@DisplayName("브랜드 전체조회 테스트")
	public void getBrandList() {
		sqlLoggingDAO.getBrandList();
	}
	
	@Test
	@DisplayName("브랜드 상세조회 테스트")
	public void getBrandDetail() {
		long brandId = 1;
		sqlLoggingDAO.getBrandDetail(brandId);
	}
	
	@Test
	@DisplayName("브랜드 추가 테스트")
	public void createBrand() {
		Map<String, Object> brandMap = new HashMap<String, Object>();
		brandMap.put("brandId", 100);
		brandMap.put("brandNm", "추가된브랜드");
		brandMap.put("activeYn", "Y");
		sqlLoggingDAO.createBrand(brandMap);
	}
	
	@Test
	@DisplayName("브랜드 수정 테스트")
	public void updateBrand() {
		Map<String, Object> brandMap = new HashMap<String, Object>();
		brandMap.put("brandId", 100);
		brandMap.put("brandNm", "추가된브랜드1");
		sqlLoggingDAO.updateBrand(brandMap);
	}
	
	@Test
	@DisplayName("브랜드 삭제 테스트")
	public void deleteBrand() {
		long brandId = 100;
		sqlLoggingDAO.deleteBrand(brandId);
	}

	
}
