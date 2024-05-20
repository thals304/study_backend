package com.application.utility.chapter01_sqlLogging;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SqlLoggingDAO {

	public List<Map<String,Object>> getBrandList();
	public Map<String,Object> getBrandDetail(long brandId);
	public void createBrand(Map<String,Object> brandMap);
	public void updateBrand(Map<String,Object> brandMap);
	public void deleteBrand(long brandId);
	
}
