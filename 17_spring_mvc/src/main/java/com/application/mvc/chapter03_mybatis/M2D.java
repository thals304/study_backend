package com.application.mvc.chapter03_mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.application.mvc.data.BrandDTO;
import com.application.mvc.data.ProductDTO;

@Mapper
public interface M2D {

	// List<DTO> 반환예시1 > m2dMapper.xml파일의 <select id="ex01" resultType="ProductDTO">와 매핑
	public List<ProductDTO> ex01();
	// List<DTO> 반환예시2 > m2dMapper.xml파일의 <select id="ex02" resultType="BrandDTO">와 매핑
	public List<BrandDTO> ex02();
	
	// DTO 반환 예시1 > m2dMapper.xml파일의 <select id="ex03" resultType="ProductDTO">와 매핑
	public ProductDTO ex03();
	// DTO 반환 예시2 > m2dMapper.xml파일의 <select id="ex04" resultType="BrandDTO">와 매핑
	public BrandDTO ex04();
	
	// 단일 데이터 반환 예시1 > m2dMapper.xml파일의 <select id="ex05" resultType="int">와 매핑
	public int ex05();
	// 단일 데이터 반환 예시2 > m2dMapper.xml파일의 <select id="ex06" resultType="double">와 매핑
	public double ex06();
	// 단일 데이터 반환 예시3 > m2dMapper.xml파일의 <select id="ex07" resultType="String">와 매핑
	public String ex07();
	
	// <![CDATA[]]> 사용예시  > m2dMapper.xml파일의 <select id="ex08" resultType="ProductDTO">와 매핑
	public List<ProductDTO> ex08();
	
	// map사용 예시          > m2dMapper.xml파일의 <select id="ex09" resultType="hashmap">와 매핑
	public List<Map<String , Object>> ex09();
	
	// resultMap 사용 예시1  > m2dMapper.xml파일의 <resultMap type="hashmap" id="priceMap">와 매핑
	public List<Map<String , Object>> ex10();
	// resultMap 사용 예시1  > m2dMapper.xml파일의 <resultMap type="hashmap" id="joinMap">와 매핑
	public List<Map<String, Object>> ex11();
}
