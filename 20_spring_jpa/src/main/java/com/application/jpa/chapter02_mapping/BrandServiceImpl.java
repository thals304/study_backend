package com.application.jpa.chapter02_mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.jpa.config.BrandMapper;
import com.application.jpa.data.Brand;
import com.application.jpa.data.BrandDTO;
@Service
public class BrandServiceImpl implements BrandService {

	// DTO로 들어 온 것을 Entity로 바꿔줘야 하고, Entity로 나가는 것은 DTO로 바꿔 나가야함
	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public List<BrandDTO> getAllBrands() {
		
		return null;
	}

	@Override
	public BrandDTO getBrandById(Long brandId) {
		// brandId를 사용하여 entity 타입으로 데이터를 조회
		Brand brand = brandRepository.findById(brandId).orElse(null);
		
		// 정적(static) 메서드 매핑
		return BrandMapper.toDTO(brand); // entity > DTO로 변환하여 컨트롤러로 return
		
	}

	@Override
	public void createBrand(BrandDTO brandDTO) {
		// 정적 메서드 매핑
		brandRepository.save(BrandMapper.toEntity(brandDTO));
	}

	@Override
	public void updateBrand(BrandDTO brandDTO) {
		
		// 정적 메서드 매핑
		brandRepository.save(BrandMapper.toEntity(brandDTO));
	
	}

	@Override
	public void deleteBrand(Long brandId) {
		
	}

}
