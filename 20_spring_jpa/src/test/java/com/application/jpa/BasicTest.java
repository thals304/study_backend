package com.application.jpa;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.jpa.chapter01_basic.BasicRepository;
import com.application.jpa.data.Brand;

@SpringBootTest
public class BasicTest {

	@Autowired
	private BasicRepository basicRepository;

	@DisplayName(" - 데이터 전체조회 메뉴얼 - ")
	@Test
	public void getAllBrands() {
		
		System.out.println("\n - 브랜드 전체 조회 - \n");
		
		// findAll() : 테이블의 전체 데이터를 조회한다. = select *
		List<Brand> brands = basicRepository.findAll();
		
		for (Brand brand : brands) {
			System.out.println(brand);
		}
		
	}
	
	@DisplayName(" - 데이터 상세조회 메뉴얼 - ")
	@Test
	public void getBrandById() {
		
		System.out.println("\n - 브랜드 상세 조회 - \n");
		
		/*
		  
		   # findById(primary key) 
		   
		   - id(primary key)에 해당되는 데이터 조회한다.
		   - 예외처리 로직을 작성해야 한다.
		 
		 	  방법 1) orElse(); 메서드를 사용한다.
		 	  방법 2) Optional<Brand> 클래스를 사용한다.
		 
		 */
		
		// 예외처리 1) orElse();를 사용한다.
		Brand test1 = basicRepository.findById(1l).orElse(null);
		System.out.println(test1);
		// 예외처리 2) Optaional클래스를 사용한다. 
		Optional<Brand> test2 = basicRepository.findById(1l);
	}
	
	
	@DisplayName(" - 데이터 추가 메뉴얼 - ")
	@Test
	public void createBrand() {
		
		System.out.println("\n - 브랜드 추가 - \n");
	
		// save(entity); 새로운 엔티티를 데이터베이스에 추가한다. 하지만 이미 존재하는 엔티티의 경우 업데이트를 수행한다.
		Brand brand = new Brand();
		brand.setBrandId(100l);
		brand.setBrandNm("추가된브랜드100");
		brand.setActiveYn("N");
		brand.setEnteredDt(new Date());
		
		basicRepository.save(brand);
	
	}
	
	
	@DisplayName(" - 데이터 수정 메뉴얼 - ")
	@Test
	public void updateBrand() {
		
		System.out.println("\n - 브랜드 수정 - \n");
		
		/*
		  
		  	# save(entity);
		  	
		  	- 새로운 엔티티를 데이터베이스에 추가한다. 
		  	  하지만 이미 존재(primary key)하는 엔티티의 경우 업데이트를 수행한다.
		 
		  	- 데이터베이스 업데이트 절차
		  	
			1) findById(priamry key) 메서드를 사용하여 이미 저장되어 있는 데이터를 조회한다.
			2) 데이터를 수정한다.
			3) save(entity); 메서드를 사용하여 데이터베이스를 수정한다.
		  
		 */
		

		
		// 1) 기존에 저장되어 있는 데이터를 조회한다.
		Brand brand = basicRepository.findById(100l).orElse(null);
		
		// 2) 데이터를 수정한다.
		brand.setBrandNm("수정된 브랜드 100");
		brand.setEnteredDt(new Date());
		brand.setActiveYn("Y");
		
		// 3) save(entity); 메서드를 사용하여 데이터베이스를 수정한다.
		basicRepository.save(brand);
	}
	
	
	@DisplayName(" - 데이터 삭제 메뉴얼 - ")
	@Test
	public void deleteBrand() {
		
		System.out.println("\n - 브랜드 삭제 - \n");
		
		// deleteById(primary key); id(primary key)에 해당되는 데이터를 삭제한다.
		basicRepository.deleteById(100l);
	}
	
}
