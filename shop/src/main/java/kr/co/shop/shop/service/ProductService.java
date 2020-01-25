package kr.co.shop.shop.service;

import java.util.List;

import kr.co.shop.shop.dto.CategoryDto;
import kr.co.shop.shop.dto.ColorDto;

public interface ProductService {
	// 카테고리 검색
	List<CategoryDto> selectCategoryAll() throws Exception;
	
	// 색상 검색
	List<ColorDto> selectColorAll() throws Exception;
}
