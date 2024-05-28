package com.application.mvc.chapter06_REST_API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.mvc.data.BrandDTO;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandDAO brandDAO;
	
	@GetMapping // 브랜드 데이터 전체 요청
	// 이미 RestController 어노테이션에 ResponseBody가 포함됨
	public List<BrandDTO> getBrandList(){
		return brandDAO.getBrandList(); // brand.html 파일에 List<BrandDTO> 데이터 전송
	}
	
	@GetMapping("/{brandId}") // 브랜드 디테일 데이터 요청
	public BrandDTO getBrandDetail(@PathVariable("brandId") long brandId) {
		return brandDAO.getBrandDetail(brandId); // brand.html파일에 BrandDTO 데이터 전송
	}
	
	@PostMapping
	public void updateBrand(@RequestBody BrandDTO brandDTO) { // 브랜드 추가 요청
		brandDAO.createBrand(brandDTO); // DAO객체로 DTO전송
	}
	
	@PutMapping("/{brandId}") // 브랜드 수정 요청
	public void updateBrand(@PathVariable("brandId") long brandId ,
			                @RequestBody BrandDTO brandDTO) {
		
		brandDTO.setBrandId(brandId);
		
		brandDAO.updateBrand(brandDTO); // DAO객체로 DTO전송
	}
	
	@DeleteMapping("/{brandId}") // 브랜드 삭제 요청
	public void deleteBrand(@PathVariable("brandId") long brandId) {
		brandDAO.deleteBrand(brandId);  // DAO객체로 brandId전송
	}
	
	
}
