package com.application.jpa.chapter02_mapping;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.jpa.config.BrandMapper;
import com.application.jpa.config.ModelMapperConfig;
import com.application.jpa.data.Brand;
import com.application.jpa.data.BrandDTO;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository; // BrandRepository 객체 주입
	
	@Autowired
	private ModelMapper modelMapper; // ModelMapper 객체 주입
	
	@Override
	public List<BrandDTO> getAllBrands() {
		// 정적 메서드 매핑
		return BrandMapper.toDTOList(brandRepository.findAll());
		/*return brandRepository.findAll().stream() // 함수형 방식으로 처리할 수 있게반환
				.map(brand -> modelMapper.map(brand ,BrandDTO.class)) //각 Brand 객체를 BrandDTO 객체로 변환
				.collect(Collectors.toList()); // 변환된 BrandDTO 객체들을 리스트로 수집하여 List로 변환
		 */
	}

	@Override
	public BrandDTO getBrandById(Long brandId) {
		
		// brandId를 사용하여 entity타입으로 데이터를 조회
		Brand brand = brandRepository.findById(brandId).orElse(null);
		
		// 정적(static) 메서드 매핑
		return BrandMapper.toDTO(brand); // entity > DTO로 변환하여 컨트롤러로 return
		
		// ModelMapper 매핑
		//return modelMapper.map(brand , BrandDTO.class);
		
	}

	@Override
	public void createBrand(BrandDTO brandDTO) {
		
		// 정적 메서드 매핑
		 brandRepository.save(BrandMapper.toEntity(brandDTO)); // DTO > entity로 변환하여 데이터베이스로 전송
	
		// ModelMapper 매핑
		//brandRepository.save(modelMapper.map(brandDTO, Brand.class));
	
	}

	@Override
	public void updateBrand(Long brandId , BrandDTO brandDTO) {
		
		// 저장되어있는 데이터 조회
		Brand brand = brandRepository.findById(brandId).orElse(null);
		
		// 데이터 수정
		brand.setBrandNm(brandDTO.getBrandNm());
		brand.setEnteredDt(brandDTO.getEnteredDt());
		brand.setActiveYn(brandDTO.getActiveYn());
		
		// 업데이트
		brandRepository.save(brand);
		
	}

	@Override
	public void deleteBrand(Long brandId) {
		brandRepository.deleteById(brandId);
	}

}
