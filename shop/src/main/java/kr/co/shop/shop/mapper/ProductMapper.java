package kr.co.shop.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.shop.shop.dto.CategoryDto;
import kr.co.shop.shop.dto.ColorDto;

@Mapper
public interface ProductMapper {
	// 카테고리 검색
	List<CategoryDto> selectCategoryAll() throws Exception;
	
	// 색상 검색
	List<ColorDto> selectColorAll() throws Exception;
}
